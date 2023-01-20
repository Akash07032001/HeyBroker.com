package com.masai.heybroker.repository;

import com.masai.heybroker.model.Admin;
import com.masai.heybroker.model.AdminCurrentSesssion;
import com.masai.heybroker.model.CustomerCurrentSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerSessionDao extends JpaRepository<CustomerCurrentSession,Integer> {
    public CustomerCurrentSession findByCid(String cid);
}
