package com.nexus.nexusrpg.domain;

import com.nexus.nexusrpg.common.EntityStatus;
import com.nexus.nexusrpg.domain.attempt.Attempt;
import com.nexus.nexusrpg.domain.level.LevelService;
import com.nexus.nexusrpg.domain.mission.model.UserMission;
import com.nexus.nexusrpg.domain.mission.service.MissionProgressService;
import com.nexus.nexusrpg.domain.planet.service.PlanetProgressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class GlobalProgressService {

    private final BigDecimal PROGRESS_THRESHOLD = BigDecimal.valueOf(70);

    private final LevelService levelService;
    private final MissionProgressService missionProgressService;
    private final PlanetProgressService planetProgressService;

    @Transactional
    public void process(Attempt attempt) {
        if (attempt.getResult().compareTo(PROGRESS_THRESHOLD) < 0){
            return;
        }

        var currentMission = attempt.getUserMission();
        missionProgressService.process(currentMission);

        check(currentMission);

        levelService.levelUp(currentMission.getUser());
    }

    private void check(UserMission currentMission){
        if (currentMission.isLast() && currentMission.getStatus() == EntityStatus.COMPLETED){
            var currentPlanet = currentMission.getUPlanet();
            planetProgressService.process(currentPlanet);
        }
    }
}