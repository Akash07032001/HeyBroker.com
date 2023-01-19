package com.masai.heybroker.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class PropertyCriteria {
    private String config;
    private String offer;
    private String city;
    private double minCost;
    private double maxCost;


}
