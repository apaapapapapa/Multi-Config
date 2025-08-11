package com.example.common;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CommonTest {

    @Test
    void testGetGreeting() {
        assertEquals("Hello from common module", Common.getGreeting());
    }
}
