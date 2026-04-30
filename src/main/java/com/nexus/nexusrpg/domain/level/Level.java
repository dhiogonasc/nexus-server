package com.nexus.nexusrpg.domain.level;

import com.nexus.nexusrpg.common.contract.Orientable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "\"level\"")
public class Level implements Orientable {

    private static final int LEVEL_COUNT = LevelLabel.values().length;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "\"name\"", nullable = false, unique = true, columnDefinition = "level_label")
    private LevelLabel name;

    @Column(name = "\"description\"")
    private String description;

    @Column(name = "\"order\"", nullable = false)
    private int order;

    @Column(name = "\"xp_bonus\"", nullable = false, columnDefinition = "xp")
    private long xpBonus;

    @Column(name = "\"xp_required\"", nullable = false, columnDefinition = "xp")
    private long xpRequired;

    @Override
    public boolean isLast() {
        return this.getOrder() == LEVEL_COUNT;
    }
}
