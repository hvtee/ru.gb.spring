package com.example.controllers;

import lombok.Data;

@Data
public class IssueRequest {
  /**
   * Идентификатор читателя
   */
  private long readerId;

  /**
   * Идентификатор книги
   */
  private long bookId;

}
