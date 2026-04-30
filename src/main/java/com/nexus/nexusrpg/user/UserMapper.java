package com.nexus.nexusrpg.user;

import com.nexus.nexusrpg.common.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMapper implements Mapper<User, UserDTO> {

    private final UserProgressionMapper progressMapper;

    @Override
    public UserDTO map(User user){
        return new UserDTO(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getXp(),
                user.getOxygen(),
                progressMapper.map(user)
        );
    }
}
