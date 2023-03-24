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

    @Column(name = "auctionType")
    private String auctionType;

    public AuctionItem(){
        super();
    }

    public AuctionItem(String name, String description, double price, String auctionType){
        super();
        this.name = name;
        this.description =  description;
        this.price = price;
        this.auctionType = auctionType;
    }

    public AuctionItem(AuctionItem auctionItem){
        this.name = auctionItem.getName();
        this.description = auctionItem.getDescription();
        this.price = this.getPrice();
        this.auctionType = this.getAuctionType();
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

    public String getAuctionType(){
        return this.auctionType;
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

    public void setAuctionType(String auctionType){
        this.auctionType = auctionType;
    }
}
