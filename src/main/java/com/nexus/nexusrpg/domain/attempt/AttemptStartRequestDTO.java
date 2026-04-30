package com.nexus.nexusrpg.domain.attempt;

import jakarta.validation.constraints.NotNull;

public record AttemptStartRequestDTO(

        @NotNull(message = "Campo obrigatório")
        Long missionId
) {
}
