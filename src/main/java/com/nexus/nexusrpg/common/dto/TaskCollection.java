package com.nexus.nexusrpg.common.dto;

import java.util.List;

public record TaskCollection(
        List<EntityDynamicSummary> tasks,
        Progress progress
) {}