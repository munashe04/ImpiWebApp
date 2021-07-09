package com.thondo.whatsappconnect.service;

import com.thondo.whatsappconnect.entity.Item;
import com.thondo.whatsappconnect.entity.MainProfile;
import com.thondo.whatsappconnect.entity.OrderItem;
import com.thondo.whatsappconnect.entity.Orders;
import com.thondo.whatsappconnect.enums.MenuEnum;
import com.thondo.whatsappconnect.repository.ItemRepository;
import com.thondo.whatsappconnect.repository.MainProfileRepository;
import com.thondo.whatsappconnect.repository.OrderItemRepository;
import com.thondo.whatsappconnect.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {
    @Autowired
    private OrdersRepository ordersRepository;
    @Autowired
    private MainProfileRepository mainProfileRepository;
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;


    public String orderPlacement(Orders order, MainProfile mainProfile, String body, String imageUrl) {


        if (order.getMenuStage() == 1) {
            System.out.println("xx: menu stage is 1 and user selected :" + body);
            // Solar
            if (body.equalsIgnoreCase("1")) {
                System.out.println("xx: return Home Systems");
                order.setMenuStage(2);
                order.setCurrentOrderType("Home Systems");
                order.setCurrentItem(1);
                ordersRepository.save(order);
                return "Solar Home Systems\n" +
                        "\t•[1]\tPICO\n" +
                        "\t•[2]\tPICO plus\n" +
                        "\t•[3]\tPro 200\n" +
                        "\t•[4]\tPro 300\n" +
                        "\t•[5]\tPro 400\n" +
                        "\t•[6]\tBoom\n" +
                        "\t•[7]\tHome 40z\n" +
                        "\t•[8]\tHome 60\n" +
                        "\t•[9]\tHome 120\n" +
                        "\t•[10]\tHome 400\n" +
                        "\t•[11]\tLights\n";

            } else if (body.equalsIgnoreCase("2")) {
                System.out.println("xx: return Pumps");
                order.setMenuStage(2);
                order.setCurrentItem(2);
                order.setCurrentOrderType("Pumps");
                ordersRepository.save(order);
                return "Solar Pumps\n" +
                        "\t•[1]\tLorenz PS2-100\n" +
                        "\t•[2]\tFuture Pumps SF1\n" +
                        "\t•[3]\tFuture Pumps SF2";
            } else {
                System.out.println("xx: selection not valid return Main menu");
                return "[1]Solar Home Systems\n" +
                        "[2] Solar Pumps\n";
            }


        } else if (order.getMenuStage() == 2) {
            System.out.println("xxXX: menu stage 2 user body :" + body);
            try {
                int qty = Integer.parseInt(body);
                if ((qty > 11 || qty <= 0) && order.getCurrentOrderType().equalsIgnoreCase("Home Systems")) {
                    System.out.println("xxXX: invalid selection back to home systems menu");
                    return "Solar Home Systems\n" +
                            "\t•[1]\tPICO\n" +
                            "\t•[2]\tPICO plus\n" +
                            "\t•[3]\tPro 200\n" +
                            "\t•[4]\tPro 300\n" +
                            "\t•[5]\tPro 400\n" +
                            "\t•[6]\tBoom\n" +
                            "\t•[7]\tHome 40z\n" +
                            "\t•[8]\tHome 60\n" +
                            "\t•[9]\tHome 120\n" +
                            "\t•[10]\tHome 400\n" +
                            "\t•[11]\tLights\n";
                }
                if ((qty > 3 || qty <= 0) && order.getCurrentOrderType().equalsIgnoreCase("Pumps")) {
                    System.out.println("xxXX: invalid selection back to Pumps menu");
                    return "Solar Pumps\n" +
                            "\t•[1]\tLorenz PS2-100\n" +
                            "\t•[2]\tFuture Pumps SF1\n" +
                            "\t•[3]\tFuture Pumps SF2";
                }//check if its valid
                if (order != null && (order.getOrderItems() == null || order.getOrderItems().isEmpty())) {
                    System.out.println("xxXX: processing order");
                    order.setOrderItems(new ArrayList<>());
                    OrderItem orderItem = new OrderItem();
                    orderItem.setName(body);
                    orderItem.setCurrentItemDone(false);
                    orderItem.setQuantity(1);
                    System.out.println("xxXX: processing order the order is:" + order);
                    Optional<Item> byTypeAndPosition = itemRepository.findByTypeAndPosition(order.getCurrentOrderType(), qty);

                    if (byTypeAndPosition.isPresent()) {
                        System.out.println("xxXX: processing order findByTypeAndPosition ITEM:" + byTypeAndPosition.get());
                        orderItem.setItem(byTypeAndPosition.get());
                        orderItem.setOrders(order);
                        orderItem.setStatus("Pending");
                        orderItem.setCurrentItemDone(false);
                        orderItemRepository.save(orderItem);
                    } else {

                        return "Error on getting order item. contact admin";
                    }
                    order.setOrderName(body);
                    order.getOrderItems().add(orderItem);
                    order.setMenuStage(3);
                    ordersRepository.save(order);
                } else if (order != null && (!order.getOrderItems().isEmpty())) {
                  //order is not empty
                    System.out.println("Existing order adding items");
                    Optional<Item> byTypeAndPosition1 = itemRepository.findByTypeAndPosition(order.getCurrentOrderType(), qty);
                    order.getOrderItems().forEach(orderItem -> {
                        if (byTypeAndPosition1.isPresent() && orderItem.getName().equalsIgnoreCase(byTypeAndPosition1.get().getName())){
                            System.out.println("Existing Existing item order adding items");
                            orderItem.setCurrentItemDone(false);
                            orderItem.setQuantity(1);
                            orderItemRepository.save(orderItem);
                        }else{
                            System.out.println("Existing order but new item xxXX1: ");
                            OrderItem orderItem1 = new OrderItem();
                            orderItem1.setName(body);
                            orderItem1.setCurrentItemDone(false);
                            orderItem1.setQuantity(1);
                            System.out.println("xxXX1 zzzzz: processing order the order is:" + order);


                            if (byTypeAndPosition1.isPresent()) {
                                System.out.println("x>>>>> processing order findByTypeAndPosition ITEM:" + byTypeAndPosition1.get());
                                orderItem1.setItem(byTypeAndPosition1.get());
                                orderItem1.setOrders(order);
                                orderItem1.setStatus("Pending");
                                orderItem1.setCurrentItemDone(false);
                                orderItemRepository.save(orderItem1);
                            }else{
                                System.out.println(">>>>>Error here no main item.");
                            }
                        }
                    });

                    order.setOrderName(body);
                    order.setMenuStage(3);
                    ordersRepository.save(order);
                }
            } catch (Exception e) {
                e.printStackTrace();
                return "Please enter a number";
            }


            return "Quantity";
        } else if (order.getMenuStage() == 3) {
            System.out.println(" XXX: menu stage 3 with body :" + body);
            //check if its valid
            Optional<OrderItem> currentOrderItem = order.getOrderItems().stream().filter(orderItem -> !orderItem.isCurrentItemDone()).findFirst();


            try {
                int qty = Integer.parseInt(body);
                if (currentOrderItem.isPresent()) {
                    System.out.println(" XXX: current order item :" + currentOrderItem.get());
                    OrderItem updatedOrderItem = currentOrderItem.get();
                    updatedOrderItem.setQuantity(qty);
                    List<OrderItem> orderITems = order.getOrderItems().stream().filter(orderItem -> currentOrderItem.get().getId().equalsIgnoreCase(orderItem.getId())).collect(Collectors.toList());
                    order.setMenuStage(4);
                    updatedOrderItem.setCurrentItemDone(true);
                    orderITems.add(updatedOrderItem);
                    orderItemRepository.save(updatedOrderItem);
                    order.setOrderItems(orderITems);
                    ordersRepository.save(order);
                } else {
                    System.out.println(" XXX: no current order item:");
                    System.out.println("Error on getting current pending order item");
                }

            } catch (Exception e) {
                System.out.println(" XXX: Error  menu stage 3 body not number:");
                return "Please enter a number";
            }

            return "1. Add Another Product \\n 2. Continue";
        } else if (order.getMenuStage() == 4) {
            System.out.println(" XX4XX:  menu stage 4 body :" + body);
            if (body.equalsIgnoreCase("1")) {
                //agent wants to add another order.
                //reset all the other orders
                /*Orders newOrder = new Orders();
                newOrder.setRefMobileNumber(mainProfile.getMobileNumber());
                newOrder.setMenuStage(1);
                newOrder.setStatus("Pending");
                ordersRepository.save(newOrder);*/
                order.setMenuStage(1);
                mainProfile.setMenuStage(0);
                mainProfileRepository.save(mainProfile);
                order.setStatus("Pending");
                ordersRepository.save(order);
                return "[1]Solar Home Systems\n" +
                        "[2] Solar Pumps\n";

            } else if (body.equalsIgnoreCase("2")) {
                order.setMenuStage(5);
                mainProfile.setMenuStage(5);
                mainProfileRepository.save(mainProfile);
                order.setStatus("Completed");
                ordersRepository.save(order);
                return "Name of Customer";
            } else {
                return "Invalid input. Please enter choose.1. Add Another Product \\n 2. Continue";
            }

        } else {
            return "Please contact our administrator for support";
        }

    }

    public String ordersFinalisation(MainProfile mainProfile, String body, String imageUrl) {
        Optional<Orders> optionalOrder = ordersRepository.findByRefMobileNumberAndOrderStatus(mainProfile.getMobileNumber(), "Pending");
        if (!optionalOrder.isPresent()) {
            //handle
            System.out.println("no orders");
            return "Contact admin";
        }
        Orders order = optionalOrder.get();
        if (mainProfile.getMenuStage() == 5) {
            System.out.println(" XX5XX:  menu stage 5 body :" + body);
            mainProfile.setMenuStage(6);

            order.setCustomerName(body);
            ordersRepository.save(order);


            return "Customer Phone number";
        } else if (mainProfile.getMenuStage() == 6) {
            System.out.println(" XX6XX:  menu stage 6 body :" + body);
            mainProfile.setMenuStage(7);

            order.setCustomerNumber(body);
            ordersRepository.save(order);

            return "Customer Address";

        } else if (mainProfile.getMenuStage() == 7) {
            System.out.println(" XX7XX:  menu stage 7 body :" + body);
            mainProfile.setMenuStage(8);

            order.setCustomerAddress(body);
            ordersRepository.save(order);

            return "Payment terms \\n \\t [1] Cash \\n \\t [2] Credit";
        } else if (mainProfile.getMenuStage() == 8) {
            System.out.println(" XX8XX:  menu stage 8 body :" + body);
            if (body.equalsIgnoreCase("1")) {
                mainProfile.setMenuStage(9);
                /*
                Setting order status pending for the orders that havent been paid yet
                 */

                order.setOrderStatus("PAYMENT RECEIVED");

                order.setPaymentTerms("Cash");
                ordersRepository.save(order);

                return "Customer ID Number";
            } else if (body.equalsIgnoreCase("2")) {
                mainProfile.setMenuStage(9);

                order.setPaymentTerms("Credit");
                 /*
                Setting order status pending for the orders that havent been paid yet
                 */

                order.setOrderStatus("PAYMENT PENDING");
                ordersRepository.save(order);

                return "Customer ID Number";
            } else {
                return "Invalid input. Please enter choose\\n.Payment terms \\n \\t [1] Cash \\n \\t [2] Credit";
            }
        } else if (mainProfile.getMenuStage() == 9) {
            System.out.println(" XX9XX:  menu stage 9 body :" + body);
            mainProfile.setMenuStage(10);

            order.setCustomerIdNumber(body);
            ordersRepository.save(order);

            return "Customer ID document";
        } else if (mainProfile.getMenuStage() == 10) {
            System.out.println(" XX4XX:  menu stage 10 body :" + body);
            if (imageUrl == null) {
                return "Please upload a valid Customer ID document";
            }
            mainProfile.setMenuStage(11);

            order.setIdImageUrl(imageUrl);
            ordersRepository.save(order);

            return "Customer ID picture";
        } else if (mainProfile.getMenuStage() == 11) {
            System.out.println(" XX11XX:  menu stage 11 body :" + body);
            if (imageUrl == null) {
                return "Please upload a valid Customer ID picture";
            }
            mainProfile.setMenuStage(12);

            order.setCustomerImageUrl(imageUrl);
            ordersRepository.save(order);


            return "Source of Income";
        } else if (mainProfile.getMenuStage() == 12) {
            System.out.println(" XX12XX:  menu stage 12 body :" + body);
            mainProfile.setMenuStage(13);

            order.setSourceOfIncome(body);
            ordersRepository.save(order);

            String response = "";
            List<OrderItem> orderItems = order.getOrderItems();
            for (OrderItem orderItemSummary : orderItems) {
                response = response + orderItemSummary.getItem().getName() + " X " + orderItemSummary.getQuantity() +"\n";
            }

            //order Summary.
            return "Order Summary \n" +
                    "\t Kindly confirm your order below : \n" + "\t" +
                    response + "\n  1.Confirm \n 2.Redo Order";

        } else if (mainProfile.getMenuStage() == 13) {
            System.out.println(" XX13XX:  menu stage 13 body :" + body);
            if (body.equalsIgnoreCase("1")) {
                mainProfile.setMenuStage(0);
                mainProfile.setMenuSelected(MenuEnum.ORDER.getValue());
                mainProfileRepository.save(mainProfile);
                if (order.getStatus().equalsIgnoreCase("PAYMENT RECEIVED")){
                    order.setOrderStatus("COMPLETED");
                }
                order.setStatus("Submitted");
               // order.setOrderStatus("Completed");
                ordersRepository.save(order);
                return "Thank you for the order. Type any word again to get order menus";
            } else if (body.equalsIgnoreCase("2")) {
                //redo
                //delete orders
                order.getOrderItems().forEach(orderItem -> {
                    orderItemRepository.delete(orderItem);
                });
                ordersRepository.delete(order);
                mainProfile.setMenuStage(1);
                mainProfile.setMenuSelected(MenuEnum.ORDER.getValue());
                mainProfileRepository.save(mainProfile);
             Orders newOrder = new Orders();
             newOrder.setRefMobileNumber(mainProfile.getMobileNumber());
             newOrder.setMenuStage(1);
             newOrder.setOrderStatus("Pending");
             newOrder.setStatus("Pending");
             ordersRepository.save(newOrder);
                return "[1]Solar Home Systems\n" +
                        "[2] Solar Pumps\n";

            } else {
                return "Invalid input.\n  1.Confirm \n 2.Redo Order";
            }


        } else {
            return "Please contact our administrator for support";
        }

    }


}

