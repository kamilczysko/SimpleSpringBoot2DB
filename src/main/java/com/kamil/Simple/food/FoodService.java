package com.kamil.Simple.food;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {

    @Autowired
    FoodRepository fr;

    public Food saveFood(Food f){
        return fr.save(f);
    }

    public List<Food> getAll(){
        return fr.findAll();
    }

    public void deleteFood(int id){
        fr.deleteById(id);
    }

}
