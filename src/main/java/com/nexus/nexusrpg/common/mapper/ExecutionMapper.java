package com.nexus.nexusrpg.common.mapper;

import com.nexus.nexusrpg.common.contract.Executable;
import com.nexus.nexusrpg.common.dto.Execution;
import org.springframework.stereotype.Component;

@Component
public class ExecutionMapper<T extends Executable> implements Mapper<T, Execution> {

    @Override
    public Execution map(T entity){
        return new Execution(
                entity.getStatus(),
                entity.isCurrent()
        );
    }
}
