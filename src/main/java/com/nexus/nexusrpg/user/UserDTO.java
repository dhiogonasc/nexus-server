package com.nexus.nexusrpg.user;

public record UserDTO(
        Long id,
        String username,
        String email,
        long xp,
        int oxygen,
        UserProgressionDTO progression
) {
}
