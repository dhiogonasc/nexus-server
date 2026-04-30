package com.nexus.nexusrpg.common.service;

import com.nexus.nexusrpg.common.contract.Executable;
import com.nexus.nexusrpg.core.exception.BusinessException;

import static com.nexus.nexusrpg.common.EntityStatus.LOCKED;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;

public abstract class EntityAccessValidator<T extends Executable> {

    public void isAccessible(T entity) {
        if(entity.getStatus() == LOCKED){
            throw new BusinessException(
                    "Entity Access",
                    "Bloqueado! Complete o anterior!",
                    UNAUTHORIZED);
        }
    }
}
