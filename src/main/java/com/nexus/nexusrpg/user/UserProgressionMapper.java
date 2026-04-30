package com.nexus.nexusrpg.user;

import com.nexus.nexusrpg.common.mapper.Mapper;
import com.nexus.nexusrpg.domain.level.CurrentLevelMapper;
import com.nexus.nexusrpg.domain.mission.mapper.CurrentMissionMapper;
import com.nexus.nexusrpg.domain.planet.mapper.CurrentPlanetMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserProgressionMapper implements Mapper<User, UserProgressionDTO>  {

    private final CurrentLevelMapper currentLevelMapper;
    private final CurrentPlanetMapper currentPlanetMapper;
    private final CurrentMissionMapper currentMissionMapper;

    @Override
    public UserProgressionDTO map(User user) {

        var currentPlanet = currentPlanetMapper.map(user.getPlanets());
        var currentMission = currentMissionMapper.map(user.getMissions());

        return new UserProgressionDTO(
                currentLevelMapper.map(user.getLevel()),
                currentPlanet,
                currentMission
        );
    }
}
