package com.EasyBid.AuctionService.serviceImpl;

import com.EasyBid.AuctionService.entity.AuctionItem;
import com.EasyBid.AuctionService.repository.AuctionItemRepository;
import com.EasyBid.AuctionService.service.AuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AuctionServiceImpl implements AuctionService {

    @Autowired
    private AuctionItemRepository auctionRepository;

    @Override
    public AuctionItem save(AuctionItem item) {
        return auctionRepository.save(item);
    }

    @Override
    public List<AuctionItem> getAllItems() {
        return auctionRepository.findAll();
    }

    @Override
    public List<AuctionItem> getItemsByQuery(String query) {
        List<AuctionItem> items = getAllItems();
        for (AuctionItem item : items) {
            if(!item.getName().contains(query)) items.remove(item);
        }
        return items;
    }

    @Override
    public AuctionItem getItemById(long itemId) {
        return auctionRepository.findById(itemId).get();
    }

    @Override
    public boolean updateItem(long id, AuctionItem update) {
        auctionRepository.findById(id)
                .map(
                    prev -> {
                        prev.setName(update.getName());
                        prev.setDescription(update.getDescription());
                        prev.setPrice(update.getPrice());
                        prev.setAuctionType(update.getAuctionType());
                        return ResponseEntity.ok(true);
                    }
                ).orElseGet(() ->{
                    auctionRepository.save(update);
                    return ResponseEntity.ok(false);
                });
        return false;
    }

    @Override
    public void deleteItem(long id) {
        auctionRepository.deleteById(id);
    }

    public void deleteAllItems(){
        auctionRepository.deleteAll();
    }
}
