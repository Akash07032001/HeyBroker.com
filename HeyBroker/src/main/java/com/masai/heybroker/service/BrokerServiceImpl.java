package com.masai.heybroker.service;

import com.masai.heybroker.exception.*;
import com.masai.heybroker.model.*;
import com.masai.heybroker.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BrokerServiceImpl implements BrokerService {

	 	@Autowired
	    private BrokerDao brokerDao;
	    @Autowired
	    private BrokerSessionDao brokerSessionDao;
		@Autowired
		private PropertyDao propertyDao;
	
	@Override
	public Broker registerBroker(Broker broker) throws BrokerException {
		// TODO Auto-generated method stub
		 Broker existingBroker = brokerDao.findByBrokerEmail(broker.getBrokerEmail());



	        if(existingBroker!=null) throw new BrokerException("Broker already registered with email "+broker.getBrokerEmail());

	        return brokerDao.save(broker);
	}

	@Override
	public Broker updateBroker(Broker broker, String key) throws BrokerException {
		// TODO Auto-generated method stub
	BrokerCurrentSession logeedInUser = brokerSessionDao.findByBid(key);

        if(logeedInUser==null) throw new BrokerException("Please provide valid key to update Broker");

        if(broker.getBrokerId()==logeedInUser.getBrokerId()){

            return brokerDao.save(broker);
        }else throw new BrokerException("Invalid Broker details please log in first");
    }

	@Override
	public Property registerProperty(Property property, String key) throws PropertyException, LoginException {

		BrokerCurrentSession logeedInUser = brokerSessionDao.findByBid(key);

		if(logeedInUser==null) throw new LoginException("Please Login first");

		Optional<Broker> opt= brokerDao.findById(logeedInUser.getBrokerId());

		Broker broker=opt.get();

		broker.getProperties().add(property);

		property.setBroker(broker);

		brokerDao.save(broker);

		return property;
	}

	@Override
	public Property editProperty(Property property, String key) throws PropertyException, LoginException {

		BrokerCurrentSession logeedInUser = brokerSessionDao.findByBid(key);

		if(logeedInUser==null) throw new LoginException("Please Login first");

		Optional<Property> opt= propertyDao.findById(property.getPropId());

		if(!opt.isPresent()) throw new PropertyException("property does not exist with proerty id "+property.getPropId());


		Optional<Broker> opt1= brokerDao.findById(logeedInUser.getBrokerId());

		Broker broker=opt1.get();

		broker.getProperties().add(property);

		property.setBroker(broker);

		brokerDao.save(broker);

		return property;
	}

	@Override
	public Property removeProperty(Integer id, String key) throws PropertyException, LoginException {

		BrokerCurrentSession logeedInUser = brokerSessionDao.findByBid(key);

		if(logeedInUser==null) throw new LoginException("Please Login first");

		Optional<Property> opt= propertyDao.findById(id);

		if(!opt.isPresent()) throw new PropertyException("property does not exist wiht property id "+id);

		Property property=opt.get();
		propertyDao.delete(property);

		return property;
	}

	@Override
	public List<Property> viewAllProperty(Integer id, String key) throws PropertyException, LoginException, BrokerException {

		BrokerCurrentSession logeedInUser = brokerSessionDao.findByBid(key);

		if(logeedInUser==null) throw new LoginException("Please Login first");

		Optional<Broker> opt= brokerDao.findById(id);

		if (!opt.isPresent()) throw new BrokerException("broker does not exist with broker id "+id);

		Broker broker=opt.get();

		List<Property> properties =broker.getProperties();

		if(properties.isEmpty()) throw new PropertyException("broker does not have any property");

		return properties;
	}

	@Override
	public List<Deal> viewAllDeals(String key) throws LoginException, DealException {
		BrokerCurrentSession logeedInUser = brokerSessionDao.findByBid(key);

		if (logeedInUser == null) throw new LoginException("Please Login first");

		Optional<Broker> broker = brokerDao.findById(logeedInUser.getBrokerId());

		List<Deal> deals = broker.get().getDeals();

		if (deals.isEmpty()) throw new DealException("No any deal in your portfolio");

		return deals;
	}

}
