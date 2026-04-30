package com.nexus.nexusrpg.domain.mission.mapper;

import com.nexus.nexusrpg.common.dto.EntityStaticSummary;
import com.nexus.nexusrpg.common.mapper.StaticSummaryMapper;
import com.nexus.nexusrpg.domain.mission.model.UserMission;
import org.springframework.stereotype.Component;

@Component
public class MissionStaticSummaryMapper extends StaticSummaryMapper<UserMission> {

    @Override
    public EntityStaticSummary map(UserMission userMission) {
        var mission = userMission.getMission();
        return new EntityStaticSummary(
                mission.getId(),
                mission.getName(),
                mission.getDescription()
        );
    }
}
