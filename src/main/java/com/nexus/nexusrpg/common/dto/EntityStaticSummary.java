package com.nexus.nexusrpg.common.dto;

public record EntityStaticSummary(
        Long id,
        String name,
        String description
) implements StaticSummary {}
