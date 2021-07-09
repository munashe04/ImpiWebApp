package com.thondo.whatsappconnect.entity;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "ORDERS")
public class Orders {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "ID", columnDefinition = "VARCHAR(40)")
    private String id;

    @Column(name = "CREATED_BY")
    private String createdBy;

    @CreationTimestamp
    @Column(name = "DATE_CREATED")
    private LocalDateTime dateCreated;
    
    @Column(name = "CUSTOMER_NUMBER")
    private String customerNumber;

    @Column(name = "REF_MOBILE_NUMBER")
    private String refMobileNumber;

    @Column(name = "CUSTOMER_NAME")
    private String customerName;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "ORDER_STATUS")
    private String orderStatus;

    @Column(name = "ORDER_NAME")
    private String orderName;

    @Column(name = "CURRENT_ORDER_TYPE")
    private String currentOrderType;

    @Column(name = "QUANTITY")
    private String quantity;

    @Column(name = "CUSTOMER_ID_NUMBER")
    private String customerIdNumber;

    @Column(name = "CUSTOMER_ADDRESS")
    private String customerAddress;

    @Column(name = "PAYMENT_TERMS")
    private String paymentTerms;

    @Column(name = "APPROVAL_STATUS")
    private String approvalStatus;

    @Column(name = "ID_IMAGE_URL")
    private String idImageUrl;

    @Column(name = "CUSTOMER_IMAGE_URL")
    private String customerImageUrl;

    @Column(name = "SOURCE_OF_INCOME")
    private String sourceOfIncome;

    @Column(name = "CREATED_BY_USER_ID")
    private String createdByUserId;

    @Column(name = "MENU_STAGE")
    private int menuStage;

    @Column(name = "CURRENT_ITEM")
    private int currentItem;

    @Column(name = "MENU_SELECTED")
    private String menuSelected;
    @JsonIgnore
    @OneToMany(mappedBy = "orders")
    private List<OrderItem> orderItems;
}
