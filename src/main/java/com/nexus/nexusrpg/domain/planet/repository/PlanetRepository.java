package com.nexus.nexusrpg.domain.planet.repository;

import com.nexus.nexusrpg.domain.planet.model.Planet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanetRepository extends JpaRepository<Planet, Long> {
}
