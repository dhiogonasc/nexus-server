package com.nexus.nexusrpg.domain.attempt;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.nexus.nexusrpg.common.dto.EntityDynamicSummary;
import com.nexus.nexusrpg.domain.answer.AnswerDTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public record AttemptResponseDTO(
        Long id,
        LocalDateTime startAt,
        LocalDateTime endAt,
        List<AnswerDTO> answers,
        EntityDynamicSummary mission,
        BigDecimal result
) {
}
