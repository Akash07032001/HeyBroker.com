package com.masai.heybroker.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.time.LocalDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
	@NotNull(message = "Deal date can not be null or blank")
	private LocalDate date;
	@NotNull(message = "Deal cost can not be null or blank")
	private Double dealCost;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "customerId")
	private Customer customerDeals;

	@OneToOne
	@JsonIgnore
	@JoinColumn(name = "propId")
	private Property property;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "brokerId")
	private Broker dealBroker;

}
