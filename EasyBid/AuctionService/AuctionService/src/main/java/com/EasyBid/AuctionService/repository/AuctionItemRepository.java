package com.EasyBid.AuctionService.repository;

import com.EasyBid.AuctionService.model.AuctionItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuctionItemRepository extends JpaRepository<AuctionItem, Long>{
}
