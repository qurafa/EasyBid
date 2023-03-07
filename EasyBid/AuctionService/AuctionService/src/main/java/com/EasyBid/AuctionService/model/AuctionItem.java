package com.EasyBid.AuctionService.model;

import jakarta.persistence.*;

@Entity
@Table(name = "items")
public class AuctionItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    public String getName(){
        return this.name;
    }

    public String getDescription(){
        return this.description;
    }

    public double getPrice(){
        return this.price;
    }
}
