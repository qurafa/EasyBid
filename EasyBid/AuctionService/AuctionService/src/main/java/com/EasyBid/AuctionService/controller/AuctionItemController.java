package com.EasyBid.AuctionService.controller;

import com.EasyBid.AuctionService.entity.AuctionItem;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

import com.EasyBid.AuctionService.service.AuctionService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/auction")
public class AuctionItemController {

    @Autowired
    private AuctionService auctionItemService;

    @Autowired
    private RestTemplate restTemplate;

    private static String sessionUserName;

    //redirects us to the React page and create the user session
    @GetMapping("/{id}")
    public ResponseEntity<?> saveUserSess(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") String id) throws ServletException, IOException {
        String url = "http://localhost:8080/firstLastTransfer/"+id;
        String firstLast = restTemplate.getForObject(url, String.class);
        System.out.println("firstLast: " + firstLast);
        
        String u = (String) request.getSession().getAttribute("uID");
        if(u == null) {
            request.getSession().setAttribute("uID", id);
        }
        String target = "http://localhost:3000/" + firstLast + "/" + id;
//        request.getRequestDispatcher(target).forward(request, response);
        //To-do: add an error method to display something if uName is not specified
//        response.setHeader("Location", target);
//        response.setStatus(302);

//        ObjectMapper mapper = new ObjectMapper();
//        JsonNode root = mapper.readTree(userInfo.getBody());
//        JsonNode id = root.path("id");
//        System.out.println(id.toString());

        response.sendRedirect(target);

        return new ResponseEntity<>("Session Saved Successfully", HttpStatus.CREATED);
    }

    @GetMapping("/createBid/{uID}/{itemId}")
//    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<?> createBid(HttpServletRequest request, HttpServletResponse response, @PathVariable String uID, @PathVariable long itemId) throws ServletException, IOException {

//        request.getSession().setAttribute("username", username);
//        request.getSession().setAttribute("itemId", itemId);

//        String u = (String) request.getSession().getAttribute("username");
//        String i = (String) request.getSession().getAttribute("itemId");
//
//        if(u == null) u = "...";
        String target = "http://localhost:8098/room/"+uID+"/"+itemId;
        System.out.println(target + " UID: " + uID + " ItemId: " + itemId);
        response.sendRedirect(target);
//        request.getRequestDispatcher(target).forward(request, response);
        System.out.println("Create Bid Done");
//        HttpHeaders headers = new HttpHeaders();
//        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//        HttpEntity<AuctionItem> entity = new HttpEntity<AuctionItem>(item, headers);
        //ResponseEntity<String> r = restTemplate.exchange("http://localhost:8098/api/bids", HttpMethod.POST, entity, String.class);
        return new ResponseEntity<>("Bid Created Successfully", HttpStatus.CREATED);
    }

    @GetMapping("/items")
    public ResponseEntity<List<AuctionItem>> getAllItems(HttpServletRequest request, HttpServletResponse response, @RequestParam(required = false)String query){
        return ResponseEntity.ok(auctionItemService.getAllItems(query));
    }

    //forwards to the specific item page
    @GetMapping("/items/{id}")
    public ResponseEntity<AuctionItem> getAuctionItemByID(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") long id) throws ServletException, IOException {
//        String u = (String) request.getSession().getAttribute("username");
//        if(u == null) u = "...";
//        System.out.println("Username: " + u);
//        String target = "";//insert link to Aidan's part...
//        request.getRequestDispatcher(target).forward(request, response);
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
