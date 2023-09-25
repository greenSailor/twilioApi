package com.example.twilioApi;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.lang.NonNull;

public class SmsRequest {
    @NonNull
    private final String mobileNumber;
    @NonNull
    private final String message;

    public SmsRequest(@JsonProperty("phoneNumber") String mobileNumber,
                      @JsonProperty("message") String message) {
        this.mobileNumber = mobileNumber;
        this.message = message;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "SmsRequest{" +
                "mobileNumber='" + mobileNumber + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
