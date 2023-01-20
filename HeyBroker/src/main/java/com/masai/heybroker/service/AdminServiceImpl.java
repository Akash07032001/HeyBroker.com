package com.masai.heybroker.service;

import com.masai.heybroker.exception.AdminException;
import com.masai.heybroker.exception.BrokerException;
import com.masai.heybroker.exception.CustomerException;
import com.masai.heybroker.model.Admin;
import com.masai.heybroker.model.AdminCurrentSesssion;
import com.masai.heybroker.model.Broker;
import com.masai.heybroker.model.Customer;
import com.masai.heybroker.repository.AdminDao;
import com.masai.heybroker.repository.AdminSessionDao;
import com.masai.heybroker.repository.BrokerDao;
import com.masai.heybroker.repository.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService{
    @Autowired
    private AdminDao adminDao;
    @Autowired
    private AdminSessionDao adminSessionDao;

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private BrokerDao brokerDao;
    @Override
    public Admin createAdmin(Admin admin) throws AdminException {
        Admin existingAdmin = adminDao.findByEmail(admin.getEmail());

        if(existingAdmin!=null) throw new AdminException("Admin already registered with email "+admin.getEmail());

        return adminDao.save(admin);
    }

    @Override
    public Admin updateAdmin(Admin admin, String key) throws AdminException {

        AdminCurrentSesssion logeedInUser = adminSessionDao.findByAid(key);

        if(logeedInUser==null) throw new AdminException("Please provide valid key to update admin");

        if(admin.getAdminId()==logeedInUser.getAdminId()){

            return adminDao.save(admin);
        }else throw new AdminException("Invalid admin details please log in first");
    }

    @Override
    public Customer removeCustomer(String key, Integer cId) throws CustomerException {

        AdminCurrentSesssion adminCurrentSesssion = adminSessionDao.findByAid(key);

        if(adminCurrentSesssion==null) throw new AdminException("Please login first");

        Optional<Customer> opt = customerDao.findById(cId);

        if(!opt.isPresent()){
            throw new CustomerException("Customer does not exists with customer id : "+cId);
        }

        Customer customer = opt.get();
        customerDao.delete(customer);
        return customer;

    }

    @Override
    public Broker removeBroker(String key, Integer bId) throws BrokerException {
        AdminCurrentSesssion adminCurrentSesssion = adminSessionDao.findByAid(key);

        if(adminCurrentSesssion==null) throw new AdminException("Please login first");

        Optional<Broker> opt = brokerDao.findById(bId);

        if(!opt.isPresent()){
            throw new BrokerException("Broker does not exists with broker id : "+bId);
        }

        Broker broker = opt.get();

        brokerDao.delete(broker);
        return broker;

    }

    @Override
    public List<Customer> getAllCustomer(String key) throws CustomerException {
        AdminCurrentSesssion adminCurrentSesssion = adminSessionDao.findByAid(key);

        if(adminCurrentSesssion==null) throw new AdminException("Please login first");


        List<Customer> customers = customerDao.findAll();

        if(customers.isEmpty()){
            throw new CustomerException("No customer found");
        }
        return customers;
    }

    @Override
    public List<Broker> getAllBroker(String key) throws BrokerException {

        AdminCurrentSesssion adminCurrentSesssion = adminSessionDao.findByAid(key);

        if(adminCurrentSesssion==null) throw new AdminException("Please login first");

        List<Broker> brokers = brokerDao.findAll();

        if(brokers.isEmpty()){
            throw new BrokerException("No broker found");
        }

        return brokers;

    }

    @Override
    public Customer getCustomerById(String key , Integer cId) throws CustomerException {
       AdminCurrentSesssion adminCurrentSesssion = adminSessionDao.findByAid(key);

       if(adminCurrentSesssion==null) throw new AdminException("Please login first");

       Optional<Customer> opt =  customerDao.findById(cId);

       if (!opt.isPresent()){
           throw new CustomerException("Customer does not exists wuth customer id : "+cId);
       }

       Customer customer  = opt.get();

       return customer;

    }


    @Override
    public Broker getBrokerById(String key , Integer bId) throws BrokerException {
        AdminCurrentSesssion adminCurrentSesssion = adminSessionDao.findByAid(key);

        if(adminCurrentSesssion==null) throw new AdminException("Please login first");

        Optional<Broker> opt = brokerDao.findById(bId);

        if (!opt.isPresent()){
            throw new BrokerException("Broker does not exists with broker id : "+bId);

        }

        Broker broker = opt.get();

        return broker;

    }


}
