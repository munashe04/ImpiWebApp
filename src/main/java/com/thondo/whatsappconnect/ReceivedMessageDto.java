package com.thondo.whatsappconnect;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class ReceivedMessageDto {
    private String sid;
    private String date_created;
    private String date_updated;
    private String date_sent;
    private String account_sid;
    private String to;
    private String from;
    private String body;
    private String status;
    private String flags;
    private String api_version;
    private String price;
    private String uri;
}
