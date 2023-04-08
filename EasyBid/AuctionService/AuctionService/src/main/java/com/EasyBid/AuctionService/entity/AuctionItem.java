package com.EasyBid.AuctionService.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.sql.Time;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Entity
//@Table(name = "items")
public class AuctionItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //item parameters
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private double start_price;

    @Column(nullable = false)
    private double current_price;

    @Column(nullable = false)
    private String auction_type;

    @Column(nullable = false)
    //@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @CreationTimestamp
    private Date create_date;

    @Column(nullable = false)
    //@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @CreationTimestamp
    private Time create_time;

    @Column(nullable = false)
    private int auction_length;

    private int dutch_snap_down;

    private long current_bidder_id;

    @Column(nullable = false)
    private double ship_price_ex;

    @Column(nullable = false)
    private boolean item_sold;

    public void updateItem(AuctionItem update){
        setName(update.getName());
        setDescription(update.getDescription());
        setStart_price(update.getStart_price());
        setCurrent_price(update.getCurrent_price());
        setAuction_type(update.getAuction_type());
        setCreate_date(update.getCreate_date());
        setCreate_time(update.getCreate_time());
        setAuction_length(update.getAuction_length());
        setDutch_snap_down(update.getDutch_snap_down());
        setCurrent_bidder_id(update.getCurrent_bidder_id());
        setShip_price_ex(update.getShip_price_ex());
        setItem_sold(update.isItem_sold());
    }
//    public AuctionItem(){
//        super();
//    }

//    public AuctionItem(String name, String description, double start_price, double current_price, String auction_type, Date create_date, Time create_time, int auction_length, int dutch_snap_down, long current_bidder_id, boolean item_sold){
//        super();
//        this.name = name;
//        this.description =  description;
//        this.start_price = start_price;
//        this.current_price = start_price;
//        this.auction_type = auction_type;
//        this.create_date = create_date;
//        this.create_time = create_time;
//        this.auction_length = auction_length;
//        this.dutch_snap_down = dutch_snap_down;
//        this.current_bidder_id = current_bidder_id;
//        this.item_sold = item_sold;
//    }
//
//    public AuctionItem(AuctionItem auctionItem){
//        super();
//        this.name = auctionItem.getName();
//        this.description = auctionItem.getDescription();
//        this.start_price = auctionItem.getStartPrice();
//        this.auction_type = auctionItem.getAuctionType();
//        this.create_date = auctionItem.getDate();
//        this.create_time = auctionItem.getTime();
//        this.auction_length = auctionItem.getLength();
//    }
//
//    public long getID(){return this.id;}
//
//    public String getName(){
//        return this.name;
//    }
//
//    public String getDescription(){
//        return this.description;
//    }
//
//    public double getStartPrice(){
//        return this.start_price;
//    }
//
//    public double getCurrentPrice(){
//        return this.current_price;
//    }
//
//    public String getAuctionType(){
//        return this.auction_type;
//    }
//
//    public Date getDate(){
//        return this.create_date;
//    }
//
//    public Time getTime(){
//        return this.create_time;
//    }
//
//    public int getLength(){
//        return this.auction_length;
//    }
//
//    public int getDutchSnapDown(){
//        return this.dutch_snap_down;
//    }
//
//    public long getCurrentBidder(){
//        return this.current_bidder_id;
//    }
//
//    public void setName(String name){
//        this.name = name;
//    }
//
//    public void setDescription(String description){
//        this.description = description;
//    }
//
//    public void setStartPrice(double price){
//        this.start_price = price;
//    }
//
//    public void setCurrentPrice(double price){
//        this.current_price = price;
//    }
//
//    public void setAuctionType(String auctionType){
//        this.auction_type = auctionType;
//    }
//
//    public void setDate(Date date){
//        this.create_date = date;
//    }
//
//    public void setTime(Time time){
//        this.create_time = time;
//    }
//
//    public void setLength(int length){
//        this.auction_length = length;
//    }

    public String toString(){

        return getId() + "\n" +
                getName() + "\n" +
                getDescription() + "\n" +
                getStart_price() + "\n" +
                getCurrent_price() + "\n" +
                getAuction_type() + "\n" +
                getCreate_date().toString() + "\n" +
                getCreate_time().toString() + "\n" +
                getAuction_length();
    }
}
