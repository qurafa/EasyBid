package com.EasyBid.AuctionService.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "items")
public class AuctionItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //item parameters
//    @Column(name = "name")
    private String name;

//    @Column(name = "description")
    private String description;

//    @Column(name = "start_price")
    private double start_price;

//    @Column(name = "current_price")
    private double current_price;

//    @Column(name = "auction_type")
    private String auction_type;

//    @Column(name = "create_date")
    //@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @CreationTimestamp
    private Date create_date;

//    @Column(name = "create_time")
    //@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @CreationTimestamp
    private Time create_time;

//    @Column(name = "auction_length")
    private int auction_length;

    public AuctionItem(){
        super();
    }

    public AuctionItem(String name, String description, double start_price, double current_price, String auction_type, Date create_date, Time create_time, int auction_length){
        super();
        this.name = name;
        this.description =  description;
        this.start_price = start_price;
        this.current_price = start_price;
        this.auction_type = auction_type;
        this.create_date = create_date;
        this.create_time = create_time;
        this.auction_length = auction_length;
    }

    public AuctionItem(AuctionItem auctionItem){
        super();
        this.name = auctionItem.getName();
        this.description = auctionItem.getDescription();
        this.start_price = auctionItem.getStartPrice();
        this.auction_type = auctionItem.getAuctionType();
        this.create_date = auctionItem.getDate();
        this.create_time = auctionItem.getTime();
        this.auction_length = auctionItem.getLength();
    }

    public long getID(){return this.id;}

    public String getName(){
        return this.name;
    }

    public String getDescription(){
        return this.description;
    }

    public double getStartPrice(){
        return this.start_price;
    }

    public double getCurrentPrice(){
        return this.current_price;
    }

    public String getAuctionType(){
        return this.auction_type;
    }

    public Date getDate(){
        return this.create_date;
    }

    public Time getTime(){
        return this.create_time;
    }

    public int getLength(){
        return this.auction_length;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setStartPrice(double price){
        this.start_price = price;
    }

    public void setCurrentPrice(double price){
        this.current_price = price;
    }

    public void setAuctionType(String auctionType){
        this.auction_type = auctionType;
    }

    public void setDate(Date date){
        this.create_date = date;
    }

    public void setTime(Time time){
        this.create_time = time;
    }

    public void setLength(int length){
        this.auction_length = length;
    }

    public String toString(){
        String output = getID() + "\n" +
                getName() + "\n" +
                getDescription() + "\n" +
                getStartPrice() + "\n" +
                getCurrentPrice() + "\n" +
                getAuctionType() + "\n" +
                getDate().toString() + "\n" +
                getTime().toString() + "\n" +
                getLength();

        return output;
    }
}
