package com.thondo.whatsappconnect.entity;

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
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "MAIN_PROFILE")
public class MainProfile {

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
    
    @Column(name = "MOBILE_NUMBER")
    private String mobileNumber;

    @Column(name = "REF_MOBILE_NUMBER")
    private String refMobileNumber;

    @Column(name = "FULL_NAME")
    private String fullName;

    @Column(name = "GENDER")
    private String gender;

    @Column(name = "ID_NUMBER")
    private String IdNumber;

    @Column(name = "FULL_ADDRESS")
    private String fullAddress;

    @Column(name = "DOB")
    private String dateOfBirth;

    @Column(name = "APPROVAL_STATUS")
    private String approvalStatus;

    @Column(name = "ID_IMAGE_URL")
    private String idImageUrl;

    @Column(name = "CURRENT_ORDER")
    private String currentOrder;

    @Column(name = "SELFIE_IMAGE_URL")
    private String selfieImageUrl;

    @Column(name = "CREATED_BY_USER_ID")
    private String createdByUserId;

    @Column(name = "MENU_STAGE")
    private int menuStage;

    @Column(name = "MENU_SELECTED")
    private String menuSelected;
}
