package com.masai.heybroker.model;



import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private double offerCost;
    private double areaSqft;
    private String address;
    private String street;
    private boolean status;

    @Enumerated(EnumType.STRING)
    private OfferType offerType;

    @Enumerated(EnumType.STRING)
    private PropertyType propertyType;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "brokerId")
    private Broker broker;

    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

}
