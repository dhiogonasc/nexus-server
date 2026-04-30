package com.nexus.nexusrpg.domain.level;

public record LevelReferenceDTO(
        Long id,
        String name,
        Long xpBonus,
        Long xpRequired
) {
}
