package com.nexus.nexusrpg.domain.answer;

import com.nexus.nexusrpg.common.mapper.Mapper;
import com.nexus.nexusrpg.domain.alterntative.AlternativeRepository;
import com.nexus.nexusrpg.domain.attempt.Attempt;
import com.nexus.nexusrpg.domain.question.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AnswerMapper implements Mapper<Answer, AnswerDTO> {

    private final AnswerComponentMapper componentMapper;
    private final AnswerValidator validator;

    private final QuestionRepository questionRepository;
    private final AlternativeRepository alternativeRepository;

    @Override
    public AnswerDTO map(Answer answer) {
        boolean hit = answer.isHit();
        return new AnswerDTO(
                answer.getQuestion().getOrder(),
                componentMapper.map(answer.getQuestion()),
                componentMapper.map(answer.getAlternative()),
                hit ? null : componentMapper.map(answer.getCorrect()),
                hit,
                answer.getExplanation()
        );
    }

    public Answer create(
            Attempt attempt,
            Long questionId,
            Long alternativeId) {

        var question = questionRepository.getReferenceById(questionId);
        var alternative = alternativeRepository.getReferenceById(alternativeId);

        validator.validateResponseConsistency(attempt, question, alternative);

        return Answer.builder()
                .attempt(attempt)
                .question(question)
                .alternative(alternative)
                .build();
    }
}
