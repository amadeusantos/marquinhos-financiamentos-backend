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

  public Financing calcFinancing(double amountFinanced, int numberInstallments,
      double downPayment) {
    if (!checkNumber(amountFinanced) || !checkNumber(numberInstallments)) {
      throw new FinancingException("Numbers must be more than 0");
    } else if (checkDownPayment(downPayment, amountFinanced)) {
      throw new FinancingException("Check the financing down payment");
    }

    double amountAfterDownPayment = amountFinanced - downPayment;
    double installmentsValue = amountAfterDownPayment * MONTHLY_INTEREST / (1 - Math.pow(1
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

  public boolean checkDownPayment(double downPayment, double amountFinanced) {
    boolean isNegative = downPayment < 0;
    boolean isMoreThanAmountFinanced = downPayment >= amountFinanced;
    return (isNegative || isMoreThanAmountFinanced);
  }
}
