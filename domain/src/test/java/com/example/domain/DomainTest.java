package com.example.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DomainTest {

    @Test
    void testGetDomainInfo() {
        assertEquals("Hello from domain module", Domain.getDomainInfo());
    }
}
