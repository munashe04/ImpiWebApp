package com.thondo.whatsappconnect.repository;

import com.thondo.whatsappconnect.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrdersRepository extends JpaRepository<Orders, String> {
    Optional<Orders> findByRefMobileNumberAndOrderStatus(String customerNumber,String orderStatus);
    Optional<Orders> findByRefMobileNumberAndStatus(String customerNumber,String status);
    List<Orders> findByRefMobileNumber(String refMobileNumber);
}
