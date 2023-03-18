package com.EasyBid.AuctionService.controller;

import com.EasyBid.AuctionService.entity.AuctionItem;

import java.util.List;

import com.EasyBid.AuctionService.service.AuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auction")
public class AuctionItemController {

    @Autowired
    private AuctionService auctionItemService;

    @GetMapping("/items")
    public ResponseEntity<List<AuctionItem>> getAllItems(@RequestParam(required  = false) String title){
        return ResponseEntity.ok(auctionItemService.getAllItems());
    }

    @GetMapping("/items/{query}")
    public ResponseEntity<List<AuctionItem>> getItemsByQuery(@PathVariable("query") String query){
        return ResponseEntity.ok(auctionItemService.getItemsByQuery(query));
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
