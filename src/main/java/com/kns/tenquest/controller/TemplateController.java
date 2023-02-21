package com.kns.tenquest.controller;

import com.kns.tenquest.entity.Category;
import com.kns.tenquest.entity.Template;
import com.kns.tenquest.service.CategoryService;
import com.kns.tenquest.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class TemplateController {

    @Autowired
    TemplateService templateService;


    //템플릿 확인하기(전체) : GET  : 데이터 가져와서 뿌려주기
    @RequestMapping(value="/view/templates",method= RequestMethod.GET)
    public String templateView(Model model){
        // Temporarily implemented. Just for test.
        List<Template> templateList = templateService.getAllTemplates();
        model.addAttribute("templateList", templateList);
        return "template_view";
    }

    //템플릿 추가하기 : POST  : 데이터 추가 : 개발자만 가능

    //템플릿 수정하기 : UPDATE : 데이터 수정: 개발자만 가능

    //템플릿 삭제하기 : DELETE : 데이터 삭제: 개발자만 가능

}


