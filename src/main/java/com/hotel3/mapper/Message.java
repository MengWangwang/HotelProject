package com.hotel3.mapper;

import lombok.Data;

@Data
public class Message {

    public Message(String ErrorMsg,String MsgType){
        this.ErrorMsg=ErrorMsg;
        this.MsgType=MsgType;
    }
    private String ErrorMsg;

    private String MsgType;
}
