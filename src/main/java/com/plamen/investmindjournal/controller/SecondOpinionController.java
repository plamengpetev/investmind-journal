package com.plamen.investmindjournal.controller;

import com.plamen.investmindjournal.dto.InvestmentDecisionRequest;
import com.plamen.investmindjournal.dto.SecondOpinionResponse;
import com.plamen.investmindjournal.model.InvestmentDecision;
import com.plamen.investmindjournal.service.SecondOpinionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/opinion")
@RequiredArgsConstructor
public class SecondOpinionController {

    private final SecondOpinionService secondOpinionService;

    @PostMapping
    public SecondOpinionResponse analyze(
            @Valid @RequestBody InvestmentDecisionRequest request) {

        return secondOpinionService.analyze(request);
    }

    @GetMapping
    public List<InvestmentDecision> getAllDecisions() {
        return secondOpinionService.getAllDecisions();
    }

    @GetMapping("/{id}")
    public InvestmentDecision getDecisionById(@PathVariable UUID id) {
        return secondOpinionService.getDecisionById(id);
    }
}