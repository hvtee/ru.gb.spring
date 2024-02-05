package com.example.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.model.Issue;
import com.example.model.Reader;
import com.example.service.ReaderService;

import java.util.List;
import java.util.NoSuchElementException;

@Controller
@RequestMapping("/reader")
@Slf4j
public class ReaderController {
    @Autowired
    private ReaderService readerService;


    @GetMapping("/{id}")
    public ResponseEntity<Reader> getById(@PathVariable long id) {
        Reader reader = null;
        try {
            reader = readerService.getReaderById(id);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(reader);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Reader> delById(@PathVariable long id) {
        Reader reader = null;
        try {
            reader = readerService.delReaderById(id);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(reader);
    }

    @PostMapping()
    public ResponseEntity<Reader> createReader(@RequestParam String name) {
        Reader reader = readerService.createReader(name);
        log.info("Reader created");
        return ResponseEntity.status(HttpStatus.OK).body(reader);
    }

    @GetMapping("/{id}/issue")
    public ResponseEntity<List<Issue>> getAllIssues(@PathVariable long id) {
        return ResponseEntity.status(HttpStatus.OK).body(readerService.getIssuesForReaderId(id));
    }
}
