package com.plamen.investmindjournal.service;

import com.plamen.investmindjournal.dto.InvestmentDecisionRequest;
import com.plamen.investmindjournal.dto.SecondOpinionResponse;
import com.plamen.investmindjournal.model.InvestmentDecision;
import com.plamen.investmindjournal.repository.InvestmentDecisionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SecondOpinionService {

    private final InvestmentDecisionRepository investmentDecisionRepository;

    public SecondOpinionResponse analyze(InvestmentDecisionRequest request) {

        int score = 100;

        List<String> strengths = new ArrayList<>();
        List<String> missing = new ArrayList<>();
        List<String> questions = new ArrayList<>();

        if (request.getReason().length() > 40) {
            strengths.add("Investment reason is well described.");
        } else {
            score -= 15;
            missing.add("Provide a more detailed investment reason.");
        }

        if (request.getRiskLevel() == null || request.getRiskLevel().isBlank()) {
            score -= 20;
            missing.add("Risk level is missing.");
        } else {
            strengths.add("Risk level is specified.");
        }

        if (request.getExitPlan() == null || request.getExitPlan().isBlank()) {
            score -= 20;
            questions.add("What is your exit strategy?");
        } else {
            strengths.add("Exit strategy is defined.");
        }

        if (request.getInvestmentHorizon() == null || request.getInvestmentHorizon().isBlank()) {
            score -= 10;
            questions.add("How long do you plan to hold this investment?");
        }

        String summary;

        if (score >= 80) {
            summary = "Your investment decision is well prepared.";
        } else if (score >= 60) {
            summary = "Your decision is reasonable but could be improved.";
        } else {
            summary = "Your investment decision requires more analysis.";
        }

        InvestmentDecision decision = InvestmentDecision.builder()
                .assetName(request.getAssetName())
                .assetType(request.getAssetType())
                .amount(request.getAmount())
                .currency(request.getCurrency())
                .reason(request.getReason())
                .riskLevel(request.getRiskLevel())
                .investmentHorizon(request.getInvestmentHorizon())
                .exitPlan(request.getExitPlan())
                .decisionScore(score)
                .summary(summary)
                .build();

        InvestmentDecision savedDecision = investmentDecisionRepository.save(decision);

        return new SecondOpinionResponse(
                savedDecision.getId(),
                score,
                strengths,
                missing,
                questions,
                summary
        );
    }

    public List<InvestmentDecision> getAllDecisions() {
        return investmentDecisionRepository.findAll();
    }

    public InvestmentDecision getDecisionById(UUID id) {
        return investmentDecisionRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Investment decision not found with id: " + id
                ));
    }

    public void deleteDecisionById(UUID id) {
        if (!investmentDecisionRepository.existsById(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Investment decision not found with id: " + id
            );
        }

        investmentDecisionRepository.deleteById(id);
    }
}