package com.nexus.nexusrpg.domain.mission.mapper;

import com.nexus.nexusrpg.common.dto.EntityDynamicSummary;
import com.nexus.nexusrpg.common.mapper.ExecutionMapper;
import com.nexus.nexusrpg.common.mapper.Mapper;
import com.nexus.nexusrpg.domain.mission.MissionDetailDTO;
import com.nexus.nexusrpg.domain.mission.model.UserMission;
import com.nexus.nexusrpg.domain.planet.mapper.PlanetDynamicSummaryMapper;
import com.nexus.nexusrpg.domain.question.QuestionDTO;
import com.nexus.nexusrpg.domain.question.QuestionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MissionMapper implements Mapper<UserMission, MissionDetailDTO>{

    private final ExecutionMapper<UserMission> executionMapper;
    private final PlanetDynamicSummaryMapper planetMapper;
    private final QuestionMapper questionMapper;

    public MissionDetailDTO map(UserMission userMission){
        var mission = userMission.getMission();

        return MissionDetailDTO.builder()
                .id(mission.getId())
                .name(mission.getName())
                .description(mission.getDescription())
                .content(mission.getContent())
                .order(mission.getOrder())
                .questions(mapQuestions(userMission))
                .xpBonus(mission.getXpBonus())
                .bestResult(userMission.getBestResult())
                .execution(executionMapper.map(userMission))
                .planet(mapPlanet(userMission))
                .build();
    }

    private EntityDynamicSummary mapPlanet(UserMission userMission){
        var planet = userMission.getUPlanet();
        return planetMapper.map(planet);
    }

    private List<QuestionDTO> mapQuestions(UserMission userMission){
        var questions = userMission.getMission().getQuestions();
        return questions.stream()
                .map(questionMapper::map)
                .toList();
    }
}
