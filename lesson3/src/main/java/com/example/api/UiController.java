package com.example.api;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.model.Book;
import com.example.model.Issue;
import com.example.model.Reader;
import com.example.service.BookService;
import com.example.service.IssuerService;
import com.example.service.ReaderService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UiController {

    private BookService bookService;
    private ReaderService readerService;
    private IssuerService issuerService;

    public UiController(BookService bookService, ReaderService readerService, IssuerService issuerService) {
        this.bookService = bookService;
        this.readerService = readerService;
        this.issuerService = issuerService;
    }

    @GetMapping("ui/books")
    public String books(Model model) {
        List<Book> bookList = bookService.getAllBooks();
        model.addAttribute("bookList", bookList);
        return "books";
    }

    @GetMapping("ui/reader")
    public String readers(Model model) {
        List<Reader> readerList = readerService.getAllReader();
        model.addAttribute("readerList", readerList);
        return "readers";
    }

    @GetMapping("ui/issues")
    public String issues(Model model) {
        List<Issue> issueList = issuerService.getAllIssues();
        List<IssueItem> issueItems = new ArrayList<>();
        for (Issue issue : issueList) {
            issueItems.add(new IssueItem(bookService.getBookById(issue.getBookId()), readerService.getReaderById(issue.getReaderId()), issuerService.getIssueById(issue.getId()).getTimestamp()));
        }
        model.addAttribute("issueItems", issueItems);
        return "issues";
    }

    @GetMapping("ui/reader/{id}")
    public String readerIssues(@PathVariable long id, Model model) {
        List<Issue> issueList = readerService.getIssuesForReaderId(id);
        Reader reader = readerService.getReaderById(id);
        List<IssueItem> issueItems = new ArrayList<>();
        for (Issue issue : issueList) {
            issueItems.add(new IssueItem(bookService.getBookById(issue.getBookId()), readerService.getReaderById(issue.getReaderId()), issuerService.getIssueById(issue.getId()).getTimestamp()));
        }
        model.addAttribute("issueItems", issueItems);
        model.addAttribute("reader", reader);
        return "readerIssues";
    }

}
