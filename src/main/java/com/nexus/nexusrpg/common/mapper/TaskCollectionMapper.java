package com.nexus.nexusrpg.common.mapper;

import com.nexus.nexusrpg.common.contract.Executable;
import com.nexus.nexusrpg.common.dto.TaskCollection;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public abstract class TaskCollectionMapper<UserEntity extends Executable> {

    private final DynamicSummaryMapper<UserEntity> summaryMapper;
    private final ProgressMapper progressMapper;

    public TaskCollection map(List<UserEntity> entities) {
        var tasks = entities.stream()
                .map(summaryMapper::map)
                .toList();

        var progress = progressMapper.map(tasks);

        return new TaskCollection(tasks, progress);
    }
}
