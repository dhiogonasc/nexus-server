package com.nexus.nexusrpg.domain.mission.model;

import com.nexus.nexusrpg.common.EntityStatus;
import com.nexus.nexusrpg.common.contract.Orientable;
import com.nexus.nexusrpg.common.contract.Rewardable;
import com.nexus.nexusrpg.common.contract.Usable;
import com.nexus.nexusrpg.domain.attempt.Attempt;
import com.nexus.nexusrpg.domain.planet.model.Planet;
import com.nexus.nexusrpg.domain.planet.model.UserPlanet;
import com.nexus.nexusrpg.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

import static com.nexus.nexusrpg.common.EntityStatus.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "\"user_mission\"", uniqueConstraints = {
        @UniqueConstraint(name = "uk_user_mission", columnNames = {"user_id", "mission_id"})
})
public class UserMission implements Usable, Orientable, Rewardable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id", nullable = false)
    private Mission mission;

    @Embedded
    @Builder.Default
    private UserMissionExecution execution = new UserMissionExecution();

    @OneToMany(mappedBy = "userMission")
    private List<Attempt> attempts;


    public static UserMission initialize(User user, Mission mission) {

        boolean isFirst = mission.isFirst() & mission.getPlanet().isFirst();

        var initialStats = UserMissionExecution.builder()
                .status(isFirst ? UNLOCKED : LOCKED)
                .current(isFirst)
                .build();

        return UserMission.builder()
                .user(user)
                .mission(mission)
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
        this.execution.setCurrent(false);
    }


    @Override
    public int getOrder() {
        return this.mission.getOrder();
    }

    @Override
    public boolean isFirst(){
        return this.mission.isFirst();
    }

    @Override
    public boolean isLast() {
        return this.mission.isLast();
    }


    @Override
    public long getXpBonus() {
        return this.mission.getXpBonus();
    }


    public BigDecimal getBestResult() {
        return this.execution.getBestResult();
    }

    public Planet getPlanet() {
        return this.mission.getPlanet();
    }

    public UserPlanet getUPlanet() {
        var targetPlanet = this.getPlanet();

        return this.user.getPlanets().stream()
                .filter(up -> up.getPlanet().equals(targetPlanet))
                .findFirst()
                .orElse(null);
    }
}
