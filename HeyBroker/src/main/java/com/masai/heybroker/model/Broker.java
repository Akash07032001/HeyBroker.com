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
public class Broker{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer brokerId;
    private String brokerName;
    private String brokerEmail;
    private String password;
    private String mobile;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "broker")
    private List<Property> properties = new ArrayList<>();

    @OneToMany( mappedBy = "dealBroker")
    private List<Deal> deals = new ArrayList<>();


}
