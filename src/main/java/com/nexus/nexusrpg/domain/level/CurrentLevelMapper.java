package com.nexus.nexusrpg.domain.level;

import com.nexus.nexusrpg.common.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CurrentLevelMapper implements Mapper<Level, LevelDetailDTO> {

    private final LevelService service;

    @Override
    public LevelDetailDTO map(Level level) {
        return new LevelDetailDTO(
                level.getId(),
                level.getName().name(),
                level.getDescription(),
                mapNext(level)
        );
    }

    private LevelReferenceDTO mapNext(Level level) {
        var next = service.findNextLevel(level);
        if (next == null) {return null;}

        return new LevelReferenceDTO(
                next.getId(),
                next.getName().name(),
                next.getXpBonus(),
                next.getXpRequired()
        );
    }
}
