package com.nexus.nexusrpg.domain.planet.mapper;

import com.nexus.nexusrpg.common.mapper.CurrentMapper;
import com.nexus.nexusrpg.common.mapper.StaticSummaryMapper;
import com.nexus.nexusrpg.domain.planet.model.UserPlanet;
import org.springframework.stereotype.Component;

@Component
public class CurrentPlanetMapper extends CurrentMapper<UserPlanet> {
    public CurrentPlanetMapper(StaticSummaryMapper<UserPlanet> referenceMapper) {
        super(referenceMapper);
    }
}
