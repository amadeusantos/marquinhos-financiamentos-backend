package com.marquinhos.financiamentos.backend.util.exceptions;

public class FinancingException extends RuntimeException{
  public FinancingException(String message) {
    super("Error: " + message);
  }
}
