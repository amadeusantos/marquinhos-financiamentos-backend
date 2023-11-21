package com.marquinhos.financiamentos.backend.service;

import com.marquinhos.financiamentos.backend.model.Financing;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class FinancingService {
  private static final double MONTHLY_INTEREST =
      0.015; //1,5%
  public Financing calcFinancing(double amountFinanced, int numberInstallments ) {
    double installmentsValue = amountFinanced * MONTHLY_INTEREST / (1 - Math.pow(1 / (1 + MONTHLY_INTEREST), numberInstallments));
    double finalAmount = installmentsValue * numberInstallments;

    Financing values = new Financing();
    values.setFinalAmount(finalAmount);
    values.setInstallmentsValue(installmentsValue);

    return values;
  }
}
