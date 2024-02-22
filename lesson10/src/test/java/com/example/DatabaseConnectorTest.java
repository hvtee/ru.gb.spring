package com.example;

import com.example.demo.DatabaseConnector;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class DatabaseConnectorTest {

    @Autowired
    private DatabaseConnector databaseConnector;

    @Autowired
    private DataSource dataSource;

    @Test
    public void testGetData() {
        String data = databaseConnector.getData();
        assertNotNull(data);
    }

    @Test
    public void testDatabaseConnection() throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            assertTrue(connection.isValid(1));
        }
    }
}
