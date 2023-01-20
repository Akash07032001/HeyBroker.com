package com.masai.heybroker.service;

import com.masai.heybroker.exception.AdminException;
import com.masai.heybroker.exception.CustomerException;
import com.masai.heybroker.model.Admin;
import com.masai.heybroker.model.AdminCurrentSesssion;
import com.masai.heybroker.model.Customer;
import com.masai.heybroker.model.CustomerCurrentSession;
import com.masai.heybroker.repository.CustomerDao;
import com.masai.heybroker.repository.CustomerSessionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private CustomerSessionDao customerSessionDao;



    @Override
    public Customer createCustomer(Customer customer) throws CustomerException {
        Customer existingCustomer = customerDao.findByEmail(customer.getEmail());



        if(existingCustomer!=null) throw new CustomerException("Customer already registered with email "+customer.getEmail());

        return customerDao.save(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer, String key) throws CustomerException {

        CustomerCurrentSession logeedInUser = customerSessionDao.findByCid(key);

        if(logeedInUser==null) throw new CustomerException("Please provide valid key to update customer");

        if(customer.getCustomerId()==logeedInUser.getCustomerId()){

            return customerDao.save(customer);
        }else throw new CustomerException("Invalid customer details please log in first");
    }

    @Override
    public Customer getProfile(String key) throws CustomerException {

        CustomerCurrentSession customerCurrentSession =customerSessionDao.findByCid(key);

        if(customerCurrentSession==null) throw new CustomerException("please login first");

        Optional<Customer> opt= customerDao.findById(customerCurrentSession.getCustomerId());

        return opt.get();
    }
}
