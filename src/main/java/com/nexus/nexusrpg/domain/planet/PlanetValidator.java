package com.nexus.nexusrpg.domain.planet;

import com.nexus.nexusrpg.common.service.EntityAccessValidator;
import com.nexus.nexusrpg.domain.mission.model.UserMission;
import com.nexus.nexusrpg.domain.planet.model.UserPlanet;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PlanetValidator extends EntityAccessValidator<UserPlanet> {
    public void isAccessibleByMission(UserMission userMission) {
        isAccessible(userMission.getUPlanet());
    }
}
