package com.example.services;

import com.example.models.Issue;
import com.example.models.Reader;
import com.example.repositories.IssueRepository;
import com.example.repositories.ReaderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

@Service
public class ReaderService {
    private final ReaderRepository readerRepository;
    private final IssueRepository issueRepository;

    public ReaderService(ReaderRepository readerRepository, IssueRepository issueRepository) {
        this.readerRepository = readerRepository;
        this.issueRepository = issueRepository;
    }

    public List<Reader> getAllReaders() {
        try {
            return readerRepository.findAll();
        } catch (NoSuchElementException exception) {
            throw new NoSuchElementException("No readers found");
        }
    }

    public Reader getReaderById(long id) {
        Reader reader = readerRepository.findById(id).get();
        if (reader != null) {
            return reader;
        } else {
            throw new NoSuchElementException("не найден читатель с id: " + id);
        }
    }

    public Reader deleteReaderById(long id) {
        Reader reader = readerRepository.findById(id).get();
        if (reader != null) {
            return reader;
        } else {
            throw new NoSuchElementException("не найден читатель с id: " + id);
        }
    }

    public Reader createReader(String name) {
        return readerRepository.save(new Reader(name));
    }

    public List<Issue> getIssuesForReaderId(long id) {
        List<Issue> issues = issueRepository.findAll();
        return issues.stream().filter(issue -> Objects.equals(issue.getReaderId(), id)).toList();
    }
}
