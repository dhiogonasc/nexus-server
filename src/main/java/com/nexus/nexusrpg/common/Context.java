package com.nexus.nexusrpg.common;

import com.nexus.nexusrpg.user.User;
import com.nexus.nexusrpg.user.UserDTO;
import com.nexus.nexusrpg.user.UserMapper;
import com.nexus.nexusrpg.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Context {

    private final UserRepository repository;
    private final UserMapper mapper;

    public User getAuthenticatedUser() {
        String authenticatedEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        return repository.findByEmailOrThrow(authenticatedEmail);
    }

    public UserDTO getProfile() {
        return mapper.map(getAuthenticatedUser());
    }
}
