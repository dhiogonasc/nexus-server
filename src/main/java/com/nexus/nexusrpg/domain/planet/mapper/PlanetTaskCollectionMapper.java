package com.nexus.nexusrpg.domain.planet.mapper;

import com.nexus.nexusrpg.common.mapper.ProgressMapper;
import com.nexus.nexusrpg.common.mapper.TaskCollectionMapper;
import com.nexus.nexusrpg.domain.planet.model.UserPlanet;
import org.springframework.stereotype.Component;

@Component
public class PlanetTaskCollectionMapper extends TaskCollectionMapper<UserPlanet> {

    public PlanetTaskCollectionMapper(
            PlanetDynamicSummaryMapper referenceMapper,
            ProgressMapper progressMapper) {
        super(referenceMapper, progressMapper);
    }
}
