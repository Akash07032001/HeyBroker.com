package com.masai.heybroker.repository;

import com.masai.heybroker.model.Admin;
import com.masai.heybroker.model.Broker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrokerDao extends JpaRepository<Broker,Integer> {
	
    public Broker findByBrokerEmail(String email);
}
