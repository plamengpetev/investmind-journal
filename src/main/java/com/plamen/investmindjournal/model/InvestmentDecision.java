package com.plamen.investmindjournal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvestmentDecision {

    private UUID id;

    private String assetName;

    private String assetType;

    private double amount;

    private String currency;

    private String reason;

    private String riskLevel;

    private String investmentHorizon;

    private String exitPlan;

    private LocalDateTime createdAt;
}