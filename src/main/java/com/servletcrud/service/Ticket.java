package com.servletcrud.service;

import java.util.Date;


public class Ticket {
    int tickNum, status, id;
    String from, to, fromTime, toTime;

    public void setId(int arg) {
        id = arg;
    }

    public void setTickNum(int arg) {
        tickNum = arg;
    }

    public void setStatus(int arg) {
        status = arg;
    }

    public void setFrom(String arg) {
        from = arg;
    }

    public void setTo(String arg) {
        to = arg;
    }

    public void setFromTime(String arg) {
        fromTime = arg;
    }

    public void setToTime(String arg) {
        toTime = arg;
    }
    
    public int getId() {
        return id;
    }

    public int getTickNum() {
        return tickNum;
    }

    public int getStatus() {
        return status;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getFromTime() {
        return fromTime;
    }

    public String getToTime() {
        return toTime;
    }
}

