package com.nexus.nexusrpg.domain.mission.service;

import com.nexus.nexusrpg.common.service.EntityInitService;
import com.nexus.nexusrpg.domain.mission.model.Mission;
import com.nexus.nexusrpg.domain.mission.model.UserMission;
import com.nexus.nexusrpg.domain.mission.repository.MissionRepository;
import com.nexus.nexusrpg.domain.mission.repository.UserMissionRepository;
import com.nexus.nexusrpg.user.User;
import org.springframework.stereotype.Service;

@Service
public class MissionInitService extends EntityInitService<Mission, UserMission> {
    public MissionInitService(
            MissionRepository missionRepository,
            UserMissionRepository userMissionRepository
    ) {
        super(missionRepository, userMissionRepository);
    }

    @Override
    protected UserMission initRelation(User user, Mission mission) {
        return UserMission.initialize(user, mission);
    }
}
