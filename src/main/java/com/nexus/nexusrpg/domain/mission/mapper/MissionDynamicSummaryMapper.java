package com.nexus.nexusrpg.domain.mission.mapper;

import com.nexus.nexusrpg.common.dto.EntityDynamicSummary;
import com.nexus.nexusrpg.common.mapper.DynamicSummaryMapper;
import com.nexus.nexusrpg.common.mapper.ExecutionMapper;
import com.nexus.nexusrpg.domain.mission.model.UserMission;
import org.springframework.stereotype.Component;

@Component
public class MissionDynamicSummaryMapper extends DynamicSummaryMapper<UserMission> {

    public MissionDynamicSummaryMapper(ExecutionMapper<UserMission> executionMapper) {
        super(executionMapper);
    }

    public EntityDynamicSummary map(UserMission userMission){
        var mission = userMission.getMission();
        return new EntityDynamicSummary(
                mission.getId(),
                mission.getName(),
                mission.getDescription(),
                mission.getOrder(),
                executionMapper.map(userMission)
        );
    }
}
