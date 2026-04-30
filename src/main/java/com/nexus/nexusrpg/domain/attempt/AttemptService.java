package com.nexus.nexusrpg.domain.attempt;

import com.nexus.nexusrpg.common.Context;
import com.nexus.nexusrpg.domain.GlobalProgressService;
import com.nexus.nexusrpg.domain.answer.Answer;
import com.nexus.nexusrpg.domain.answer.AnswerMapper;
import com.nexus.nexusrpg.domain.mission.MissionValidator;
import com.nexus.nexusrpg.domain.mission.model.UserMission;
import com.nexus.nexusrpg.domain.mission.repository.UserMissionRepository;
import com.nexus.nexusrpg.user.User;
import com.nexus.nexusrpg.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AttemptService {

    private final Context context;
    private final UserRepository userRepository;

    private final UserMissionRepository userMissionRepository;
    private final MissionValidator missionValidator;

    private final AttemptRepository attemptRepository;
    private final AttemptValidator attemptValidator;
    private final AttemptMapper attemptMapper;

    private final AnswerMapper answerMapper;

    private final GlobalProgressService progressService;

    @Transactional
    public AttemptResponseDTO start(AttemptStartRequestDTO request) {
        var user = userRepository.getReferenceById(context.getAuthenticatedUser().getId());

        var uMission = getMission(user, request);
        var attempt = Attempt.builder()
                .userMission(uMission)
                .build();

        return attemptMapper.map(attemptRepository.save(attempt));
    }

    private UserMission getMission(User user, AttemptStartRequestDTO request) {

        var mission = userMissionRepository
                .findByUserIdAndEntityId(
                        user.getId(),
                        request.missionId()
                );

        missionValidator.isAccessible(mission);
        attemptValidator.hasActiveAttempts(mission);

        return mission;
    }

    @Transactional
    public AttemptResponseDTO finish(Long id, List<AttemptAnswerRequestDTO> request) {
        var attempt = attemptRepository.findByIdOrThrow(id);
        attemptValidator.isCurrent(attempt);

        var mission = attempt.getUserMission().getMission();

        attemptValidator.validateAnswers(request, mission);
        attemptValidator.validateUniqueQuestions(request);

        var responses = createResponses(attempt, request);

        attempt.finish(responses);
        progressService.process(attempt);

        return attemptMapper.map(attemptRepository.save(attempt));
    }

    private List<Answer> createResponses(Attempt attempt, List<AttemptAnswerRequestDTO> request) {
        return request.stream()
                .map(r -> answerMapper.create(attempt, r.questionId(), r.alternativeId()))
                .toList();
    }
}
