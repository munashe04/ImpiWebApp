package com.thondo.whatsappconnect.repository;

import com.thondo.whatsappconnect.entity.Item;
import com.thondo.whatsappconnect.entity.MainProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, String> {
    Optional<Item> findByTypeAndPosition(String type,int position);
}
