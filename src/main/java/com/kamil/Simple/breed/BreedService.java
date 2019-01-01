package com.kamil.Simple.breed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BreedService {

    @Autowired
    BreedRepository breedRepo;

    public Breed save(Breed b) {
        return breedRepo.save(b);
    }

    public void removeBreed(Breed b){
        breedRepo.delete(b);
    }

    public void removeBreed(int id){
        breedRepo.deleteById(id);
    }

    public void removeBreed(String name){
        Breed toDel = breedRepo.findTop1ByName(name);
        breedRepo.delete(toDel);
    }

    public List<Breed> getBreeds(){
        return breedRepo.findAll();
    }

    public Breed getBreed(String name){
        return breedRepo.findTop1ByName(name);
    }

    public Breed getBreed(int id){
        return breedRepo.findById(id).get();
    }
}
