package com.nexus.nexusrpg.user;

import com.nexus.nexusrpg.common.Context;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/me")
@RequiredArgsConstructor
public class UserController {

    private final Context context;

    @GetMapping
    public ResponseEntity<UserDTO> getMe() {
        return ResponseEntity.ok(context.getProfile());
    }
}
