package com.programcreek.helloworld.controller;

import java.util.ArrayList;
import java.util.List;

import com.programcreek.helloworld.bean.UserDetails;

public class Response {
    private ArrayList<UserDetails> response;
    
    public Response(ArrayList<UserDetails> message) {
        this.response = message;
    }

    public ArrayList<UserDetails> getResponse() {
        return response;
    }

    public void setResponse(ArrayList<UserDetails> response) {
        this.response = response;
    }
}
