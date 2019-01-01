package com.kamil.Simple.owner;

import com.kamil.Simple.animal.Animal;
import org.springframework.web.bind.annotation.Mapping;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "owner")
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @NotEmpty
    String name;

    int age;

    @OneToMany(mappedBy = "owner", fetch = FetchType.EAGER)
    List<Animal> animals;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void addAnimal(Animal a){
        if(animals == null)
            animals = new ArrayList<Animal>();

        animals.add(a);
        a.setOwner(this);
    }

    public void removeAnimal(Animal a){
        animals.remove(a);
        a.removeOwner();
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    public Owner() {
    }

    public Owner(@NotEmpty String name, @NotEmpty int age, List<Animal> animals) {
        this.name = name;
        this.age = age;
        this.animals = animals;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", animals=" + animals +
                '}';
    }
}

