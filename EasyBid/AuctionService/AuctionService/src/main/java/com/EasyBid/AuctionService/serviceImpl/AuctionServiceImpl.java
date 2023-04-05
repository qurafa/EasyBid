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
        //System.out.println(item.toString());
        AuctionItem i = auctionRepository.save(item);
        System.out.println(i.toString());
        return i;
    }

    @Override
    public List<AuctionItem> getAllItems(String query) {
        List<AuctionItem> temp = auctionRepository.findAll();
        if(query == null){
            return temp;
        }
        else{
            List<AuctionItem> output = new ArrayList<>();
            for(int i = 0; i < temp.size(); i++){
                System.out.println("Name: " + temp.get(i).getName() + " Description: " + temp.get(i).getDescription());
                if(temp.get(i).getName().contains(query) || temp.get(i).getDescription().contains(query))
                    output.add(temp.get(i));
            }
            return output;
        }
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
                        prev.setStartPrice(update.getStartPrice());
                        prev.setCurrentPrice(update.getCurrentPrice());
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
