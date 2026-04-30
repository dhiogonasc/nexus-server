package com.nexus.nexusrpg.domain.planet.mapper;

import com.nexus.nexusrpg.common.dto.EntityDynamicSummary;
import com.nexus.nexusrpg.common.mapper.DynamicSummaryMapper;
import com.nexus.nexusrpg.common.mapper.ExecutionMapper;
import com.nexus.nexusrpg.domain.planet.model.UserPlanet;
import org.springframework.stereotype.Component;

@Component
public class PlanetDynamicSummaryMapper extends DynamicSummaryMapper<UserPlanet> {

    public PlanetDynamicSummaryMapper(ExecutionMapper<UserPlanet> executionMapper) {
        super(executionMapper);
    }

    public EntityDynamicSummary map(UserPlanet userPlanet){
        var planet = userPlanet.getPlanet();
        return new EntityDynamicSummary(
                planet.getId(),
                planet.getName().toString(),
                planet.getDescription(),
                planet.getOrder(),
                executionMapper.map(userPlanet)
        );
    }
}
