package com.EasyBid.AuctionService.controller;

import com.EasyBid.AuctionService.repository.AuctionItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuctionItemController {

    @Autowired
    private AuctionItemRepository itemRepo;

}
