package com.kamil.Simple.food;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FoodController {

    @Autowired
    FoodService fs;

    @RequestMapping(value = "/food/{name}")
    public float getFoodPrice(@PathVariable String name) {
        return fs.getFoodPrice(name);
    }

    @RequestMapping
    public List<String> getMenu(){
        return fs.getAll();
    }
}
