package com.kamil.Simple.breed;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "breed")
public class Breed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(unique = true)
    @NotEmpty
    String name;

    public Breed() {
    }

    public Breed(@NotEmpty String name) {
        this.name = name;
    }

    public int getId() {
        return id;
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

    @Override
    public String toString() {
        return "Breed{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
