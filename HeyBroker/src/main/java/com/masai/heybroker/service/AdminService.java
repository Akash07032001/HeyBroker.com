package com.masai.heybroker.service;

import com.masai.heybroker.exception.AdminException;
import com.masai.heybroker.exception.BrokerException;
import com.masai.heybroker.exception.CustomerException;
import com.masai.heybroker.model.Admin;
import com.masai.heybroker.model.Broker;
import com.masai.heybroker.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdminService {
    public Admin createAdmin(Admin admin)throws AdminException;

    public Admin updateAdmin(Admin admin, String key) throws AdminException;

    public Customer removeCustomer(String key , Integer cId) throws CustomerException;

    public Broker removeBroker(String key , Integer bId) throws BrokerException;


    public List<Customer> getAllCustomer(String key) throws CustomerException;

    public List<Broker> getAllBroker(String key) throws BrokerException;

    public Customer getCustomerById(String key , Integer cId) throws CustomerException;

    public Broker getBrokerById(String key , Integer bId)throws BrokerException;

}
