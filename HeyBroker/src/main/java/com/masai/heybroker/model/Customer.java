package com.masai.heybroker.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
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

	@NotBlank(message = "Customer name can not be null or blank")
	private String customerName;
	@NotBlank(message = "Customer email can not be null or blank")
	@Email
	private String email;
	@NotBlank(message = "Customer password can not be null or blank")
	@Size(min = 3,max = 8)
	private String password;
	@NotBlank(message = "Customer mobile can not be null or blank")
	@Size(min = 10)
	private String mobile;
	//customer will have list of properties
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "customer")
	@JsonIgnore
	private List<Property> properties = new ArrayList<>();

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customerDeals")
	@JsonIgnore
	private List<Deal> deals = new ArrayList<>();

}
