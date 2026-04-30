package com.nexus.nexusrpg.domain.attempt.answer;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record AnswerDTO(
        int order,
        AnswerComponentDTO question,
        AnswerComponentDTO selection,
        AnswerComponentDTO correct,
        boolean hit,
        String explanation
) {}
