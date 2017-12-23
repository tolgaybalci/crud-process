package com.example.crudprocess.controller;

import com.example.crudprocess.domain.Recipe;
import com.example.crudprocess.repository.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping("/recipes")
public class    RecipeController {

    @Autowired
    private RecipeRepository recipeRepository;

    @GetMapping("")
    public String getRecipeList(Model model){
        model.addAttribute("recipes",recipeRepository.findAll());
        return "recipes/listRecipes";
    }

    @GetMapping("/new")
    public String getNewRecipes(Model model){
        model.addAttribute("recipe", new Recipe());
        return "recipes/createRecipe";
    }

    @PostMapping("/new")
    public String postNewRecipe(@ModelAttribute Recipe recipe){
        recipeRepository.save(recipe);
        return "redirect:/recipes";
    }

    @GetMapping("/{id}")
    public String getShowRecipe(Model model, @PathVariable Long id){
        model.addAttribute("recipe", recipeRepository.findById(id).get());
        return "recipes/showRecipe";
    }

    @GetMapping("/{id}/new")
    public String getUpdateRecipes(Model model, @PathVariable Long id){
        model.addAttribute("recipe", recipeRepository.findById(id).get());
        return "recipes/updateRecipe";
    }


}
