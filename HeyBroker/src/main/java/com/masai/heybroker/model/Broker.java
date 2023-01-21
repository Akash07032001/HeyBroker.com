	package com.masai.heybroker.model;

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
public class Broker{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer brokerId;
    @NotBlank(message = "Broker name can not be null or blank")
    private String brokerName;
    @NotBlank(message = "Broker email can not be null or blank")
    @Email
    private String brokerEmail;
    @NotBlank(message = "Broker password can not be null or blank")
    @Size(min = 3,max = 8)
    private String password;
    @NotBlank(message = "Broker mobile can not be null or blank")
    @Size(min = 10)
    private String mobile;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "broker")
    private List<Property> properties = new ArrayList<>();

    @OneToMany( mappedBy = "dealBroker")
    private List<Deal> deals = new ArrayList<>();


}
