package com.project.Tema6_spring.model;

import com.project.Tema6_spring.validator.NameConstraint;
import jdk.jfr.Name;
import lombok.*;
import org.springframework.data.annotation.Id;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class User {
    @Id
    private int id;
    @NameConstraint
    private String name;
}
