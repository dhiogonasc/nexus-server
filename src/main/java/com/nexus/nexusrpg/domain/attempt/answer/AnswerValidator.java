package com.nexus.nexusrpg.domain.attempt.answer;

import com.nexus.nexusrpg.core.exception.BusinessException;
import com.nexus.nexusrpg.domain.attempt.Attempt;
import com.nexus.nexusrpg.domain.attempt.alterntative.Alternative;
import com.nexus.nexusrpg.domain.attempt.question.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;

@Component
@RequiredArgsConstructor
public class AnswerValidator {

    public void validateResponseConsistency(
            Attempt attempt,
            Question question,
            Alternative alternative
    ) {
        validateQuestion(attempt, question);
        validateAlternative(question, alternative);
    }

    private void validateQuestion(Attempt attempt, Question question){

        var attemptMissionId = attempt.getUserMission().getMission().getId();
        var questionMissionId = question.getMission().getId();

        if (!questionMissionId.equals(attemptMissionId)) {
            throw new BusinessException(
                    "Question",
                    "A questão não pertence a esta missão.",
                    UNPROCESSABLE_ENTITY
            );
        }
    }

    private void validateAlternative(Question question, Alternative alternative){

        var questionId = question.getId();
        var alternativeQuestionId = alternative.getQuestion().getId();

        if (!alternativeQuestionId.equals(questionId)) {
            throw new BusinessException(
                    "Alternative",
                    "A alternativa não pertence a esta questão.",
                    UNPROCESSABLE_ENTITY
            );
        }
    }
}
