package by.tms.homework.service;

import lombok.Data;

@Data
public class Message {
    private String message;

    public void clearMessage(){
        message = "";
    }
}
