package com.nexus.nexusrpg.common.service;

import com.nexus.nexusrpg.common.Context;
import com.nexus.nexusrpg.common.contract.Executable;
import com.nexus.nexusrpg.common.contract.UserEntityRepository;
import com.nexus.nexusrpg.common.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
public abstract class EntityDetailService<E extends Executable, DTO> {

    protected final Context context;
    protected final UserEntityRepository<E> repository;
    protected final Mapper<E, DTO> mapper;
    protected final EntityAccessValidator<E> validator;

    @Transactional(readOnly = true)
    public DTO getById(Long id) {
        E e = repository.findByUserIdAndEntityId(context.getAuthenticatedUser().getId(), id);
        validator.isAccessible(e);
        return mapper.map(e);
    }
}