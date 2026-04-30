package com.nexus.nexusrpg.domain.attempt.question;

import com.nexus.nexusrpg.domain.attempt.answer.AnswerComponentDTO;

import java.util.List;

public record QuestionDTO(
        Long id,
        String content,
        int order,
        List<AnswerComponentDTO> alternatives
) {
}
