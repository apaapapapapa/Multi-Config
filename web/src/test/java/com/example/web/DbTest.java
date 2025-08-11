package com.example.web;

import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;

class DbTest {

    @Test
    void testH2InMemoryDb() throws Exception {
        Properties props = new Properties();
        try (InputStream in = getClass().getResourceAsStream("/application-test.properties")) {
            assertNotNull(in, "application-test.properties not found in classpath");
            props.load(in);
        }

        String url = props.getProperty("db.url");

        try (Connection conn = DriverManager.getConnection(url)) {
            try (Statement stmt = conn.createStatement()) {
                stmt.execute("CREATE TABLE PERSON(id INT PRIMARY KEY, name VARCHAR(255))");
                stmt.execute("INSERT INTO PERSON VALUES(1, 'Alice')");
            }
            try (PreparedStatement ps = conn.prepareStatement("SELECT name FROM PERSON WHERE id = ?")) {
                ps.setInt(1, 1);
                try (ResultSet rs = ps.executeQuery()) {
                    assertTrue(rs.next(), "ResultSet should have at least one row");
                    assertEquals("Alice", rs.getString("name"), "Name should match inserted value");
                }
            }
        }
    }
}
