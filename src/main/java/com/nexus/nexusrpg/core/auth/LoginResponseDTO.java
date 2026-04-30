package com.nexus.nexusrpg.core.auth;

import java.time.Instant;

public record LoginResponseDTO (

        String accessToken,
        Long expiresIn,
        Instant loggedInAt
) {
}
