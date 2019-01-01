package com.kamil.Simple.animal;

import com.kamil.Simple.breed.Breed;
import com.kamil.Simple.owner.Owner;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "animal")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;

    int age;

    @OneToOne
    Breed breed;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinTable(name = "owner_animal",
            joinColumns = {@JoinColumn(name = "animal", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "owner", referencedColumnName = "id")})

    Owner owner;

    public Animal() {
    }

    public Animal(String name, int age, Breed breed, Owner owner) {
        this.name = name;
        this.age = age;
        this.breed = breed;
        this.owner = owner;
    }

    public Breed getBreed() {
        return breed;
    }

    public void setBreed(Breed breed) {
        this.breed = breed;
    }

    public int getId() {
        return id;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", breed=" + breed +
                '}';
    }

    public void removeOwner() {
        this.owner = null;
    }
}
