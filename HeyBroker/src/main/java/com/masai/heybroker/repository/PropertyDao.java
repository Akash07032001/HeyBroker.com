package com.masai.heybroker.repository;

import com.masai.heybroker.model.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropertyDao extends JpaRepository<Property,Integer> {

    @Query("select p from Property p where p.propertyCriteria.propertyType=?1")
    public List<Property> findByPropertyType(String propertyType);


}
