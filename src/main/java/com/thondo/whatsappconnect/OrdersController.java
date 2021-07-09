package com.thondo.whatsappconnect;

import com.thondo.whatsappconnect.entity.Orders;
import com.thondo.whatsappconnect.model.OrderDTO;
import com.thondo.whatsappconnect.service.external.OrderServiceExternal;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@CrossOrigin(origins ="http://localhost:4200" )
@RequestMapping("/orders")
public class OrdersController {

    @Qualifier("orderServiceImplExternal")
    @Autowired
    OrderServiceExternal orderServiceExt;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @CrossOrigin(origins ="http://localhost:4200" )
    public List<OrderDTO> getOrder() {
        System.out.println(" getting orders >>>>>>>>>>>>>>>>>");
        return orderServiceExt.getOrders();
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping("/byAgent/{refMobileNumber}")
    @CrossOrigin(origins ="http://localhost:4200" )
    @ResponseStatus(HttpStatus.OK)
    public List<OrderDTO> getOrderByAgent(@PathVariable ("refMobileNumber") String refMobileNumber) {
        System.out.println(" getting orders >>>>>>>>>>>>>>>>>");

        return orderServiceExt.getOrdersByAgent(refMobileNumber);
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping("/pending")
    @CrossOrigin(origins ="http://localhost:4200" )
    @ResponseStatus(HttpStatus.OK)
    public List<OrderDTO> getPendingOrder() {
        System.out.println(" getting pending orders >>>>>>>>>>>>>>>>>");
        return orderServiceExt.getPendingOrders();
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping("/byCustomer/{customerName}")
    @CrossOrigin(origins ="http://localhost:4200" )
    @ResponseStatus(HttpStatus.OK)
    public List<OrderDTO> ordersByCustomer(@PathVariable ("customerName") String customerName) {
        System.out.println(" getting orders by customer>>>>>>>>>>>>>>>>>");
        return orderServiceExt.ordersByCustomer(customerName);
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping("/paymentPending")
    @CrossOrigin(origins ="http://localhost:4200" )
    @ResponseStatus(HttpStatus.OK)
    public List<OrderDTO> getPaymentPendingOrder() {
        System.out.println(" getting payment pending orders >>>>>>>>>>>>>>>>>");
        return orderServiceExt.getPaymentPendingOrders();
    }
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping("/dispatchOrder")
    @CrossOrigin(origins ="http://localhost:4200" )
    @ResponseStatus(HttpStatus.OK)
    public Orders dispatchOrder(OrderDTO orderDTO) {
        System.out.println(" dispatching order >>>>>>>>>>>>>>>>>");
        return orderServiceExt.dispatchStatus(orderDTO);
    }
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping("/paymentReceived")
    @CrossOrigin(origins ="http://localhost:4200" )
    @ResponseStatus(HttpStatus.OK)
    public Orders paymentReceived(OrderDTO orderDTO) {
        System.out.println(" payment received for order >>>>>>>>>>>>>>>>>");
        return orderServiceExt.paymentReceived(orderDTO);
    }
    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping("/declineOrder")
    @CrossOrigin(origins ="http://localhost:4200" )
    @ResponseStatus(HttpStatus.OK)
    public void declineOrder(OrderDTO orderDTO) {
        System.out.println(" Deleting order >>>>>>>>>>>>>>>>>");
         orderServiceExt.declineOrder(orderDTO);
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping("/dispatchedOrders")
    @CrossOrigin(origins ="http://localhost:4200" )
    @ResponseStatus(HttpStatus.OK)
    public List<OrderDTO> getDispatchedOrders(){
        System.out.println(" getting payment pending orders >>>>>>>>>>>>>>>>>");
        return orderServiceExt.getDispatchedOrders();

    }



}
