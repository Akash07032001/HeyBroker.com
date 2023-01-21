package com.masai.heybroker.service;

import com.masai.heybroker.exception.BrokerException;
import com.masai.heybroker.exception.CustomerException;
import com.masai.heybroker.exception.LoginException;
import com.masai.heybroker.exception.PropertyException;
import com.masai.heybroker.model.Broker;
import com.masai.heybroker.model.Customer;
import com.masai.heybroker.model.Property;

public interface BrokerService {
	 public Broker registerBroker(Broker broker)throws BrokerException;

	    public Broker updateBroker(Broker broker , String key) throws BrokerException;

		public Property registerProperty(Property property,String key) throws PropertyException, LoginException;
}
