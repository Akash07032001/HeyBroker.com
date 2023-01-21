package com.masai.heybroker.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
	@JsonIgnore
	@JoinColumn(name = "customerId")
	private Customer customerDeals;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "propId")
	private Property property;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "brokerId")
	private Broker dealBroker;

}
