package com.example.service;

import com.example.model.Issue;
import com.example.model.Reader;
import com.example.repository.IssueRepository;
import com.example.repository.ReaderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

@Service
public class ReaderService {
    private final ReaderRepository readerRepository;
    private final IssueRepository issueRepository;

    public ReaderService(ReaderRepository readerRepository, IssueRepository issueRepository) {
        this.readerRepository = readerRepository;
        this.issueRepository = issueRepository;
    }

    public Reader getReaderById(long id) {
        Reader reader = readerRepository.getReaderById(id);
        if (reader != null) {
            return reader;
        } else {
            throw new NoSuchElementException("не найден читатель с id: " + id);
        }
    }

    public Reader delReaderById(long id) {
        Reader reader = readerRepository.delreaderById(id);
        if (reader != null) {
            return reader;
        } else {
            throw new NoSuchElementException("не найден читатель с id: " + id);
        }
    }

    public Reader createReader(String name) {
        return readerRepository.createReader(name);
    }

    public List<Issue> getIssuesForReaderId(long id) {
        List<Issue> issues = issueRepository.getIssues();
        return issues.stream().filter(issue -> Objects.equals(issue.getReaderId(), id)).toList();
    }

    public List<Reader> getAllReader() {
        return readerRepository.getAllReader();
    }
}
