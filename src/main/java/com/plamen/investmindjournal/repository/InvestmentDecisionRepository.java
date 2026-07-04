package com.plamen.investmindjournal.repository;

import com.plamen.investmindjournal.model.InvestmentDecision;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface InvestmentDecisionRepository extends JpaRepository<InvestmentDecision, UUID> {
}