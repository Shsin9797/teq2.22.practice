package com.kns.tenquest.controller;


import com.kns.tenquest.entity.Question;
import org.springframework.ui.Model;
import com.kns.tenquest.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller // 어떤 요청이랑 어떤 함수(api)를 맵핑하면 좋을지 알려주는 역할
public class QuestionController {

    @Autowired
    QuestionService questionService;


    //질문  객체 전체를 html 이용하여 화면에 표시하기  (확인)  : GET
    @RequestMapping(value = "/view/questions", method = RequestMethod.GET)
    public String questionView(Model model){

        List<Question> questionList = questionService.getAllQuestions();
        model.addAttribute("questionList", questionList);
        return "question_view";

    }

    //#################################################################

    //RestController 구현 부분 : 데이터만 프론트에 전달
    // **********************************GET ( 자료 찾아오기만 하는부분 )

    //전체 질문지 보내주기//
    // 전체 질문지 중에서도 quetsion_created_by  와 member_id 가 같은지 확인하고 같은경우만 반환한다


    //카테고리 별 확인 //특정 카테고리에 해당하는 질문 확인하기 (외래키 question_category_id 이용) : GET : 데이터 가져와서 뿌려주기
         //사용자 지정  아닌경우(question_category_id != 1)



         //사용자 지정인 경우 (question_category_id != 1)
         // quetsion_created_by  와 member_id 가 같은지 확인하고 같은경우만 반환한다



    //question_id로 호출하면.. (UUID) 해당질문(question_content) 1개 보내줌 GET (각템플릿에서 호출하거나 할때 필요함)





    //질문 추가하기 : POST  : 데이터 추가 : 개발자& 이용자

    //질문 수정하기 : UPDATE : 데이터 수정: 개발자& 이용자

    //질문 삭제하기 : DELETE : 데이터 삭제: 일부는 개발자 & 일부는 이용자
}
