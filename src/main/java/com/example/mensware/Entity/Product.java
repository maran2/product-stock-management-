package com.example.mensware.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String category;
    private String brand;
    private int price;
    private String size;
    private int stock;

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
    public String getCategory(){
        return category;
    }
    public void setCategory(String category){
        this.category=category;
    }

    public String getBrand(){
        return brand;
    }
    public void setBrand(String brand){
        this.brand=brand;
    }
    public int getPrice(){
        return price;
    }
    public void setPrice(int price){
        this.price=price;

    }

    public String getSize() {
        return size;
    }
    public void setSize(String size){
        this.size=size;
    }

    public int getStock(){
        return stock;
    }
    public void setStock(int stock){
        this.stock=stock;
    }

}
