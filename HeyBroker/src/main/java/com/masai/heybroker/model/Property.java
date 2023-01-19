package com.masai.heybroker.model;



import lombok.*;

import javax.persistence.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer propId;
//    @ElementCollection(fetch = FetchType.EAGER)
    @Embedded
    private PropertyCriteria propertyCriteria;
    private String offerType;
    private double offerCost;
    private double areaSqft;
    private String address;
    private String street;
    private boolean status;
    @ManyToOne
    @JoinColumn(name = "brokerId")
    private Broker broker;

    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

}
