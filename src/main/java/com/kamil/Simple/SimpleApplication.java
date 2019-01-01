package com.kamil.Simple;

import com.kamil.Simple.animal.Animal;
import com.kamil.Simple.animal.AnimalService;
import com.kamil.Simple.breed.Breed;
import com.kamil.Simple.breed.BreedService;
import com.kamil.Simple.food.Food;
import com.kamil.Simple.food.FoodService;
import com.kamil.Simple.owner.Owner;
import com.kamil.Simple.owner.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.util.List;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class SimpleApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SimpleApplication.class, args);
    }


    @Autowired
    AnimalService as;
    @Autowired
    OwnerService os;
    @Autowired
    BreedService bs;
    @Autowired
    FoodService fs;

    @Override
    public void run(String... args) throws Exception {
//        Breed b1 = new Breed("Owczarek niemiecki");
//        Breed b2 = new Breed("Beagle");
//        Breed b3 = new Breed("Wyżeł");
//        Breed b4 = new Breed("Husky");
//
//        b1 = bs.save(b1);
//        b2 = bs.save(b2);
//        b3 = bs.save(b3);
//        b4 = bs.save(b4);
//
//        System.out.println(b1);
//        System.out.println(b2);
//        System.out.println(b3);
//        System.out.println(b4);
//
//        Owner o1 = new Owner("kamil", 27, null);
//        Owner o2 = new Owner("pszemek", 19, null);
//        Owner o3 = new Owner("andrzej", 12, null);
//        Owner o4 = new Owner("Marian", 36, null);
//
//        o1 = os.addOwner(o1);
//        o2 = os.addOwner(o2);
//        o3 = os.addOwner(o3);
//        o4 = os.addOwner(o4);
//
//        Animal a1 = new Animal("pimpek", 5 , b1, o1);
//        Animal a2 = new Animal("reks", 5 , b2,o2);
//        Animal a3 = new Animal("stefan", 1, b3, o3);
//        Animal a4 = new Animal("fafik", 2 , b4, o3);
//        Animal a5 = new Animal("szarik", 3 , b4, o4);
//
//        a1= as.addAnimal(a1);
//        a2= as.addAnimal(a2);
//        a3= as.addAnimal(a3);
//        a4= as.addAnimal(a4);
//        a5= as.addAnimal(a5);
//
//        System.out.println(a1);
//        System.out.println(a2);
//        System.out.println(a3);
//        System.out.println(a4);
//        System.out.println(a5);
//
//        o1.addAnimal(a1);;
//        o2.addAnimal(a2);
//        o3.addAnimal(a3);
//        o3.addAnimal(a4);
//        o4.addAnimal(a5);
//
//
//        System.out.println(o1);
//        System.out.println(o2);
//        System.out.println(o3);
//        System.out.println(o4);

        System.out.println("########################");

//
//        Food f1 = new Food("pizza", 5.0f);
//        Food f2 = new Food("burger", 2.5f);
//        Food f3 = new Food("taco", 3.66f);
//        Food f4 = new Food("steak", 15.0f);
//
//        f1 = fs.saveFood(f1);
//        f2 = fs.saveFood(f2);
//        f3 = fs.saveFood(f3);
//        f4 = fs.saveFood(f4);
//
//        System.out.println(f1);
//        System.out.println(f2);
//        System.out.println(f3);
//        System.out.println(f4);


        List<Food> all = fs.getAll();
        System.out.println(all);

        List<Animal> animals = as.getAnimals();

        List<Breed> breeds = bs.getBreeds();

        List<Owner> owners = os.getOwners();

        System.out.println(animals);
        System.out.println(breeds);
        System.out.println(owners);

    }

}

