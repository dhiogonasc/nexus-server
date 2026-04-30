package com.nexus.nexusrpg.domain.attempt;

import com.nexus.nexusrpg.core.exception.BusinessException;
import com.nexus.nexusrpg.domain.mission.model.Mission;
import com.nexus.nexusrpg.domain.mission.model.UserMission;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@Component
@RequiredArgsConstructor
public class AttemptValidator {

    private final AttemptRepository repository;

    public void hasActiveAttempts(UserMission userMission) {

        var hasActiveAttempt = repository.existsByUMissionIdAndEndAtIsNull(userMission.getId());

        if(hasActiveAttempt){
            throw new BusinessException(
                    "Attempt",
                    "Você já possui tentativas em curso para essa missão",
                    CONFLICT
            );
        }
    }

    public void isCurrent(Attempt attempt) {

        if(attempt.getEndAt() != null){
            throw new BusinessException(
                    "Attempt",
                    "Tentativa finalizada!",
                    BAD_REQUEST
            );
        }
    }

    public void validateUniqueQuestions(List<AttemptAnswerRequestDTO> request) {

        var uniqueQuestions = request.stream()
                .map(AttemptAnswerRequestDTO::questionId)
                .distinct()
                .count();

        if (uniqueQuestions != request.size()) {
            throw new BusinessException(
                    "Question",
                    "Existem questões duplicadas na requisição.",
                    UNPROCESSABLE_ENTITY
            );
        }
    }

    public void validateAnswers(List<AttemptAnswerRequestDTO> request, Mission mission) {

        int total = mission.getQuestions().size();
        int answered = request.size();

        if (answered < total) {
            throw new BusinessException(
                    "Mission",
                    "Missão incompleta. Existem questões pendentes na tentativa atual.",
                    UNPROCESSABLE_ENTITY
            );
        }
    }
}
