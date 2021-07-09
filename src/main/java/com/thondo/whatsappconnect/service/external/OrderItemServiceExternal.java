package com.thondo.whatsappconnect.service.external;

import com.thondo.whatsappconnect.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderItemServiceExternal {
    @Autowired
    OrderItemRepository orderItemRepository;


}
