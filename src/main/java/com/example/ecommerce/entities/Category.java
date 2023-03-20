package com.example.ecommerce.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
    @Column(nullable = false, length = 32)
    private String name;



    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "categories")
    @JsonIgnore
    private Set<Product> products = new HashSet<>();

    public Category(long id, String name) {

        this.id = id;
        this.name = name;
    }


    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }




    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


}
