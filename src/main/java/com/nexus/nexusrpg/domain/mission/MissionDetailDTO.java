package com.nexus.nexusrpg.domain.mission;

import com.nexus.nexusrpg.common.dto.EntityDetail;
import com.nexus.nexusrpg.common.dto.EntityDynamicSummary;
import com.nexus.nexusrpg.domain.question.QuestionDTO;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.List;

@Getter
@SuperBuilder
public class MissionDetailDTO extends EntityDetail {
    private final String content;
    private final List<QuestionDTO> questions;
    private final long xpBonus;
    private final BigDecimal bestResult;
    private final EntityDynamicSummary planet;
}