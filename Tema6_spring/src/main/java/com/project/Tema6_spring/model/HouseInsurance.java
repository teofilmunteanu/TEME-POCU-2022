package com.project.Tema6_spring.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class HouseInsurance extends Insurance{
    private String address;
    private int buildingYear;
    private int numberOfRooms;
}
