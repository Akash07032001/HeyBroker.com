package com.masai.heybroker.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Deal {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer dealId;
	private LocalDate date;
	private Double dealCost;
	

}
