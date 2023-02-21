package com.kns.tenquest.controller;


import com.kns.tenquest.entity.Question;
import org.springframework.ui.Model;
import com.kns.tenquest.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.UUID;

@Controller // 어떤 요청이랑 어떤 함수(api)를 맵핑하면 좋을지 알려주는 역할
public class QuestionController {

    @Autowired
    QuestionService questionService;
    @Autowired
    MemberController memberController;

    //개발자의 MemberId(uuid) 찾기
    String memberIdForDeveloper = memberController.apiGetMemberIdByUserId("developer"); // NullPointExeption 발생한다는데 ???

    //이거 요청한 사람의 MemberId(uuid) 찾기




    //질문  객체 전체를 html 이용하여 화면에 표시하기  (확인)  : GET
    @RequestMapping(value = "/view/questions", method = RequestMethod.GET)
    public String questionView(Model model){

        List<Question> questionList = questionService.getAllQuestions();
        model.addAttribute("questionList", questionList);
        return "question_view";

    }

    //#################################################################

    //RestController 구현 부분 : 데이터만 프론트에 전달
    // **********************************GET ( 자료 찾아오기만 하는부분 )*************************************

    //전체 질문지 보내주기1// 개발자용 ( 이상한 질문추가 됐는지 아닌지 확인할때 쓸수있을듯 )
    // question_created_by 가 개발자의 member_id 인 경우에만
    // (user_id)가 develop 인경우의 UUID 찾는 함수..( MemberController가 갖고있는 함수) 이용해보려고했는데 안됨.. static 이어야한다고)
    @ResponseBody
    @RequestMapping(value = "get/questions",method=RequestMethod.GET)
    public List<Question> apiGetAllQuestions(@RequestParam(name = "questionCreatedBy",required = false,defaultValue ="") String question_created_by) {


        //String member_id2= MemberController.apiGetMemberIdByUserId("developer"); //이거 안됨.. . MemberController 의 객체를 만들고 해야함..

        //접근중인 사람의 memeberId


        if (현재접근중인사람의memberId.equals(member_id)) {
            return questionService.getAllQuestions();
        }else{
            return null;
        } // null 대문자 안됨


    }




    //전체 질문지 보내주기2// 사용자용
    // 전체 질문지 중에서도 question_created_by  와 현재접근중인 멤버의 member_id 가 같은지 확인하고 같은경우만 반환한다


    //카테고리 별 확인 //특정 카테고리에 해당하는 질문 확인하기 (외래키 question_category_id 이용) : GET : 데이터 가져와서 뿌려주기
         //사용자 지정  아닌경우(question_category_id != 1)



         //사용자 지정인 경우 (question_category_id != 1)
         // question_created_by  와 member_id 가 같은지 확인하고 같은경우만 반환한다



    //question_id로 호출하면.. (UUID) 해당질문(question_content) 1개 보내줌 GET (각템플릿에서 호출하거나 할때 필요함)






     //*************************************POST *************************************
    //질문 추가하기 : POST  : 데이터 추가 : 개발자& 이용자

    //질문 수정하기 : UPDATE : 데이터 수정: 개발자& 이용자

    //질문 삭제하기 : DELETE : 데이터 삭제: 일부는 개발자 & 일부는 이용자
}
