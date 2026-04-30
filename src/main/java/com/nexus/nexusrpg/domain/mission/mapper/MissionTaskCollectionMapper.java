package com.nexus.nexusrpg.domain.mission.mapper;

import com.nexus.nexusrpg.common.mapper.ProgressMapper;
import com.nexus.nexusrpg.common.mapper.TaskCollectionMapper;
import com.nexus.nexusrpg.domain.mission.model.UserMission;
import org.springframework.stereotype.Component;

@Component
public class MissionTaskCollectionMapper extends TaskCollectionMapper<UserMission> {

    public MissionTaskCollectionMapper(
            MissionDynamicSummaryMapper referenceMapper,
            ProgressMapper progressMapper) {
        super(referenceMapper, progressMapper);
    }
}
