package com.EasyBid.AuctionService.serviceImpl;

import com.EasyBid.AuctionService.entity.AuctionItem;
import com.EasyBid.AuctionService.repository.AuctionItemRepository;
import com.EasyBid.AuctionService.service.AuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

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
        HashSet<AuctionItem> output = null;
        for (AuctionItem item : items) {
            output = (output == null) ? new HashSet<>() : output;

            if(item.getName().contains(query)) output.add(item);
            if(item.getDescription().contains(query)) output.add(item);
        }

        return (output.size() <= 0) ? null : new ArrayList<>(output);
    }

    @Override
    public AuctionItem getItemById(long itemId) {
        //List<AuctionItem> output = auctionRepository.findAllById(Collections.singleton(itemId));
        //return (output.size() <= 0) ? null : output.get(0);
        return auctionRepository.getReferenceById(itemId);
    }

    @Override
    public boolean updateItem(long id, AuctionItem update) {
        auctionRepository.findById(id)
                .map(
                    prev -> {
                        prev.setName(update.getName());
                        prev.setDescription(update.getDescription());
                        prev.setPrice(update.getPrice());
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
