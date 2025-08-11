package com.example.service;

import com.example.common.Common;
import com.example.domain.Domain;

/**
 * Service module aggregating common and domain.
 */
public class ServiceApp {
    public static String getServiceMessage() {
        return Common.getGreeting() + " & " + Domain.getDomainInfo();
    }
}
