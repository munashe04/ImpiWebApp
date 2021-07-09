package com.thondo.whatsappconnect.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

public class OrderItemDTO {
    private String id;
    private String name;
    private String description;
    private String status;
    private String type;
    private boolean currentItemDone;
    private int quantity;

}
