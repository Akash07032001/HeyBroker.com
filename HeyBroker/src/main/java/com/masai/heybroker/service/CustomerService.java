package com.masai.heybroker.service;

import com.masai.heybroker.exception.*;
import com.masai.heybroker.model.Admin;
import com.masai.heybroker.model.Customer;
import com.masai.heybroker.model.Deal;
import com.masai.heybroker.model.Property;

import java.util.List;

public interface CustomerService {
    public Customer createCustomer(Customer customer)throws CustomerException;

    public Customer updateCustomer(Customer customer, String key) throws CustomerException,LoginException;

    public Customer getProfile(String key)  throws LoginException;

    public List<Property> viewPropertyByPropertyType(String key, String propertyType) throws PropertyException, LoginException;
    
	public List<Property> viewAllProperty(String key) throws PropertyException,LoginException,CustomerException;

    public Deal addDeal(Integer propid , String key) throws PropertyException,LoginException;

    public List<Deal> viewAllDeals(String key)throws LoginException, DealException;
}
