package com.example;

import com.example.controllers.ReaderController;
import com.example.models.Reader;
import com.example.services.ReaderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ReaderControllerTest {

    @Mock
    private ReaderService readerService;

    @Mock
    private Model model;

    @InjectMocks
    private ReaderController readerController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetReaders() {
        List<Reader> mockReaders = Arrays.asList(new Reader(), new Reader());
        when(readerService.getAllReaders()).thenReturn(mockReaders);

        String viewName = readerController.getReaders(model);

        assertEquals("readers/readers", viewName);
        verify(model).addAttribute("readersList", mockReaders);
    }

    @Test
    public void testGetReaderById() {
        long readerId = 1L;
        Reader mockReader = new Reader();
        when(readerService.getReaderById(readerId)).thenReturn(mockReader);

        String viewName = readerController.getReaderById(model, readerId);

        assertEquals("readers/reader", viewName);
        verify(model).addAttribute("reader", mockReader);
    }

    @Test
    public void testPostReader() {
        String readerName = "Test Reader";
        Reader mockReader = new Reader();
        mockReader.setName(readerName);
        when(readerService.createReader(readerName)).thenReturn(mockReader);

        ResponseEntity<Reader> responseEntity = readerController.postReader(readerName);

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(mockReader, responseEntity.getBody());
    }

    @Test
    public void testDeleteReaderById() {
        long readerId = 1L;
        Reader mockReader = new Reader();
        when(readerService.deleteReaderById(readerId)).thenReturn(mockReader);

        ResponseEntity<Reader> responseEntity = readerController.deleteReaderById(readerId);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(mockReader, responseEntity.getBody());
    }
}
