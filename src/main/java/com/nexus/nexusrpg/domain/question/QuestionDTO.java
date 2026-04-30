package com.nexus.nexusrpg.domain.question;

import com.nexus.nexusrpg.domain.answer.AnswerComponentDTO;

import java.util.List;

public record QuestionDTO(
        Long id,
        String content,
        int order,
        List<AnswerComponentDTO> alternatives
) {
}
