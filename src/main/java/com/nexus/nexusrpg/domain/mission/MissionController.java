package com.nexus.nexusrpg.domain.mission;

import com.nexus.nexusrpg.domain.mission.service.MissionDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/missions")
@RequiredArgsConstructor
public class MissionController {

    private final MissionDetailService detailService;

    @GetMapping("/{id}")
    public ResponseEntity<MissionDetailDTO> getMission(@PathVariable Long id) {
        return ResponseEntity.ok(detailService.getById(id));
    }
}