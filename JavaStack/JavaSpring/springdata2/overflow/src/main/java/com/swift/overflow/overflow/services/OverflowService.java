package com.swift.overflow.overflow.services;

import com.swift.overflow.overflow.models.Answer;
import com.swift.overflow.overflow.models.Question;
import com.swift.overflow.overflow.models.Tag;
import com.swift.overflow.overflow.repositories.AnswerRepository;
import com.swift.overflow.overflow.repositories.QuestionRepository;
import com.swift.overflow.overflow.repositories.TagRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OverflowService {
    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;
    private final TagRepository tagRepository;

    public OverflowService(QuestionRepository questionRepository, AnswerRepository answerRepository, TagRepository tagRepository) {
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
        this.tagRepository = tagRepository;
    }

    public List<Answer> allAnswer() {
        return answerRepository.findAll();
    }

    public Answer findAnswer(Long id) {
        Optional<Answer> optionalAnswer = answerRepository.findById(id);
        if (optionalAnswer.isPresent()) {
            return optionalAnswer.get();
        } else {
            return null;
        }
    }

    public Answer createAnswer(Answer answer) {
        return answerRepository.save(answer);
    }
    public void createQuestionAnswer(Long id,Answer answer){
        Question question = questionRepository.findById(id).orElse(null);
        Answer ans=new Answer(answer.getAnswer(),question);
        answerRepository.save(ans);

    }

    public List<Question> allQuestion() {
        return questionRepository.findAll();
    }

    public Question findQuestion(Long id) {
        Optional<Question> optionalQuestion = questionRepository.findById(id);
        if (optionalQuestion.isPresent()) {
            return optionalQuestion.get();
        } else {
            return null;
        }
    }

    public Question createQuestion(Question question) {
        List<Tag> tags=new ArrayList<Tag>();

        return questionRepository.save(question);
    }
    public Question addQuestion(Question question,Tag tag) {
        questionRepository.save(question);
        String[] newTags=tag.getSubject().split(",");
        ArrayList<Tag> questionTags=new ArrayList<Tag>();
        for(String sub:newTags){
            if(sub.length()!=0){
                Tag findTag=tagRepository.findBySubject(sub);
                if(findTag==null){
                    findTag=new Tag(sub);
                    tagRepository.save(findTag);
                }
                questionTags.add(findTag);
            }
        }
        question.setTags(questionTags);
        return questionRepository.save(question);
    }

    public List<Tag> allTag() {
        return tagRepository.findAll();
    }

    public Tag findTag(Long id) {
        Optional<Tag> optionalTag = tagRepository.findById(id);
        if (optionalTag.isPresent()) {
            return optionalTag.get();
        } else {
            return null;
        }
    }
    public Tag createTag(Tag tag) {
        return tagRepository.save(tag);
    }
}
