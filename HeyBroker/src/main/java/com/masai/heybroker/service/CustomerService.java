package com.masai.heybroker.service;

import com.masai.heybroker.exception.AdminException;
import com.masai.heybroker.exception.CustomerException;
import com.masai.heybroker.model.Admin;
import com.masai.heybroker.model.Customer;

public interface CustomerService {
    public Customer createCustomer(Customer customer)throws CustomerException;

    public Customer updateCustomer(Customer customer, String key) throws CustomerException;

    public Customer getProfile(String key)  throws CustomerException;
}
