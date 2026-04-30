package com.nexus.nexusrpg.domain.planet.mapper;

import com.nexus.nexusrpg.common.dto.TaskCollection;
import com.nexus.nexusrpg.common.mapper.ExecutionMapper;
import com.nexus.nexusrpg.common.mapper.Mapper;
import com.nexus.nexusrpg.domain.mission.mapper.MissionTaskCollectionMapper;
import com.nexus.nexusrpg.domain.planet.PlanetDetailDTO;
import com.nexus.nexusrpg.domain.planet.model.UserPlanet;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PlanetMapper implements Mapper<UserPlanet, PlanetDetailDTO> {

    private final ExecutionMapper<UserPlanet> executionMapper;
    private final MissionTaskCollectionMapper missionMapper;

    @Override
    public PlanetDetailDTO map(UserPlanet userPlanet){

        var planet = userPlanet.getPlanet();

        return PlanetDetailDTO.builder()
                .id(planet.getId())
                .name(planet.getName().toString())
                .description(planet.getDescription())
                .order(planet.getOrder())
                .execution(executionMapper.map(userPlanet))
                .xpBonus(planet.getXpBonus())
                .content(planet.getContent())
                .missions(mapMissions(userPlanet))
                .build();
    }

    private TaskCollection mapMissions(UserPlanet userPlanet){
        var missions = userPlanet.getUMissions();
        return missionMapper.map(missions);
    }
}
