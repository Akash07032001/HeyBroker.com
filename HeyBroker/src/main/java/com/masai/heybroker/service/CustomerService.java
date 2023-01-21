package com.masai.heybroker.service;

import com.masai.heybroker.exception.AdminException;
import com.masai.heybroker.exception.BrokerException;
import com.masai.heybroker.exception.CustomerException;
import com.masai.heybroker.exception.LoginException;
import com.masai.heybroker.exception.PropertyException;
import com.masai.heybroker.model.Admin;
import com.masai.heybroker.model.Customer;
import com.masai.heybroker.model.Property;

import java.util.List;

public interface CustomerService {
    public Customer createCustomer(Customer customer)throws CustomerException;

    public Customer updateCustomer(Customer customer, String key) throws CustomerException,LoginException;

    public Customer getProfile(String key)  throws LoginException;

    public List<Property> viewPropertyByPropertyType(String key, String propertyType) throws PropertyException, LoginException;
    
	public List<Property> viewAllProperty(String key) throws PropertyException,LoginException,CustomerException;

}
