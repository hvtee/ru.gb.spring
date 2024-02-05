package com.example.repository;

import com.example.model.Issue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public interface IssueRepository extends JpaRepository<Issue, Long> {
//    private final List<Issue> issues;
//
//    public IssueRepository() {
//        this.issues = new ArrayList<>();
//    }
//
//    public void save(Issue issue) {
//        issues.add(issue);
//    }
//
//    public Issue getIssue(long id) {
//        return issues.stream().filter(is -> Objects.equals(is.getId(), id)).findFirst().orElse(null);
//    }
//
//    public List<Issue> getIssues() {
//        return new ArrayList<>(issues);
//    }
}
