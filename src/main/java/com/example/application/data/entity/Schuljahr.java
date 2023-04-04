package com.example.application.data.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "schuljahr")
public class Schuljahr extends AbstractEntity{

    @ManyToOne
    @JoinColumn(name = "id_szenario")
    private Szenario szenario;
    public Szenario getSzenario() {
        return szenario;
    }

    public void setSzenario(Szenario szenario) {
        this.szenario = szenario;
    }
}
