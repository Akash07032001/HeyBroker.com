package com.masai.heybroker.model;

import lombok.*;

import java.time.LocalDate;

import javax.persistence.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Deal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer dealId;
	private LocalDate date;
	private Double dealCost;

	@ManyToOne
	@JoinColumn(name = "customerId")
	private Customer customerDeals;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "dealId")
	private Property property;

	@ManyToOne
	@JoinColumn(name = "brokerId")
	private Broker dealBroker;

}
