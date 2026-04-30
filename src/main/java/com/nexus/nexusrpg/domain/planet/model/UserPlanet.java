package com.nexus.nexusrpg.domain.planet.model;

import com.nexus.nexusrpg.common.EntityStatus;
import com.nexus.nexusrpg.common.contract.Orientable;
import com.nexus.nexusrpg.common.contract.Rewardable;
import com.nexus.nexusrpg.common.contract.Usable;
import com.nexus.nexusrpg.domain.mission.model.UserMission;
import com.nexus.nexusrpg.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import static com.nexus.nexusrpg.common.EntityStatus.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "\"user_planet\"", uniqueConstraints = {
        @UniqueConstraint(name = "uk_user_planet", columnNames = {"user_id", "planet_id"})
})
public class UserPlanet implements Usable, Orientable, Rewardable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "planet_id", nullable = false)
    private Planet planet;

    @Embedded @Builder.Default
    private UserPlanetExecution execution = new UserPlanetExecution();


    public static UserPlanet initialize(User user, Planet planet) {

        boolean isFirst = planet.isFirst();

        var initialStats = UserPlanetExecution.builder()
                .status(isFirst ? UNLOCKED : LOCKED)
                .current(isFirst)
                .build();

        return UserPlanet.builder()
                .user(user)
                .planet(planet)
                .execution(initialStats)
                .build();
    }


    @Override
    public EntityStatus getStatus() {
        return this.execution.getStatus();
    }

    @Override
    public boolean isCurrent() {
        return this.execution.isCurrent();
    }

    @Override
    public void unlock() {
        if(getStatus() == LOCKED) {
            this.execution.setStatus(UNLOCKED);
            this.execution.setCurrent(true);
        }
    }

    @Override
    public void complete() {
        this.execution.setStatus(COMPLETED);
        this.execution.setCurrent(isLast());
    }

    @Override
    public int getOrder() {
        return this.planet.getOrder();
    }

    @Override
    public boolean isFirst() {
        return this.planet.isFirst();
    }

    @Override
    public boolean isLast() {
        return this.planet.isLast();
    }


    @Override
    public long getXpBonus() {
        return this.planet.getXpBonus();
    }


    public List<UserMission> getUMissions() {
        return this.user.getMissions().stream()
                .filter(uMission -> uMission.getPlanet().equals(this.planet))
                .toList();
    }

    public UserMission getFirstMission() {
        return getUMissions().stream()
                .filter(UserMission::isFirst)
                .findFirst()
                .orElse(null);
    }
}
