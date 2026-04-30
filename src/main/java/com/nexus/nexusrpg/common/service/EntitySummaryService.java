package com.nexus.nexusrpg.common.service;

import com.nexus.nexusrpg.common.Context;
import com.nexus.nexusrpg.common.contract.Executable;
import com.nexus.nexusrpg.common.contract.UserEntityRepository;
import com.nexus.nexusrpg.common.dto.TaskCollection;
import com.nexus.nexusrpg.common.mapper.TaskCollectionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
public abstract class EntitySummaryService<E extends Executable> {

    protected final Context context;
    protected final UserEntityRepository<E> userEntityRepository;
    protected final TaskCollectionMapper<E> taskCollectionMapper;

    @Transactional(readOnly = true)
    public TaskCollection getAll() {
        var user = context.getAuthenticatedUser();
        return taskCollectionMapper.map(userEntityRepository.findByUserId(user.getId()));
    }
}