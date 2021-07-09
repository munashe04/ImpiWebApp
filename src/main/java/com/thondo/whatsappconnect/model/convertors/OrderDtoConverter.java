package com.thondo.whatsappconnect.model.convertors;

import com.thondo.whatsappconnect.entity.OrderItem;
import com.thondo.whatsappconnect.entity.Orders;
import com.thondo.whatsappconnect.model.OrderDTO;
import com.thondo.whatsappconnect.model.OrderItemDTO;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Component
public class OrderDtoConverter {
    public OrderDTO ordersToDto(Orders orders) {
        OrderDTO ordersResponseDto = new OrderDTO();
        ordersResponseDto.setId(orders.getId());
        ordersResponseDto.setCustomerName(orders.getCustomerName());
        ordersResponseDto.setDateCreated(orders.getDateCreated());
       // ordersResponseDto.setOrderItems(orders.getOrderItems());
        List<OrderItemDTO> orderItems = new ArrayList<>();
        for (OrderItem item : orders.getOrderItems()) {
            OrderItemDTO orderItemDTO = new OrderItemDTO();
            orderItemDTO.setId(item.getId());
            orderItemDTO.setDescription(item.getItem().getName());
            orderItemDTO.setQuantity(item.getQuantity());
            orderItemDTO.setName(item.getItem().getName());
            orderItemDTO.setStatus(item.getStatus());
            orderItems.add(orderItemDTO);
        }
        ordersResponseDto.setPaymentTerms(orders.getPaymentTerms());
        return ordersResponseDto;
    }

    public List<OrderDTO> ordersToDto(List<Orders> orders) {
        return orders.stream().map(x -> ordersToDto(x)).collect(Collectors.toList());
    }
    public Orders orderDtoToEntity(OrderDTO orderDTO){
        Orders order = new Orders();
        order.setOrderStatus(orderDTO.getOrderStatus());
        order.setCurrentItem(orderDTO.getCurrentItem());
        order.setMenuStage(orderDTO.getMenuStage());
        order.setPaymentTerms(orderDTO.getPaymentTerms());
        order.setApprovalStatus(orderDTO.getApprovalStatus());
        order.setQuantity(orderDTO.getQuantity());
        order.setOrderName(orderDTO.getOrderName());
        order.setCreatedBy(orderDTO.getCreatedBy());
        order.setCreatedByUserId(orderDTO.getCreatedByUserId());
        order.setCurrentOrderType(orderDTO.getCurrentOrderType());
        order.setCustomerAddress(orderDTO.getCustomerAddress());
        order.setCustomerIdNumber(orderDTO.getCustomerIdNumber());
        order.setCustomerImageUrl(orderDTO.getCustomerImageUrl());
        order.setDateCreated(orderDTO.getDateCreated());
        order.setId(orderDTO.getId());
        order.setRefMobileNumber(orderDTO.getRefMobileNumber());
        order.setSourceOfIncome(orderDTO.getSourceOfIncome());
        order.setCustomerNumber(orderDTO.getCustomerNumber());
        order.setStatus(orderDTO.getStatus());
        order.setIdImageUrl(orderDTO.getIdImageUrl());
        order.setCustomerName(orderDTO.getCustomerName());
        order.setMenuSelected(order.getMenuSelected());
        List<OrderItemDTO> orderItems = new ArrayList<>();
        for (OrderItem item : order.getOrderItems()) {
            OrderItemDTO orderItemDTO = new OrderItemDTO();
            orderItemDTO.setId(item.getId());
            orderItemDTO.setDescription(item.getItem().getName());
            orderItemDTO.setQuantity(item.getQuantity());
            orderItemDTO.setName(item.getItem().getName());
            orderItemDTO.setStatus(item.getStatus());
            orderItems.add(orderItemDTO);
        }
        return order;


    }
}
