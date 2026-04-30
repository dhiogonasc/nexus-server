package com.nexus.nexusrpg.domain.attempt;

import com.nexus.nexusrpg.common.dto.EntityDynamicSummary;
import com.nexus.nexusrpg.common.mapper.Mapper;
import com.nexus.nexusrpg.domain.attempt.answer.AnswerDTO;
import com.nexus.nexusrpg.domain.attempt.answer.AnswerMapper;
import com.nexus.nexusrpg.domain.mission.mapper.MissionDynamicSummaryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AttemptMapper implements Mapper<Attempt, AttemptResponseDTO> {

    private final AnswerMapper answerMapper;
    private final MissionDynamicSummaryMapper missionMapper;

    @Override
    public AttemptResponseDTO map(Attempt attempt) {
        return new AttemptResponseDTO(
                attempt.getId(),
                attempt.getStartAt(),
                attempt.getEndAt(),
                mapResponses(attempt),
                mapMission(attempt),
                attempt.getResult()
        );
    }

    private List<AnswerDTO> mapResponses(Attempt attempt) {
        return Optional.ofNullable(attempt.getResponses())
                .orElseGet(List::of)
                .stream()
                .map(answerMapper::map)
                .toList();
    }

    private EntityDynamicSummary mapMission(Attempt attempt){
        var mission = attempt.getUserMission();
        return missionMapper.map(mission);
    }
}
