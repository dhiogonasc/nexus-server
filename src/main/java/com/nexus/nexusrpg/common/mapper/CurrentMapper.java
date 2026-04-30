package com.nexus.nexusrpg.common.mapper;

import com.nexus.nexusrpg.common.contract.Executable;
import com.nexus.nexusrpg.common.dto.EntityStaticSummary;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public abstract class CurrentMapper<T extends Executable> implements Mapper<List<T>, EntityStaticSummary>{

    private final StaticSummaryMapper<T> referenceMapper;

    @Override
    public EntityStaticSummary map(List<T> uEntities) {
        return uEntities.stream()
                .filter(T::isCurrent)
                .findFirst()
                .map(referenceMapper::map)
                .orElse(null);
    }
}
