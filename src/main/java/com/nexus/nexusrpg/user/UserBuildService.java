package com.nexus.nexusrpg.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserBuildService {

    private final UserInitService initService;
    private final UserRepository repository;

    @Transactional
    public void createUser(
            String username,
            String email,
            String password
    ){
        var level = initService.initialLevel();

        var user = User.builder()
                .username(username)
                .email(email)
                .password(password)
                .level(level)
                .build();

        repository.save(user);
        initService.initialize(user);
    }
}
