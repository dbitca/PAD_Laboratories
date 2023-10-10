package com.example.ingredientmicroservice;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientServiceImpl{
    private final IngredientRepository ingredientRepository;

    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    public Ingredient_entity saveIngredient(Ingredient_entity ingredient){
       return ingredientRepository.save(ingredient);
    }

    public List<Ingredient_entity> saveIngredients(List<Ingredient_entity> ingredients){
        return ingredientRepository.saveAll(ingredients);
    }

    public List<Ingredient_entity> getIngredients(){
        return ingredientRepository.findAll();
    }

    public Ingredient_entity getIngredientById(Long id){
        return ingredientRepository.findById(id).orElse(null);
    }

    public String deleteIngredient (Long id){
        ingredientRepository.deleteById(id);
        return "product removed " + id;
    }

    public Ingredient_entity updateIngredient (Ingredient_entity ingredient){
       Ingredient_entity existingIngredient = ingredientRepository.findById((ingredient.getId())).orElse(null);
       existingIngredient.setIngredient(ingredient.getIngredient());
       return ingredientRepository.save(existingIngredient);
    }
}
