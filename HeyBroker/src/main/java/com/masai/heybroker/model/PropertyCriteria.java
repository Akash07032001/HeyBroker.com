package com.masai.heybroker.model;

import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class PropertyCriteria {
    @Enumerated(EnumType.STRING)
    private OfferType offerType;

    @Enumerated(EnumType.STRING)
    private PropertyType propertyType;
    private String city;
    private double minCost;
    private double maxCost;


}
