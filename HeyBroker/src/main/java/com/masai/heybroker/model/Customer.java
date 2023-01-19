package com.masai.heybroker.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Customer{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customerId;
//	@NotNull
//	@Size(min = 3, max = 15, message = "The name should be min 3 and max of 15 characters.")
	private String customerName;
	private String email;
	private String password;
	private String mobile;
	//customer will have list of properties
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "customer")
	private List<Property> properties = new ArrayList<>();

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customerDeals")
	private List<Deal> deals = new ArrayList<>();

}
