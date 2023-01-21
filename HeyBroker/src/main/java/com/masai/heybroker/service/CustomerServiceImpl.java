package com.masai.heybroker.service;

import com.masai.heybroker.exception.AdminException;
import com.masai.heybroker.exception.BrokerException;
import com.masai.heybroker.exception.CustomerException;
import com.masai.heybroker.exception.LoginException;
import com.masai.heybroker.exception.PropertyException;
import com.masai.heybroker.model.*;
import com.masai.heybroker.repository.CustomerDao;
import com.masai.heybroker.repository.CustomerSessionDao;
import com.masai.heybroker.repository.PropertyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private CustomerSessionDao customerSessionDao;

    @Autowired
    private PropertyDao propertyDao;



    @Override
    public Customer createCustomer(Customer customer) throws CustomerException {
        Customer existingCustomer = customerDao.findByEmail(customer.getEmail());



        if(existingCustomer!=null) throw new CustomerException("Customer already registered with email "+customer.getEmail());

        return customerDao.save(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer, String key) throws CustomerException,LoginException {

        CustomerCurrentSession logeedInUser = customerSessionDao.findByCid(key);

        if(logeedInUser==null) throw new LoginException("Please provide valid key to update customer");

        if(customer.getCustomerId()==logeedInUser.getCustomerId()){

            return customerDao.save(customer);
        }else throw new CustomerException("Invalid customer details please log in first");
    }

    @Override
    public Customer getProfile(String key) throws LoginException {

        CustomerCurrentSession customerCurrentSession =customerSessionDao.findByCid(key);

        if(customerCurrentSession==null) throw new LoginException("please login first");

        Optional<Customer> opt= customerDao.findById(customerCurrentSession.getCustomerId());

        return opt.get();
    }

    @Override
    public List<Property> viewPropertyByPropertyType(String key, String prpType) throws PropertyException,LoginException {

        CustomerCurrentSession customerCurrentSession =customerSessionDao.findByCid(key);

        if(customerCurrentSession==null) throw new LoginException("please login first");

        PropertyType obj=PropertyType.valueOf(prpType);

        List<Property> propertyList=propertyDao.findByPropertyType(obj);
        if(propertyList.isEmpty()) throw new PropertyException("property not found with given property type");

        return propertyList;

    }

	@Override
	public List<Property> viewAllProperty(String key) throws PropertyException, LoginException, CustomerException {
		// TODO Auto-generated method stub
		CustomerCurrentSession logeedInUser = customerSessionDao.findByCid(key);

		if(logeedInUser==null) throw new LoginException("Please Login first");

		
		List<Property> properties =propertyDao.findAll();

		if(properties.isEmpty()) throw new PropertyException("No Properties available for now");

		return properties;
	}
}
