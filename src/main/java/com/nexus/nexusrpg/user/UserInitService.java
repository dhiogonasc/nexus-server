package com.nexus.nexusrpg.user;

import com.nexus.nexusrpg.common.contract.Initializable;
import com.nexus.nexusrpg.domain.level.Level;
import com.nexus.nexusrpg.domain.level.LevelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserInitService {

    private final LevelService levelService;
    private final List<Initializable> initializers;

    public void initialize(User user) {
        initializers.forEach(initializer -> initializer.initialize(user));
    }

    public Level initialLevel() {
        return levelService.findInitialLevel();
    }
}
