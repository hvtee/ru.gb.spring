package com.example.demo;

import lombok.SneakyThrows;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.Duration;

@Slf4j
@Component
public class DatabaseConnector {

    private final ApplicationEventPublisher eventPublisher;
    private final DataSource dataSource;

    @Autowired
    public DatabaseConnector(ApplicationEventPublisher eventPublisher, DataSource dataSource) {
        this.eventPublisher = eventPublisher;
        this.dataSource = dataSource;
    }

    public String getData() {
        // connect to db and select
        return "data";
    }

    // init-method
//    @SneakyThrows
//    @EventListener(ApplicationReadyEvent.class)
//    public void init() {
//        try {
//            Connection connection = dataSource.getConnection();
//
//
//            log.info("Database connection successful");
//
//            // Publish the custom event
//            eventPublisher.publishEvent(new DatabaseConnectionSetupEvent(this));
//
//            // Close the connection when done
//            connection.close();
//        } catch (SQLException e) {
//            log.error("Error connecting to the database", e);
//        }
//    }
}
