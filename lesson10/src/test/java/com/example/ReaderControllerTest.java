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
        // Arrange
        List<Reader> mockReaders = Arrays.asList(new Reader(), new Reader());
        when(readerService.getAllReaders()).thenReturn(mockReaders);

        // Act
        String viewName = readerController.getReaders(model);

        // Assert
        assertEquals("readers/readers", viewName);
        verify(model).addAttribute("readersList", mockReaders);
    }

    @Test
    public void testGetReaderById() {
        // Arrange
        long readerId = 1L;
        Reader mockReader = new Reader();
        when(readerService.getReaderById(readerId)).thenReturn(mockReader);

        // Act
        String viewName = readerController.getReaderById(model, readerId);

        // Assert
        assertEquals("readers/reader", viewName);
        verify(model).addAttribute("reader", mockReader);
    }

    @Test
    public void testPostReader() {
        // Arrange
        String readerName = "Test Reader";
        Reader mockReader = new Reader();
        mockReader.setName(readerName);
        when(readerService.createReader(readerName)).thenReturn(mockReader);

        // Act
        ResponseEntity<Reader> responseEntity = readerController.postReader(readerName);

        // Assert
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(mockReader, responseEntity.getBody());
    }

    @Test
    public void testDeleteReaderById() {
        // Arrange
        long readerId = 1L;
        Reader mockReader = new Reader();
        when(readerService.deleteReaderById(readerId)).thenReturn(mockReader);

        // Act
        ResponseEntity<Reader> responseEntity = readerController.deleteReaderById(readerId);

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(mockReader, responseEntity.getBody());
    }
}
