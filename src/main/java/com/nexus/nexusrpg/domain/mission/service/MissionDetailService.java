package com.nexus.nexusrpg.domain.mission.service;

import com.nexus.nexusrpg.common.Context;
import com.nexus.nexusrpg.common.service.EntityDetailService;
import com.nexus.nexusrpg.domain.mission.MissionDetailDTO;
import com.nexus.nexusrpg.domain.mission.MissionValidator;
import com.nexus.nexusrpg.domain.mission.mapper.MissionMapper;
import com.nexus.nexusrpg.domain.mission.model.UserMission;
import com.nexus.nexusrpg.domain.mission.repository.UserMissionRepository;
import org.springframework.stereotype.Service;

@Service
public class MissionDetailService extends EntityDetailService<UserMission, MissionDetailDTO> {
    public MissionDetailService(
            Context context,
            UserMissionRepository repository,
            MissionMapper mapper,
            MissionValidator validator
    ) {
        super(context, repository, mapper, validator);
    }
}
