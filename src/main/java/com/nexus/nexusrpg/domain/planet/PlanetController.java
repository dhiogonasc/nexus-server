package com.nexus.nexusrpg.domain.planet;

import com.nexus.nexusrpg.common.dto.TaskCollection;
import com.nexus.nexusrpg.domain.planet.service.PlanetDetailService;
import com.nexus.nexusrpg.domain.planet.service.PlanetSummaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/planets")
@RequiredArgsConstructor
public class PlanetController {

    private final PlanetSummaryService referenceService;
    private final PlanetDetailService detailService;

    @GetMapping
    public ResponseEntity<TaskCollection> getPlanets() {
        return ResponseEntity.ok(referenceService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlanetDetailDTO> getPlanet(@PathVariable Long id) {
        return ResponseEntity.ok(detailService.getById(id));
    }
}
