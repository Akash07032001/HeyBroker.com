package com.masai.heybroker.repository;

import com.masai.heybroker.model.Broker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrokerDao extends JpaRepository<Broker,Integer> {
}
