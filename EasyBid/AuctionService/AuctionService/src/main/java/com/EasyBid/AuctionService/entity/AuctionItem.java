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
    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "start_price")
    private double startPrice;

    @Column(name = "current_price")
    private double currentPrice;

    @Column(name = "auction_type")
    private String auctionType;

    @Column(name = "create_date")
    //@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @CreationTimestamp
    private Date createDate;

    @Column(name = "create_time")
    //@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @CreationTimestamp
    private Time createTime;

    @Column(name = "auction_length")
    private Time auctionLength;

    public AuctionItem(){
        super();
    }

    public AuctionItem(String name, String description, double price, String auctionType, Date date, Time time){
        super();
        this.name = name;
        this.description =  description;
        this.startPrice = price;
        this.auctionType = auctionType;
        this.createDate = date;
        this.createTime = time;
    }

    public AuctionItem(AuctionItem auctionItem){
        super();
        this.name = auctionItem.getName();
        this.description = auctionItem.getDescription();
        this.startPrice = auctionItem.getPrice();
        this.auctionType = auctionItem.getAuctionType();
        this.createDate = auctionItem.getDate();
        this.createTime = auctionItem.getTime();
    }

    public long getID(){return this.id;}

    public String getName(){
        return this.name;
    }

    public String getDescription(){
        return this.description;
    }

    public double getPrice(){
        return this.startPrice;
    }

    public String getAuctionType(){
        return this.auctionType;
    }

    public Date getDate(){
        return this.createDate;
    }

    public Time getTime(){
        return this.createTime;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setPrice(double price){
        this.startPrice = price;
    }

    public void setAuctionType(String auctionType){
        this.auctionType = auctionType;
    }

    public void setDate(Date date){
        this.createDate = date;
    }

    public void setTime(Time time){
        this.createTime = time;
    }
}
