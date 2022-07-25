package com.project.Tema7_springWeb.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class Insurance {
    protected int id;
    protected int ownerId;
    protected double price;
    protected double insurancePrice;
}
