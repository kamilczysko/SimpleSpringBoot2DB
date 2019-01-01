package com.kamil.Simple.food;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Service
public class FoodService {

    @Autowired
    FoodRepository fr;

    @Autowired
    @Qualifier("psEntityManagerFactory")
    EntityManager em;


    public Food saveFood(Food f) {
        return fr.save(f);
    }

    public List<Food> getAll() {
        return fr.findAll();
    }

    public void deleteFood(int id) {
        fr.deleteById(id);
    }

    public List getFoodPrice(String foodName) {
        List food = em.createQuery("SELECT DISTINCT f.price FROM Food f WHERE f.name=:fd", Float.class).setParameter("fd", foodName).getResultList();
        return food;
    }

}
