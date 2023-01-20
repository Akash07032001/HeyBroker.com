package com.masai.heybroker.repository;

import com.masai.heybroker.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminDao extends JpaRepository<Admin,Integer> {

    public Admin findByEmail(String email);

}
