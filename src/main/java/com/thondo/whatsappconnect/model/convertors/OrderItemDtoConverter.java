package com.thondo.whatsappconnect.model.convertors;

import com.thondo.whatsappconnect.entity.OrderItem;
import com.thondo.whatsappconnect.model.OrderItemDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderItemDtoConverter {
    public OrderItemDTO orderItemsToDto(OrderItem orderItem) {
        OrderItemDTO orderItemsResponseDto = new OrderItemDTO();
        orderItemsResponseDto.setId(orderItem.getId());
        orderItemsResponseDto.setName(orderItem.getName());
        orderItemsResponseDto.setQuantity(orderItem.getQuantity());
        return orderItemsResponseDto;
    }

    public List<OrderItemDTO> orderItemsToDto(List<OrderItem> orderItems) {
        return orderItems.stream().map(x -> orderItemsToDto(x)).collect(Collectors.toList());
    }
}
