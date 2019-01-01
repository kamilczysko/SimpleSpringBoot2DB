package com.kamil.Simple.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService {

    @Autowired
    AnimalRepository animalRepo;

    public  Animal addAnimal(Animal a){
        return animalRepo.save(a);
    }

    public List<Animal> getAnimals(){
        return animalRepo.findAll();
    }

    public List<Animal> getAnimals(String name){
        return animalRepo.findByName(name);
    }

    public void deleteAnimal(Animal a){
        animalRepo.delete(a);
    }
}
