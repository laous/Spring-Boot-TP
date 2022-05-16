package org.cours.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String name;
    String description;


    public Module(int id, String name, String description) {
        super();
        this.name = name;
        this.description = description;
        this.id = id;
    }

    public Module() {
        super();
    }

    public String getName() {
        return name;
    }
    public void setNom(String nom) {
        this.name = nom;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}
