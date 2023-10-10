package com.example.ingredientmicroservice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface IngredientRepository extends JpaRepository<Ingredient_entity,Long>{
}
