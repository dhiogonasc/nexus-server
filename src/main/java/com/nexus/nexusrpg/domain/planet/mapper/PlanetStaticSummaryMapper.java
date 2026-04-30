package com.nexus.nexusrpg.domain.planet.mapper;

import com.nexus.nexusrpg.common.dto.EntityStaticSummary;
import com.nexus.nexusrpg.common.mapper.StaticSummaryMapper;
import com.nexus.nexusrpg.domain.planet.model.UserPlanet;
import org.springframework.stereotype.Component;

@Component
public class PlanetStaticSummaryMapper extends StaticSummaryMapper<UserPlanet> {

    @Override
    public EntityStaticSummary map(UserPlanet userPlanet) {
        var planet = userPlanet.getPlanet();
        return new EntityStaticSummary(
                planet.getId(),
                planet.getName().name(),
                planet.getDescription()
        );
    }
}
