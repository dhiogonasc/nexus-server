package com.nexus.nexusrpg.domain.mission.mapper;

import com.nexus.nexusrpg.common.mapper.CurrentMapper;
import com.nexus.nexusrpg.common.mapper.StaticSummaryMapper;
import com.nexus.nexusrpg.domain.mission.model.UserMission;
import org.springframework.stereotype.Component;

@Component
public class CurrentMissionMapper extends CurrentMapper<UserMission> {
    public CurrentMissionMapper(StaticSummaryMapper<UserMission> referenceMapper) {
        super(referenceMapper);
    }
}
