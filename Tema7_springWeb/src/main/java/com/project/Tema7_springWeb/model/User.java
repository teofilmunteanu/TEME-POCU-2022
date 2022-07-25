package com.project.Tema7_springWeb.model;

import com.project.Tema7_springWeb.validator.NameConstraint;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class User {
    private int id;
    @NameConstraint
    private String name;
}
