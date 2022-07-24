package com.project.Tema6_spring.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class CarInsurance extends Insurance{
    private String manufacturer;
    private String model;
    private int fabricationYear;
    private double power;
}
