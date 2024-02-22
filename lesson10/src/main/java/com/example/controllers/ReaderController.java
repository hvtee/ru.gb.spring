package com.example.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.models.Issue;
import com.example.models.Reader;
import com.example.services.ReaderService;

import java.util.List;
import java.util.NoSuchElementException;

@Controller
@RequestMapping("/readers")
@Slf4j
@Tag(name = "Reader controller")
public class ReaderController {
    @Autowired
    private ReaderService readerService;

    @GetMapping("")
    @Operation(summary = "Get all readers", description = "Get all readers from repository")
    public String getReaders(Model model) {
        log.info("Attempt to get all readers");

        List<Reader> readers;
        try {
            readers = readerService.getAllReaders();

        } catch (NoSuchElementException e) {
            log.info("page /error returned");
            return "/error";
        }
        model.addAttribute("readersList", readers);
        log.info("page /readers returned");
        return "readers/readers";
    }


    @GetMapping("/{id}")
    @Operation(summary = "Get reader by Id", description = "Retrieve a reader by their unique identifier")
    public String getReaderById(
            @Parameter(description = "To transfer data") Model model,
            @Parameter(description = "ID of the reader to retrieve") @PathVariable long id) {
        log.info("Attempt to get reader by id");

        Reader reader = null;
        try {
            reader = readerService.getReaderById(id);
        } catch (NoSuchElementException e) {
            log.info("page /error returned");
            return "/error";
        }
        model.addAttribute("reader", reader);
        log.info("page /readers/{id} returned");
        return "readers/reader";
    }

    @PostMapping()
    @Operation(summary = "Create reader using name", description = "Create a new reader with the provided name")
    public ResponseEntity<Reader> postReader(
            @Parameter(description = "Name of the reader") @RequestParam String name) {
        log.info("Attempt to create reader");

        Reader reader = readerService.createReader(name);
        log.info("Reader created");
        return ResponseEntity.status(HttpStatus.CREATED).body(reader);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete reader by Id", description = "Delete a reader by their unique identifier")
    public ResponseEntity<Reader> deleteReaderById(
            @Parameter(description = "ID of the reader to delete") @PathVariable long id) {
        log.info("Attempt to delete book");

        Reader reader;
        try {
            reader = readerService.deleteReaderById(id);
        } catch (NoSuchElementException e) {
            log.info("page /error returned");
            return ResponseEntity.notFound().build();
        }
        log.info("Reader deleted");
        return ResponseEntity.status(HttpStatus.OK).body(reader);
    }


    @GetMapping("/{id}/issues")
    @Operation(summary = "Get all issues for reader", description = "Retrieve all issues associated with a reader")
    public ResponseEntity<List<Issue>> getAllIssues(
            @Parameter(description = "ID of the reader") @PathVariable long id) {
        return ResponseEntity.status(HttpStatus.OK).body(readerService.getIssuesForReaderId(id));
    }
}
