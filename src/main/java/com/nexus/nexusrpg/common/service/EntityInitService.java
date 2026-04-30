package com.nexus.nexusrpg.common.service;

import com.nexus.nexusrpg.common.contract.Initializable;
import com.nexus.nexusrpg.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

@RequiredArgsConstructor
public abstract class EntityInitService<E, R> implements Initializable {

    private final JpaRepository<E, Long> baseRepository;
    private final JpaRepository<R, Long> relationRepository;

    @Override
    public void initialize(User user) {

        var baseEntities = baseRepository.findAll();

        var relations = baseEntities.stream()
                .map(base -> initRelation(user, base))
                .toList();

        relationRepository.saveAll(relations);
    }

    protected abstract R initRelation(User user, E baseE);
}