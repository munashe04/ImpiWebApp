package com.thondo.whatsappconnect;

import com.twilio.twiml.MessagingResponse;
import com.twilio.twiml.TwiMLException;
import com.twilio.twiml.messaging.Body;
import com.twilio.twiml.messaging.Message;
import com.twilio.twiml.messaging.Redirect;
import lombok.RequiredArgsConstructor;
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
@RequestMapping("/callback")
public class MessageCallbackController {

    @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public String processMessage(@RequestParam MultiValueMap<String,String> paramMap) {
        System.out.println(" received the msg >>>>>>>>>>>>>>>>>"+paramMap);
        if (paramMap!=null){
            System.out.println(" received the msg SIZE >>>>>>>>>>>>>>>>>"+paramMap.size());
        }
        if (paramMap!=null && paramMap.get("body") !=null){
            System.out.println(" received the msg with body >>>>>>>>>>>>>>>>>"+ paramMap.get("body"));
        }else  if (paramMap!=null && paramMap.get("Body") !=null){
            System.out.println(" received the msg with body >>>>>>>>>>>>>>>>>"+ paramMap.get("Body"));
        }

        return "";
    }


}
