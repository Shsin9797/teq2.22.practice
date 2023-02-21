package com.kns.tenquest.service;

import com.kns.tenquest.entity.Category;
import com.kns.tenquest.entity.Template;
import com.kns.tenquest.repository.CategoryRepository;
import com.kns.tenquest.repository.TemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TemplateService {

        @Autowired
        TemplateRepository templateRepository;

        public List<Template> getAllTemplates(){
            return templateRepository.findAll();

        }
    }


