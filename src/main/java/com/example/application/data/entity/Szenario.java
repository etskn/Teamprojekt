package com.example.application.data.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "szenario")
public class Szenario extends AbstractEntity{

    @ManyToOne
    @JoinColumn(name= "id_schuljahr")
    private Schuljahr schuljahr;
    public Schuljahr getSchuljahr() {
        return schuljahr;
    }

    public void setSchuljahr(Schuljahr schuljahr) {
        this.schuljahr = schuljahr;
    }

}
