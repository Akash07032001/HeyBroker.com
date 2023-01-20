package com.masai.heybroker.repository;

import com.masai.heybroker.model.Admin;
import com.masai.heybroker.model.AdminCurrentSesssion;
import com.masai.heybroker.model.BrokerCurrentSession;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrokerSessionDao extends JpaRepository<BrokerCurrentSession,Integer> {

    public BrokerCurrentSession findByBid(String bid);
}
