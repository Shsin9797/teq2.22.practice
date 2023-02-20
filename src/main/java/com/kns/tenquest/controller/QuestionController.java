package com.kns.tenquest.controller;


import com.kns.tenquest.entity.Question;
import org.springframework.ui.Model;
import com.kns.tenquest.service.QuestionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class QuestionController {

    @Autowired
    QuestionServices questionServices;


    //질문  객체 전체를  화면에 표시하기  (확인)  : GET
    @RequestMapping(value = "/view/question", method = RequestMethod.GET)
    public String questionView(Model model){

        List<Question> questionList = questionServices.getAllQuestions();
        model.addAttribute("questionList", questionList);
        return "question_view";

    }


    //질문 추가하기 : POST  : 데이터 추가 : 개발자& 이용자

    //질문 수정하기 : UPDATE : 데이터 수정: 개발자& 이용자

    //질문 삭제하기 : DELETE : 데이터 삭제: 일부는 개발자 & 일부는 이용자
}
