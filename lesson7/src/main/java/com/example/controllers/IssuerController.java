package com.example.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.models.Issue;
import com.example.services.IssuerService;

import java.util.NoSuchElementException;

@Slf4j
@RestController
@RequestMapping("/issue")
@Tag(name = "Issue controller")
public class IssuerController {
    @Autowired
    private IssuerService service;

    @PostMapping
    @Operation(summary = "Issue a book", description = "Issue a book to a reader")
    public ResponseEntity<Issue> issueBook(
            @RequestBody(description = "Request for issuing a book") IssueRequest request) {
        log.info("Request received to issue: readerId = {}, bookId = {}", request.getReaderId(), request.getBookId());

        final Issue issue;
        try {
            issue = service.issue(request);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(issue);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get an issue by Id", description = "Retrieve an issue by its unique identifier")
    public ResponseEntity<Issue> getIssue(
            @PathVariable long id) {
        final Issue issue;
        try {
            issue = service.getIssueById(id);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(issue);
    }
}
