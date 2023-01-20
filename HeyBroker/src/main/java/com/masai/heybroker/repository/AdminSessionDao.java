package com.masai.heybroker.repository;

import com.masai.heybroker.model.Admin;
import com.masai.heybroker.model.AdminCurrentSesssion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminSessionDao extends JpaRepository<AdminCurrentSesssion,Integer> {

    public AdminCurrentSesssion findByAid(String aid);
}
