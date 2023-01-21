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

    private String city;
    private double minCost;
    private double maxCost;


}
