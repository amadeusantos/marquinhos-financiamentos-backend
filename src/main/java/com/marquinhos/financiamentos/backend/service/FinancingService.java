package com.marquinhos.financiamentos.backend.service;

import com.marquinhos.financiamentos.backend.model.Financing;
import com.marquinhos.financiamentos.backend.util.exceptions.FinancingException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FinancingService {
  private static final double MONTHLY_INTEREST =
      0.015; //1,5%

  public Financing calcFinancing(double amountFinanced, int numberInstallments) {
    if (!checkNumber(amountFinanced) || !checkNumber(numberInstallments)) {
      throw new FinancingException("Numbers must be more than 0");
    }

    double installmentsValue = amountFinanced * MONTHLY_INTEREST / (1 - Math.pow(1
        / (1 + MONTHLY_INTEREST), numberInstallments));
    double finalAmount = installmentsValue * numberInstallments;

    Financing financingValues = new Financing();
    financingValues.setFinalAmount(finalAmount);
    financingValues.setInstallmentsValue(installmentsValue);

    return financingValues;
  }

  public boolean checkNumber(double number) {
    return !(number < 1);
  }
}
