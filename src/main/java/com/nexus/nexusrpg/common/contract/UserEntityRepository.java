package com.nexus.nexusrpg.common.contract;

import java.util.List;

public interface UserEntityRepository<UserEntity> {
    List<UserEntity> findByUserId(Long userId);
    UserEntity findByUserIdAndEntityId(Long userId, Long entityId);
}