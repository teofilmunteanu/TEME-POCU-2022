package com.project.Tema7_springWeb.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class CarInsurance extends Insurance {
    private String manufacturer;
    private String model;
    private int fabricationYear;
    private double power;
}
