package com.nexus.nexusrpg.domain.planet.service;

import com.nexus.nexusrpg.common.Context;
import com.nexus.nexusrpg.common.service.EntitySummaryService;
import com.nexus.nexusrpg.domain.planet.mapper.PlanetTaskCollectionMapper;
import com.nexus.nexusrpg.domain.planet.model.UserPlanet;
import com.nexus.nexusrpg.domain.planet.repository.UserPlanetRepository;
import org.springframework.stereotype.Component;

@Component
public class PlanetSummaryService extends EntitySummaryService<UserPlanet> {

    public PlanetSummaryService(
            Context context,
            UserPlanetRepository repository,
            PlanetTaskCollectionMapper mapper
    ) {
        super(context, repository, mapper);
    }
}