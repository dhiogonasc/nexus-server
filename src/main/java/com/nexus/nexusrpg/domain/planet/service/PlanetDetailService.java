package com.nexus.nexusrpg.domain.planet.service;

import com.nexus.nexusrpg.common.Context;
import com.nexus.nexusrpg.common.service.EntityDetailService;
import com.nexus.nexusrpg.domain.planet.PlanetDetailDTO;
import com.nexus.nexusrpg.domain.planet.PlanetValidator;
import com.nexus.nexusrpg.domain.planet.mapper.PlanetMapper;
import com.nexus.nexusrpg.domain.planet.model.UserPlanet;
import com.nexus.nexusrpg.domain.planet.repository.UserPlanetRepository;
import org.springframework.stereotype.Service;

@Service
public class PlanetDetailService extends EntityDetailService<UserPlanet, PlanetDetailDTO> {
    public PlanetDetailService(
            Context context,
            UserPlanetRepository repository,
            PlanetMapper mapper,
            PlanetValidator validator
    ) {
        super(context, repository, mapper, validator);
    }
}
