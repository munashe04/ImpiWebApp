package com.thondo.whatsappconnect.service.external;

import com.thondo.whatsappconnect.entity.MainProfile;
import com.thondo.whatsappconnect.entity.OrderItem;
import com.thondo.whatsappconnect.entity.Orders;
import com.thondo.whatsappconnect.model.OrderDTO;
import com.thondo.whatsappconnect.model.OrderItemDTO;
import com.thondo.whatsappconnect.model.convertors.OrderDtoConverter;
import com.thondo.whatsappconnect.model.convertors.OrderItemDtoConverter;
import com.thondo.whatsappconnect.repository.ItemRepository;
import com.thondo.whatsappconnect.repository.MainProfileRepository;
import com.thondo.whatsappconnect.repository.OrderItemRepository;
import com.thondo.whatsappconnect.repository.OrdersRepository;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@ToString
public class OrderServiceImplExternal implements OrderServiceExternal{
    @Autowired
    private OrdersRepository ordersRepository;
    @Autowired
    private MainProfileRepository mainProfileRepository;
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;
    @Autowired
    OrderDtoConverter orderDtoConverter;
    @Autowired
    OrderItemDtoConverter orderItemDtoConverter;


    public List<OrderDTO> getOrders() {
        List<Orders> orders = ordersRepository.findAll();
        List<OrderDTO> response = new ArrayList<>();
        for (Orders order : orders) {
            OrderDTO orderDTO = new OrderDTO();
            orderDTO.setApprovalStatus(order.getApprovalStatus());
            orderDTO.setCreatedBy(order.getCreatedBy());
            orderDTO.setCreatedByUserId(order.getCreatedByUserId());
            orderDTO.setCustomerAddress(order.getCustomerAddress());
            orderDTO.setCustomerIdNumber(order.getCustomerIdNumber());
            orderDTO.setCustomerImageUrl(order.getCustomerImageUrl());
            orderDTO.setCustomerName(order.getCustomerName());
            orderDTO.setCustomerNumber(order.getCustomerNumber());
            orderDTO.setId(order.getId());
            orderDTO.setIdImageUrl(order.getIdImageUrl());
            orderDTO.setOrderStatus(order.getOrderStatus());
            orderDTO.setPaymentTerms(order.getPaymentTerms());
            orderDTO.setRefMobileNumber(order.getRefMobileNumber());
            orderDTO.setStatus(order.getStatus());
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
            orderDTO.setOrderItems(orderItems);
            response.add(orderDTO);
        }
        return response;
    }

    public List<OrderDTO> getOrdersByAgent(String agentNumber) {
        List<Orders> orders = ordersRepository.findByRefMobileNumber(agentNumber);
        return orderDtoConverter.ordersToDto(orders);

    }
    public List<OrderDTO>ordersByCustomer(String customerName){
        List<Orders>orders = ordersRepository.
                findAll().
                stream().
                filter(orders1 -> orders1.getCustomerName().
                        equalsIgnoreCase(customerName) ).
                         collect(Collectors.toList());

        return orderDtoConverter.ordersToDto(orders);
    }
    public List<OrderDTO> getPendingOrders(){
        String pending = "Pending";
        List<Orders>pendingOrders = ordersRepository.findAll();
        List<Orders> ordersPending = pendingOrders.stream()
                .filter(orders -> orders.getApprovalStatus().equalsIgnoreCase(pending))
                .collect(Collectors.toList());
        return orderDtoConverter.ordersToDto(ordersPending);
    }
    public List<OrderDTO> getPaymentPendingOrders(){
        String pending = "PAYMENT PENDING";
        List<Orders>pendingOrders = ordersRepository.findAll();
        List<Orders> ordersPendingPayment = pendingOrders.stream()
                .filter(orders -> orders.getOrderStatus().equalsIgnoreCase(pending))
                .collect(Collectors.toList());
        return orderDtoConverter.ordersToDto(ordersPendingPayment);
    }
    public List<OrderDTO> getDispatchedOrders(){
        String dispatched = "DISPATCHED";
        List<Orders>dispatchedOrders = ordersRepository.findAll();
        List<Orders> ordersDispatched = dispatchedOrders.stream()
                .filter(orders -> orders.getApprovalStatus().equalsIgnoreCase(dispatched))
                .collect(Collectors.toList());
        return orderDtoConverter.ordersToDto(ordersDispatched);
    }
    public Orders dispatchStatus(OrderDTO orderDTO){
        orderDTO.setStatus("DISPATCHED");
        return ordersRepository.save(orderDtoConverter.orderDtoToEntity(orderDTO));
    }
    public Orders paymentReceived(OrderDTO orderDTO){
        orderDTO.setOrderStatus("COMPLETED");
        return ordersRepository.save(orderDtoConverter.orderDtoToEntity(orderDTO));
    }
    public void declineOrder(OrderDTO orderDto){

         ordersRepository.delete(orderDtoConverter.orderDtoToEntity(orderDto));
    }






}

