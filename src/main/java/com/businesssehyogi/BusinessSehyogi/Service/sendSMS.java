package com.businesssehyogi.BusinessSehyogi.Service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class sendSMS {

    @Value("${twilio.account.sid}")
    private String sid;

    @Value("${twilio.auth.token}")
    private String authToken;

    @Value("${twilio.phone.number}")
    private String fromPhoneNumber;

    @PostConstruct
    public void init() {
        Twilio.init(sid, authToken);
    }

    public void sendSms(String toPhoneNumber, String msg) {
        Message.creator(new PhoneNumber(toPhoneNumber), new PhoneNumber(fromPhoneNumber), msg).create();
    }

}
