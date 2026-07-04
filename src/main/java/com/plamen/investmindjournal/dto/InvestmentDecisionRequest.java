package com.plamen.investmindjournal.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class InvestmentDecisionRequest {

    @NotBlank
    private String assetName;

    @NotBlank
    private String assetType;

    @Min(1)
    private double amount;

    @NotBlank
    private String currency;

    @NotBlank
    private String reason;

    private String riskLevel;

    private String investmentHorizon;

    private String exitPlan;
}