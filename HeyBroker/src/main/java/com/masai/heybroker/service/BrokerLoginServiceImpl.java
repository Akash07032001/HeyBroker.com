package com.masai.heybroker.service;

import com.masai.heybroker.exception.LoginException;
import com.masai.heybroker.model.*;
import com.masai.heybroker.repository.BrokerDao;
import com.masai.heybroker.repository.BrokerSessionDao;
import com.masai.heybroker.repository.CustomerDao;
import com.masai.heybroker.repository.CustomerSessionDao;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class BrokerLoginServiceImpl implements BrokerLoginService {
    @Autowired
    private BrokerDao brokerDao;
    @Autowired
    private BrokerSessionDao brokerSessionDao;

    @Override
    public String logIntoAccount(BrokerLoginDTO brokerLoginDTO) throws LoginException {
       Broker existingBroker = brokerDao.findByBrokerEmail(brokerLoginDTO.getEmail());

        if(existingBroker==null) throw new LoginException("Please enter valid email");

        Optional<BrokerCurrentSession> opt = brokerSessionDao.findById(existingBroker.getBrokerId());

        if(opt.isPresent()) throw new LoginException("Broker already logged in with this email");

        if(existingBroker.getPassword().equals(brokerLoginDTO.getPassword())){
            String key = RandomString.make(6);

           BrokerCurrentSession brokerCurrentSesssion = new BrokerCurrentSession(existingBroker.getBrokerId(),key, LocalDateTime.now());

           brokerSessionDao.save(brokerCurrentSesssion);
            return brokerCurrentSesssion.getBid();
        }else {
            throw new LoginException("Please Enter a valid password");
        }
    }

    @Override
    public String logOutFromAccount(String key) throws LoginException {
       BrokerCurrentSession brokerCurrentSession = brokerSessionDao.findByBid(key);

        if(brokerCurrentSession==null) throw new LoginException("Broker not logged in with this email");

       brokerSessionDao.delete(brokerCurrentSession);

        return "Logged out successfully!";
    }
}
