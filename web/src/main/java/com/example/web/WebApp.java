package com.example.web;

import com.example.service.ServiceApp;

/**
 * Web module entry point.
 */
public class WebApp {
    public static void main(String[] args) {
        System.out.println(ServiceApp.getServiceMessage());
    }
}
