package com.example.ingredientmicroservice;

import javax.annotation.processing.Generated;
import javax.persistence.*;

import lombok.*;


@Data
@Entity
@Table(name = "ingredients")
@NoArgsConstructor
@AllArgsConstructor
public class Ingredient_entity {
    @Id
    @GeneratedValue
    private Long id;
    private String ingredient;
}
