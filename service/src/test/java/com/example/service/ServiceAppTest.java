package com.example.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ServiceAppTest {

    @Test
    void testGetServiceMessage() {
        String expected = "Hello from common module & Hello from domain module";
        assertEquals(expected, ServiceApp.getServiceMessage());
    }
}
