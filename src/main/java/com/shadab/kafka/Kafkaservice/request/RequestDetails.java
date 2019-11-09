package com.shadab.kafka.Kafkaservice.request;



public class RequestDetails {

    private String status_count ;
    private String status_message;

    public String getStatus_count() {
        return status_count;
    }

    public void setStatus_count(String status_count) {
        this.status_count = status_count;
    }

    public String getStatus_message() {
        return status_message;
    }

    public void setStatus_message(String status_message) {
        this.status_message = status_message;
    }
}
