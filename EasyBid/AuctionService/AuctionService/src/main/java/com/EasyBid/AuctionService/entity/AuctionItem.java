package com.EasyBid.AuctionService.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "items")
public class AuctionItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //item parameters
    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private double price;

    public AuctionItem(){

    }

    public AuctionItem(String name, String description, double price){
        this.name = name;
        this.description =  description;
        this.price = price;
    }

    public long getID(){return this.id;}

    public String getName(){
        return this.name;
    }

    public String getDescription(){
        return this.description;
    }

    public double getPrice(){
        return this.price;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setPrice(double price){
        this.price = price;
    }
}
