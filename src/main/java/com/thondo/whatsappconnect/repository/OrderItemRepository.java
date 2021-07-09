package com.thondo.whatsappconnect.repository;

import com.thondo.whatsappconnect.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, String> {

}
