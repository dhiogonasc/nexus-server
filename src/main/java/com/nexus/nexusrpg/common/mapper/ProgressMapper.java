package com.nexus.nexusrpg.common.mapper;

import com.nexus.nexusrpg.common.dto.EntityDynamicSummary;
import com.nexus.nexusrpg.common.dto.Progress;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.nexus.nexusrpg.common.EntityStatus.COMPLETED;

@Component
public class ProgressMapper implements Mapper<List<EntityDynamicSummary>, Progress>{

    @Override
    public Progress map(List<EntityDynamicSummary> tasks) {
        var completedTasks = tasks.stream()
                .filter(task -> COMPLETED.equals(task.status()))
                .count();

        return new Progress(completedTasks, tasks.size());
    }
}