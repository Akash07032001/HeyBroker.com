package com.masai.heybroker.service;

import com.masai.heybroker.exception.LoginException;
import com.masai.heybroker.model.*;
import com.masai.heybroker.repository.CustomerDao;
import com.masai.heybroker.repository.CustomerSessionDao;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class CustomerLoginServiceImpl implements CustomerLoginService {
    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private CustomerSessionDao customerSessionDao;

    @Override
    public String logIntoAccount(CustomerLoginDTO customerLoginDTO) throws LoginException {
        Customer existingCustomer = customerDao.findByEmail(customerLoginDTO.getEmail());

        if(existingCustomer==null) throw new LoginException("Please enter valid email");

        Optional<CustomerCurrentSession> opt = customerSessionDao.findById(existingCustomer.getCustomerId());

        if(opt.isPresent()) throw new LoginException("User already logged in with this email");

        if(existingCustomer.getPassword().equals(customerLoginDTO.getPassword())){
            String key = RandomString.make(6);

            CustomerCurrentSession customerCurrentSesssion = new CustomerCurrentSession(existingCustomer.getCustomerId(),key, LocalDateTime.now());

           customerSessionDao.save(customerCurrentSesssion);
            return customerCurrentSesssion.getCid();
        }else {
            throw new LoginException("Please Enter a valid password");
        }
    }

    @Override
    public String logOutFromAccount(String key) throws LoginException {
        CustomerCurrentSession customerCurrentSesssion = customerSessionDao.findByCid(key);

        if(customerCurrentSesssion==null) throw new LoginException("Customer not logged in with this email");

        customerSessionDao.delete(customerCurrentSesssion);

        return "Logged out successfully!";
    }
}
