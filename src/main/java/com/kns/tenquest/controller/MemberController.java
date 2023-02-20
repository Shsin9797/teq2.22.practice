package com.kns.tenquest.controller;

import com.kns.tenquest.ResponseStatus;
import com.kns.tenquest.dto.MemberDTO;
import com.kns.tenquest.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    }

    @ResponseBody
    @PostMapping("/api/register")
    public int apiRegisterMember(@RequestBody MemberDTO dto) throws NoSuchAlgorithmException {
       memberService.insertMember(dto);
        return ResponseStatus.CREATE_DONE.getCode(); /* [!] need to modify later */
    }
}
