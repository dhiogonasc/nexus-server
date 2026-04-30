package com.nexus.nexusrpg.domain.planet.service;

import com.nexus.nexusrpg.common.service.EntityProgressService;
import com.nexus.nexusrpg.domain.planet.model.UserPlanet;
import com.nexus.nexusrpg.domain.planet.repository.UserPlanetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlanetProgressService extends EntityProgressService<UserPlanet> {

    private final UserPlanetRepository repository;

    @Override
    protected Optional<UserPlanet> findEntityByOrder(UserPlanet current, int order) {
        return repository
                .findByUserIdAndPlanetOrder(
                        current.getUser().getId(),
                        order
                );
    }

    @Override
    protected void onUnlock(UserPlanet currentPlanet) {
        var firstMission = currentPlanet.getFirstMission();
        firstMission.unlock();
    }
}
