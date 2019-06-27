package com.souphorn.spring.template.product.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
public class Product implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;
    public Product(int id, String name) {
        this.name = name;
        this.id = id;
    }

    public String toString() {
        return "Name: " + getName() + ", ID: " + getId();
    }
}
