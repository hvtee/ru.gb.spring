package com.example.repository;

import com.example.model.Issue;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class IssueRepository {
    private final List<Issue> issues;

    public IssueRepository() {
        this.issues = new ArrayList<>();
    }

    public void save(Issue issue) {
        issues.add(issue);
    }

    public Issue getIssue(long id) {
        return issues.stream().filter(is -> Objects.equals(is.getId(), id)).findFirst().orElse(null);
    }

    public List<Issue> getIssues() {
        return new ArrayList<>(issues);
    }
}
