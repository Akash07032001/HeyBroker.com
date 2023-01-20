package com.masai.heybroker.service;

import com.masai.heybroker.exception.BrokerException;
import com.masai.heybroker.exception.CustomerException;
import com.masai.heybroker.model.Broker;
import com.masai.heybroker.model.BrokerCurrentSession;
import com.masai.heybroker.model.Customer;
import com.masai.heybroker.model.CustomerCurrentSession;
import com.masai.heybroker.repository.BrokerDao;
import com.masai.heybroker.repository.BrokerSessionDao;
import com.masai.heybroker.repository.CustomerDao;
import com.masai.heybroker.repository.CustomerSessionDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrokerServiceImpl implements BrokerService {

	 	@Autowired
	    private BrokerDao brokerDao;
	    @Autowired
	    private BrokerSessionDao brokerSessionDao;

	
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
   
}
