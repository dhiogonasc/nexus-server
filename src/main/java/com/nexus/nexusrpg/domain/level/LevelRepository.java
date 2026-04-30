package com.nexus.nexusrpg.domain.level;

import com.nexus.nexusrpg.core.exception.BusinessException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

import static org.springframework.http.HttpStatus.NOT_FOUND;

public interface LevelRepository extends JpaRepository<Level, Long> {

    Optional<Level> findByOrder(int order);

    default Level findByIdOrThrow(long id){
        return findById(id)
                .orElseThrow(() -> new BusinessException(
                        "Level",
                        "Level 1 não encontrado",
                        NOT_FOUND
                ));
    }
}
