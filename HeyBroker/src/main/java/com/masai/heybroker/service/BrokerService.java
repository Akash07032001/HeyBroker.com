package com.masai.heybroker.service;

import com.masai.heybroker.exception.BrokerException;
import com.masai.heybroker.exception.CustomerException;
import com.masai.heybroker.exception.LoginException;
import com.masai.heybroker.exception.PropertyException;
import com.masai.heybroker.model.Broker;
import com.masai.heybroker.model.Customer;
import com.masai.heybroker.model.Property;

import java.util.List;

public interface BrokerService {
	 public Broker registerBroker(Broker broker)throws BrokerException;

	    public Broker updateBroker(Broker broker , String key) throws BrokerException;

		public Property registerProperty(Property property,String key) throws PropertyException, LoginException;

		public Property editProperty(Property property,String key) throws PropertyException,LoginException;

		public Property removeProperty(Integer id,String key) throws PropertyException,LoginException;

		public List<Property> viewAllProperty(Integer id,String key) throws PropertyException,LoginException,BrokerException;
}
