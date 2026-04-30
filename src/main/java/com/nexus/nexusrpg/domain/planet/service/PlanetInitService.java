package com.nexus.nexusrpg.domain.planet.service;

import com.nexus.nexusrpg.common.service.EntityInitService;
import com.nexus.nexusrpg.domain.planet.model.Planet;
import com.nexus.nexusrpg.domain.planet.model.UserPlanet;
import com.nexus.nexusrpg.domain.planet.repository.PlanetRepository;
import com.nexus.nexusrpg.domain.planet.repository.UserPlanetRepository;
import com.nexus.nexusrpg.user.User;
import org.springframework.stereotype.Service;

@Service
public class PlanetInitService extends EntityInitService<Planet, UserPlanet> {

    public PlanetInitService(
            PlanetRepository planetRepository,
            UserPlanetRepository uPlanetRepository
    ){
        super(planetRepository, uPlanetRepository);
    }

    @Override
    protected UserPlanet initRelation(User user, Planet planet) {
        return UserPlanet.initialize(user, planet);
    }
}
