package com.kns.tenquest.controller;

import com.kns.tenquest.dto.MemberResponseMapping;
import com.kns.tenquest.response.ResponseStatus;
import com.kns.tenquest.dto.MemberDTO;
import com.kns.tenquest.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.kns.tenquest.service.MemberService;

import java.security.NoSuchAlgorithmException;
import java.util.List;

@Controller
public class MemberController {
    @Autowired
    MemberService memberService;
    //@ResponseBody
    @GetMapping("/view/members")
    public String memberView(Model model){
        // Temporarily implemented. Just for test.
        List<Member> memberList = memberService.getAllMembers();
        model.addAttribute("memberList", memberList);
        return "member_view";
    } // 여기까지는 그냥화면에  html 파일 띄우는거



    //여기부터 데이터만 전달 (Jason Type) 으로


    //모든 멤버들 전체정보 보여주기
    @ResponseBody
    @GetMapping("/get/members")
    public List<Member> apiGetAllMembers(){
        return memberService.getAllMembers();
    }

    //#########멤버 한명의 전체 정보 조회
    //특정멤버의 멤버번호(자동생성 UUID) 으로 멤버 객체 한명의 전체 정보 찾아서 반환
    @ResponseBody
    @GetMapping("/get/member/memberId")
    public MemberResponseMapping apiGetMemberByMemberId(@RequestParam("value") String memberId){
        return memberService.getMemberByMemberId(memberId);
    }

    //특정멤버의 아이디로 멤버 객체 한명의 전체 정보 찾아서 반환
    @ResponseBody
    @GetMapping("/get/member/userId")
    public MemberResponseMapping apiGetMemberByUserId(@RequestParam("value") String userId){
        return memberService.getMemberByUserId(userId);
    }

    //특정멤버의 이름이랑 이메일로 .. 멤버 조회 .. ..멤버 객체 한명의 전체 정보 찾아서 반환  동일한 멤버 있는지 확인하려는 거인듯 .. 한명의 멤버만 확인
    @ResponseBody
    @GetMapping("/get/member")
    public MemberResponseMapping apiGetMemberByUserNameAndUserId(@RequestParam("userName") String userName, @RequestParam("userEmail") String userEmail){
        return memberService.getMemberByUserNameAndEmail(userName,userEmail);
    }

    //#######################################

    // 아이디를 이용해서.. 자동생성되는 멤버번호(UUID) 확인
    @ResponseBody
    @GetMapping("/get/memberId/userId")
    public String apiGetMemberIdByUserId(@RequestParam("value") String userId){
        return memberService.getMemberIdByUserId(userId);
    }


    // 멤버이름이랑 이메일로 .. 유저아이디만 가져오기 .. //id 찾기에 사용되는듯
    @ResponseBody
    @GetMapping("/get/memberId")
    public String apiGetMemberIdByUserName(@RequestParam("userName") String userName, @RequestParam("userEmail") String userEmail){
        return memberService.getMemberIdByUserNameAndUserEmail(userName, userEmail);
    }


    //멤버 DTO 객체를 이용해서 .. 멤버 를 등록하고.. 성공하면 201 실패하면 409 숫자 반환
    @ResponseBody
    @PostMapping("/member/register")
    public int apiRegisterMember(@RequestBody MemberDTO dto) throws NoSuchAlgorithmException {
       ResponseStatus responseStatus = memberService.insertMember(dto);
        return responseStatus.getCode();
    }
}
