package com.nexus.nexusrpg.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.nexus.nexusrpg.common.dto.EntityStaticSummary;
import com.nexus.nexusrpg.domain.level.LevelDetailDTO;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record UserProgressionDTO(
        LevelDetailDTO level,
        EntityStaticSummary planet,
        EntityStaticSummary mission
) {
}
