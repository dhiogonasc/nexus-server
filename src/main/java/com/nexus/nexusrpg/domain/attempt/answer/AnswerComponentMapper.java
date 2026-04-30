package com.nexus.nexusrpg.domain.attempt.answer;

import com.nexus.nexusrpg.common.contract.AnswerComponent;
import com.nexus.nexusrpg.common.mapper.Mapper;
import org.springframework.stereotype.Component;

@Component
public class AnswerComponentMapper implements Mapper<AnswerComponent, AnswerComponentDTO>{

    @Override
    public AnswerComponentDTO map(AnswerComponent item) {
        return new AnswerComponentDTO(
                item.getId(),
                item.getContent()
        );
    }
}
