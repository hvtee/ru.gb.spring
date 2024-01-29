package com.example.service;

import com.example.api.IssueRequest;
import com.example.model.Issue;
import com.example.repository.BookRepository;
import com.example.repository.IssueRepository;
import com.example.repository.ReaderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class IssuerService {
    private final BookRepository bookRepository;
    private final ReaderRepository readerRepository;
    private final IssueRepository issueRepository;

    public Issue issue(IssueRequest request) {
        if (bookRepository.getBookById(request.getBookId()) == null) {
            throw new NoSuchElementException("Не найдена книга с идентификатором \"" + request.getBookId() + "\"");
        }
        if (readerRepository.getReaderById(request.getReaderId()) == null) {
            throw new NoSuchElementException("Не найден читатель с идентификатором \"" + request.getReaderId() + "\"");
        }
        // можно проверить, что у читателя нет книг на руках (или его лимит не превышает в Х книг)
        List<Issue> issueList = issueRepository.getIssues();
        long countBooksOnHand = issueList.stream().filter(issue -> Objects.equals(issue.getReaderId(), request.getReaderId())).count();
        if (countBooksOnHand > 2) {
            throw new IllegalArgumentException("превышен лимит выдачи книг");
        }
        Issue issue = new Issue(request.getBookId(), request.getReaderId());
        issueRepository.save(issue);
        return issue;
    }

    public Issue getIssueById(long id) {
        Issue issue = issueRepository.getIssue(id);
        if (issue != null) {
            return issue;
        } else {
            throw new NoSuchElementException("не найдена выдача книги с id: " + id);
        }
    }

    public List<Issue> getAllIssues() {
        return issueRepository.getIssues();
    }
}
