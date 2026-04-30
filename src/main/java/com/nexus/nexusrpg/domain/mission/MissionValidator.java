package com.nexus.nexusrpg.domain.mission;

import com.nexus.nexusrpg.common.service.EntityAccessValidator;
import com.nexus.nexusrpg.domain.mission.model.UserMission;
import com.nexus.nexusrpg.domain.planet.PlanetValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MissionValidator extends EntityAccessValidator<UserMission> {

    private final PlanetValidator planetValidator;

    @Override
    public void isAccessible(UserMission userMission) {
        planetValidator.isAccessibleByMission(userMission);
        super.isAccessible(userMission);
    }
}
