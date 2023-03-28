package com.EasyBid.AuctionService.controller;

import com.EasyBid.AuctionService.entity.AuctionItem;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

import com.EasyBid.AuctionService.service.AuctionService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/auction")
public class AuctionItemController {

    @Autowired
    private AuctionService auctionItemService;

    private static long sessionUserId;

    //redirects us to the React page and create the user session
    @GetMapping("/{userId}")
    public void saveUserSess(@PathVariable long userId){
        sessionUserId = userId;
        System.out.println("Set UserID: " + sessionUserId);
        //To-do: add an error method to display something if id is not specified
        //response.setHeader("Location", "localhost:3000/");
        //response.setStatus(302);
    }

    @GetMapping("/items")
    public ResponseEntity<List<AuctionItem>> getAllItems(@RequestParam(required = false)String query){
        return ResponseEntity.ok(auctionItemService.getAllItems(query));
    }

    @GetMapping("/items/{id}")
    public ResponseEntity<AuctionItem> getAuctionItemByID(@PathVariable("id") long id){
        return ResponseEntity.ok(auctionItemService.getItemById(id));
    }

    @PostMapping("/items")
    public ResponseEntity<?> createAuctionItem(@RequestBody AuctionItem item){
        auctionItemService.save(item);
        return new ResponseEntity<>("Item Created Successfully", HttpStatus.CREATED);
    }

    @PutMapping("/items/{id}")
    public ResponseEntity<?> updateItem(@PathVariable("id") long id, @RequestBody AuctionItem item){
    	auctionItemService.updateItem(id, item);
        return new ResponseEntity<>("Item Updated Successfully", HttpStatus.CREATED);
    }

    @DeleteMapping("/items/{id}")
    public ResponseEntity<?> deleteItem(@PathVariable("id") long id){
    	auctionItemService.deleteItem(id);
        return new ResponseEntity<>("Item Deleted Successfully", HttpStatus.CREATED);
    }

    @DeleteMapping("/items")
    public ResponseEntity<?> deleteAllItems(){
        auctionItemService.deleteAllItems();
        return new ResponseEntity<>("Items Deleted Successfully", HttpStatus.CREATED);
    }
}
