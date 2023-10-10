package com.example.ingredientmicroservice.rest;

import com.example.ingredientmicroservice.service.IngredientServiceImpl;
import com.example.ingredientmicroservice.domain.Ingredients;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class IngredientsController {
    private final IngredientServiceImpl ingredientsService;

    public IngredientsController(IngredientServiceImpl ingredientsService) {
        this.ingredientsService = ingredientsService;
    }

    @PostMapping("/addProduct")
    public Ingredients addIngredient(@RequestBody Ingredients ingredientEntity){
        return ingredientsService.saveIngredient(ingredientEntity);
    }

    @PostMapping("/addProducts")
    public List<Ingredients> addIngredients(@RequestBody List<Ingredients> ingredientEntities){
        return ingredientsService.saveIngredients(ingredientEntities);
    }

    @GetMapping("/ingredients")
    public List<Ingredients> findAllIngredients(){
        return ingredientsService.getIngredients();
    }
    @GetMapping("/ingredient/{id}")
    public Ingredients findIngredientById(@PathVariable Long id){
        return ingredientsService.getIngredientById(id);
    }

    @PutMapping("/update")
    public Ingredients updateIngredient(@RequestBody Ingredients ingredientEntity){
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

