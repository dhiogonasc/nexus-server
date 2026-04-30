package com.nexus.nexusrpg.core.auth;

import com.nexus.nexusrpg.user.UserBuildService;
import com.nexus.nexusrpg.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@RequiredArgsConstructor
@Service
public class AuthService {

    private final UserBuildService buildService;
    private final UserRepository repository;

    private final AuthValidator validator;

    private final PasswordEncoder passwordEncoder;
    private final JwtEncoder jwtEncoder;

    @Transactional
    public void register(RegisterRequestDTO request) {

        buildService.createUser(
                request.username(),
                request.email(),
                passwordEncoder.encode(request.password())
        );
    }

    public LoginResponseDTO login(LoginRequestDTO request) {

        var user = repository.findByEmailOrThrow(request.email());

        validator.validatePassword(request.password(), user.getPassword());

        var expiresIn = 3600L;
        var loggedInAt = Instant.now();

        var claims = JwtClaimsSet.builder()
                .issuer("nexus")
                .subject(user.getEmail())
                .issuedAt(loggedInAt)
                .expiresAt(loggedInAt.plusSeconds(expiresIn))
                .build();

        String accessToken = jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();

        return new LoginResponseDTO(
                accessToken,
                expiresIn,
                loggedInAt
        );
    }
}
