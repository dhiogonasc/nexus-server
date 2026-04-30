package com.nexus.nexusrpg.common.mapper;

import com.nexus.nexusrpg.common.contract.Executable;
import com.nexus.nexusrpg.common.dto.EntityDynamicSummary;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class DynamicSummaryMapper<T extends Executable> implements Mapper<T, EntityDynamicSummary> {
    protected final ExecutionMapper<T> executionMapper;
}
