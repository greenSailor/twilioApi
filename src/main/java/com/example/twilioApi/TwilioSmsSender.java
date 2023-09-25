package com.example.twilioApi;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("twilio")
public class TwilioSmsSender implements SmsSender{

    private static final Logger LOGGER = LoggerFactory.getLogger(TwilioSmsSender.class);

    private final TwilioConfiguration twilioConfiguration;

    @Autowired
    public TwilioSmsSender(TwilioConfiguration twilioConfiguration) {
        this.twilioConfiguration = twilioConfiguration;
    }

    @Override
    public void sendSms(SmsRequest smsRequest) {
        if (isPhoneNumberValid(smsRequest.getMobileNumber())){
            PhoneNumber to = new PhoneNumber(smsRequest.getMobileNumber());
            PhoneNumber from = new PhoneNumber(twilioConfiguration.getTrailNumber());
            String message = smsRequest.getMessage();
            MessageCreator messageCreater = Message.creator(to,from, message);
            messageCreater.create();
            LOGGER.info("Sms Sent successfully {}"+ smsRequest.getMobileNumber());
        }else {
            throw new IllegalArgumentException("Phone number [" +smsRequest.getMobileNumber() +"]");
        }
    }

    private boolean isPhoneNumberValid(String mobileNumber) {
        return true;
    }
}
