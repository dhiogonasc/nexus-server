package com.nexus.nexusrpg.domain.attempt;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attempts")
@RequiredArgsConstructor
public class AttemptController {

    private final AttemptService service;

    @PostMapping
    public ResponseEntity<AttemptResponseDTO> start(@Valid @RequestBody AttemptStartRequestDTO request){
        return ResponseEntity.ok(service.start(request));
    }

    @PostMapping("/{id}/finish")
    public ResponseEntity<AttemptResponseDTO> finish(
            @PathVariable Long id,
            @Valid @RequestBody List<AttemptAnswerRequestDTO> request){
        return ResponseEntity.ok(service.finish(id, request));
    }
}