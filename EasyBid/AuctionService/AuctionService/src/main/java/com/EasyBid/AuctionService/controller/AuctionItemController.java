package com.EasyBid.AuctionService.controller;

import com.EasyBid.AuctionService.entity.AuctionItem;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

import com.EasyBid.AuctionService.service.AuctionService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
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

    private static String sessionUserName;

    //redirects us to the React page and create the user session
    @GetMapping("/{uName}")
    public void saveUserSess(HttpServletRequest request, HttpServletResponse response, @PathVariable("uName") String uName) throws ServletException, IOException {
        String u = (String) request.getSession().getAttribute("username");
        if(u == null) {
            request.getSession().setAttribute("username", uName);
        }
        String target = "http://localhost:3000/" + uName;
//        request.getRequestDispatcher(target).forward(request, response);
        //To-do: add an error method to display something if uName is not specified
//        response.setHeader("Location", target);
//        response.setStatus(302);
        response.sendRedirect(target);
    }

    @GetMapping("/items")
    public ResponseEntity<List<AuctionItem>> getAllItems(HttpServletRequest request, HttpServletResponse response, @RequestParam(required = false)String query){
        return ResponseEntity.ok(auctionItemService.getAllItems(query));
    }

    //forwards to the specific item page
    @GetMapping("/items/{id}")
    public ResponseEntity<AuctionItem> getAuctionItemByID(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") long id) throws ServletException, IOException {
        String u = (String) request.getSession().getAttribute("username");
        if(u == null) u = "...";
        System.out.println("Username: " + u);
        String target = "";//insert link to Aidan's part...
        request.getRequestDispatcher(target).forward(request, response);
        return ResponseEntity.ok(auctionItemService.getItemById(id));
    }

    @PostMapping("/items")
    public ResponseEntity<?> createAuctionItem(HttpServletRequest request, HttpServletResponse response, @RequestBody AuctionItem item){
        auctionItemService.save(item);
        return new ResponseEntity<>("Item Created Successfully", HttpStatus.CREATED);
    }

    @PutMapping("/items/{id}")
    public ResponseEntity<?> updateItem(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") long id, @RequestBody AuctionItem item){
    	auctionItemService.updateItem(id, item);
        return new ResponseEntity<>("Item Updated Successfully", HttpStatus.CREATED);
    }

    @DeleteMapping("/items/{id}")
    public ResponseEntity<?> deleteItem(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") long id){
    	auctionItemService.deleteItem(id);
        return new ResponseEntity<>("Item Deleted Successfully", HttpStatus.CREATED);
    }

    @DeleteMapping("/items")
    public ResponseEntity<?> deleteAllItems(HttpServletRequest request, HttpServletResponse response){
        auctionItemService.deleteAllItems();
        return new ResponseEntity<>("Items Deleted Successfully", HttpStatus.CREATED);
    }
}
