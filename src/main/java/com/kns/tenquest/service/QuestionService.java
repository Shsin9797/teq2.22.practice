package com.kns.tenquest.service;

import com.kns.tenquest.entity.Question;
import com.kns.tenquest.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionRepository questionRepository;

    public List<Question> getAllQuestions(){
        return questionRepository.findAll();
    }

    //특정한 question_created_by 컬럼 값에 해당하는 질문객체 들을 찾아서 리스트로 반환
    public List<Question> getAllQuestionsByQuestionCreatedBy(String memberId) {


        return questionRepository.findAllByQuestionCreatedBy(memberId);
    }
}
