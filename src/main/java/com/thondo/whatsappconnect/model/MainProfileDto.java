package com.thondo.whatsappconnect.model;

import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MainProfileDto {
    private String id;
    private String mobileNumber;
    private String fullName;
    private String refMobileNumber;
    private String IdNumber;
    private String approvalStatus;
    private LocalDateTime dateCreated;
    private String gender;
}
