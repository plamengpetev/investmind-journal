package com.plamen.investmindjournal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
public class SecondOpinionResponse {

    private UUID decisionId;

    private int decisionScore;

    private List<String> strengths;

    private List<String> missingConsiderations;

    private List<String> questions;

    private String summary;
}