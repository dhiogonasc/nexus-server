package com.nexus.nexusrpg.domain.attempt;
import jakarta.validation.constraints.NotNull;

public record AttemptAnswerRequestDTO(

        @NotNull(message = "Campo obrigatório")
        Long questionId,

        @NotNull(message = "Campo obrigatório")
        Long alternativeId
) {
}
