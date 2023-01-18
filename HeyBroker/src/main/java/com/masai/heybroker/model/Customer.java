package com.masai.heybroker.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerId;
//	@NotNull
//	@Size(min = 3, max = 15, message = "The name should be min 3 and max of 15 characters.")
	private String Name;

	
}
