package com.nexus.nexusrpg.domain.mission.service;

import com.nexus.nexusrpg.common.service.EntityProgressService;
import com.nexus.nexusrpg.domain.mission.model.UserMission;
import com.nexus.nexusrpg.domain.mission.repository.UserMissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MissionProgressService extends EntityProgressService<UserMission> {

    private final UserMissionRepository repository;

    @Override
    protected Optional<UserMission> findEntityByOrder(UserMission current, int order){
        return repository
                .findByUserIdAndPlanetIdAndMissionOrder(
                        current.getUser().getId(),
                        current.getPlanet().getId(),
                        order
                );
    }
}
