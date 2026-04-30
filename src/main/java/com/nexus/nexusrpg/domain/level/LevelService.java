package com.nexus.nexusrpg.domain.level;

import com.nexus.nexusrpg.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LevelService {

    private final LevelRepository repository;

    public Level findInitialLevel(){
        return repository.findByIdOrThrow(1L);
    }

    public Level findNextLevel(Level currentLevel) {
        return repository
                .findByOrder(currentLevel.getNextOrder())
                .orElse(null);
    }

    public void levelUp(User user){
        while (!user.getLevel().isLast()) {
            Level nextLevel = findNextLevel(user.getLevel());
            if (user.getXp() >= nextLevel.getXpRequired()) {
                user.up(nextLevel);
            } else {
                break;
            }
        }
    }
}
