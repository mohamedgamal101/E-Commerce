package com.example.ecommerce.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "products")
public class Product
{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 32)
    private String name;

    @Column(nullable = false, length = 64)
    private String description;

    @Column(nullable = false)
    private double price;


    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "product_category",
            joinColumns = { @JoinColumn(name = "product_id") },
            inverseJoinColumns = { @JoinColumn(name = "category_id") })

    private Set<Category> categories = new HashSet<>();

    public Product() {

    }

    public Product(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

//    public void addCategory(Category category) {
//        this.categories.add(category);
//        category.get;
//    }
//
//    public void removeCategory(long categoryId) {
//        Category category = this.categories.stream().filter(t -> t.getId() == categoryId).findFirst().orElse(null);
//        if (category != null) {
//            this.categories.remove(category);
//            category.getCategories.remove(this);
//        }
//    }





    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}

