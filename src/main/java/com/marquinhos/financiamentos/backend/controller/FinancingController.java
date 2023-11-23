package com.marquinhos.financiamentos.backend.controller;

import com.marquinhos.financiamentos.backend.service.FinancingService;
import com.marquinhos.financiamentos.backend.util.exceptions.FinancingException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/financing")
@CrossOrigin(origins = "*")
public class FinancingController {

  @Autowired
  private FinancingService financingService;

  @GetMapping
  public ResponseEntity<?> getFinancingValue(@RequestParam double amountFinanced,
      int numberInstallments, double downPayment) {
    try {
      return ResponseEntity.ok(financingService.calcFinancing(amountFinanced, numberInstallments,
          downPayment));
    } catch (FinancingException e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }

  }

}
