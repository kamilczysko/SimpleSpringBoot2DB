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

    public List<String> getAll() {
        List resultList = em.createQuery("SELECT DISTINCT f.name FROM Food f").getResultList();
        return resultList;
    }

    public void deleteFood(int id) {
        fr.deleteById(id);
    }

    public float getFoodPrice(String foodName) {
        List food = em.createQuery("SELECT DISTINCT f.price FROM Food f WHERE f.name=:fd", Float.class).setParameter("fd", foodName).getResultList();
        if (food.isEmpty())
            return 0.0f;
        return (float)food.get(0);
    }

}
