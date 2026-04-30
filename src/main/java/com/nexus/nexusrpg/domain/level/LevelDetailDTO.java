package com.nexus.nexusrpg.domain.level;

public record LevelDetailDTO(
        Long id,
        String name,
        String description,
        LevelReferenceDTO next
) {
}
