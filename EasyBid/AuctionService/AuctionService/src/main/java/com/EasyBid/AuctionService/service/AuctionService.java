package com.EasyBid.AuctionService.service;

import com.EasyBid.AuctionService.entity.AuctionItem;

import java.util.List;
import java.util.Optional;

public interface AuctionService {

    AuctionItem save(AuctionItem item);

    List<AuctionItem> getAllItems();

    List<AuctionItem> getItemsByQuery(String query);

    AuctionItem getItemById(long itemId);

    boolean updateItem(long id, AuctionItem i);

    void deleteItem(long id);

    void deleteAllItems();
}
