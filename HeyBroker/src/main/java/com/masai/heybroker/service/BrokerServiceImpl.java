package com.masai.heybroker.service;

import com.masai.heybroker.model.Broker;
import com.masai.heybroker.repository.BrokerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrokerServiceImpl implements BrokerService {
    @Autowired
   private BrokerDao bDao;
    @Override
    public Broker registerBroker(Broker broker) {
          Broker broker1 =   bDao.save(broker);
          return broker1;
    }
}
