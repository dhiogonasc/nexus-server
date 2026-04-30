package com.nexus.nexusrpg.common.dto;

import com.nexus.nexusrpg.common.EntityStatus;

public record Execution(
        EntityStatus status,
        boolean isCurrent
) {
}
