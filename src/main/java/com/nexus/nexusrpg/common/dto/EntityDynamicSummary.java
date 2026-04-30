package com.nexus.nexusrpg.common.dto;

import com.nexus.nexusrpg.common.EntityStatus;

public record EntityDynamicSummary(
        Long id,
        String name,
        String description,
        int order,
        Execution execution
) implements DynamicSummary, Task {
    @Override
    public EntityStatus status() {
        return this.execution.status();
    }
}
