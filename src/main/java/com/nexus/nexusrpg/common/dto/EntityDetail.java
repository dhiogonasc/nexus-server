package com.nexus.nexusrpg.common.dto;

import com.nexus.nexusrpg.common.EntityStatus;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@RequiredArgsConstructor
public abstract class EntityDetail implements DynamicSummary, Task {

    private final Long id;
    private final String name;
    private final String description;
    private final int order;
    private final Execution execution;

    @Override
    public Execution execution() {
        return this.execution;
    }

    @Override
    public Long id() {
        return this.id;
    }

    @Override
    public String name() {
        return this.name;
    }

    @Override
    public String description() {
        return this.description;
    }

    @Override
    public EntityStatus status() {
        return this.execution.status();
    }
}
