package com.example.ingredientmicroservice;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class IngredientsController {
    private final IngredientServiceImpl ingredientsService;

    public IngredientsController(IngredientServiceImpl ingredientsService) {
        this.ingredientsService = ingredientsService;
    }

    @PostMapping("/addProduct")
    public Ingredient_entity addIngredient(@RequestBody Ingredient_entity ingredientEntity){
        return ingredientsService.saveIngredient(ingredientEntity);
    }

    @PostMapping("/addProducts")
    public List<Ingredient_entity> addIngredients(@RequestBody List<Ingredient_entity> ingredientEntities){
        return ingredientsService.saveIngredients(ingredientEntities);
    }

    @GetMapping("/ingredients")
    public List<Ingredient_entity> findAllIngredients(){
        return ingredientsService.getIngredients();
    }
    @GetMapping("/ingredient/{id}")
    public Ingredient_entity findIngredientById(@PathVariable Long id){
        return ingredientsService.getIngredientById(id);
    }

    @PutMapping("/update")
    public Ingredient_entity updateIngredient(@RequestBody Ingredient_entity ingredientEntity){
        return ingredientsService.updateIngredient(ingredientEntity);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteIngredient(@PathVariable Long id){
        return ingredientsService.deleteIngredient(id);
    }
}



//    @PostMapping
//    public ResponseEntity<Ingredient_entity> saveIngredient(@RequestBody Ingredient_entity ingredient){
////        this.ingredientsService = ingredientsService;
//        Ingredient_entity savedIngredient = ingredientsService.saveIngredient(ingredient);
//        return new ResponseEntity<>(savedIngredient, HttpStatus.CREATED);
//    }
//
//    @GetMapping("{id}")
//    public ResponseEntity<Ingredient_entity> getIngredientById(@PathVariable("id") Long ingredientId){
//        Ingredient_entity ingredient = ingredientsService.getIngredientById(ingredientId);
//        return ResponseEntity.ok(ingredient);
////        if (ingredient != null){
////            return new ResponseEntity<>(ingredient, HttpStatus.OK);
////        }
////        else {
////            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }

