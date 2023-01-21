package com.masai.heybroker.repository;

import com.masai.heybroker.model.Deal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DealDao extends JpaRepository<Deal, Integer> {

}
