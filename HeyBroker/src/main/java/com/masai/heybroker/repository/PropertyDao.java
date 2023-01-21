package com.masai.heybroker.repository;

import com.masai.heybroker.model.Property;
import com.masai.heybroker.model.PropertyType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropertyDao extends JpaRepository<Property,Integer> {

    public List<Property> findByPropertyType(PropertyType propertyType);


}
