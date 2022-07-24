package com.project.Tema6_spring.model;

import lombok.*;
import org.springframework.data.annotation.Id;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class Insurance {
    @Id
    protected int id;
    protected int ownerId;
    protected double price;
    protected double insurancePrice;
}
