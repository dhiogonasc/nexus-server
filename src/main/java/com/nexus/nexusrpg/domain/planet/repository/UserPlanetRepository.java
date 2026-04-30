package com.nexus.nexusrpg.domain.planet.repository;

import com.nexus.nexusrpg.common.contract.UserEntityRepository;
import com.nexus.nexusrpg.core.exception.BusinessException;
import com.nexus.nexusrpg.domain.planet.model.UserPlanet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.NOT_FOUND;

public interface UserPlanetRepository extends JpaRepository<UserPlanet, Long>, UserEntityRepository<UserPlanet> {

    @Override
    List<UserPlanet> findByUserId(Long userId);

    @Override
    default UserPlanet findByUserIdAndEntityId(Long userId, Long entityId){
        return findUEntity(userId, entityId)
                .orElseThrow(() -> new BusinessException(
                        "Planet",
                        "Nenhum registro encontrado",
                        NOT_FOUND)
                );
    }

    @Query("SELECT up " +
            "FROM UPlanet up " +
            "JOIN FETCH up.planet " +
            "WHERE up.user.id = :userId " +
            "AND up.planet.id = :entityId")
    Optional<UserPlanet> findUEntity(@Param("userId") Long userId, @Param("entityId") Long entityId);

    @Query("SELECT up " +
            "FROM UPlanet up " +
            "JOIN FETCH up.planet " +
            "WHERE up.user.id = :userId " +
            "AND up.planet.order = :planetOrder")
    Optional<UserPlanet> findByUserIdAndPlanetOrder(@Param("userId") Long userId, @Param("planetOrder") int planetOrder);
}
