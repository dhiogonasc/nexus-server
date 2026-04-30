package com.nexus.nexusrpg.domain.planet;

import com.nexus.nexusrpg.common.dto.EntityDetail;
import com.nexus.nexusrpg.common.dto.TaskCollection;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class PlanetDetailDTO extends EntityDetail {
    private final String content;
    private final long xpBonus;
    private final TaskCollection missions;
}