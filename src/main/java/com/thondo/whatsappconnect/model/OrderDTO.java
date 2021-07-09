package com.thondo.whatsappconnect.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

public class OrderDTO {
    private String id;
    private String createdBy;
    private LocalDateTime dateCreated;
    private String customerNumber;
    private String refMobileNumber;
    private String customerName;
    private String status;
    private String orderStatus;
    private String orderName;
    private String currentOrderType;
    private String quantity;
    private String customerIdNumber;
    private String customerAddress;
    private String paymentTerms;
    private String approvalStatus;
    private String idImageUrl;
    private String customerImageUrl;
    private String sourceOfIncome;
    private String createdByUserId;
    private int menuStage;
    private int currentItem;
    private String menuSelected;
    private List<OrderItemDTO> orderItems;

}
