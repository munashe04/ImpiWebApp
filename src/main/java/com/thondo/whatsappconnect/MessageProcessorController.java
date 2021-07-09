package com.thondo.whatsappconnect;

import com.thondo.whatsappconnect.service.MessageProcessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
@RequestMapping("/app")
public class MessageProcessorController {
    @Autowired
    private MessageProcessorService messageProcessorService;

    @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public String processMessage(@RequestParam MultiValueMap<String, String> paramMap) {
        System.out.println(" received the msg >>>>>>>>>>>>>>>>>" + paramMap);
        if (paramMap != null) {
            return messageProcessorService.processMessage(paramMap);
        }else{
            return "Cannot process request";
        }



    }


}
