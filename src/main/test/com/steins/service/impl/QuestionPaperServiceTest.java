package com.steins.service.impl;

import com.steins.dao.BaseTest;
import com.steins.entity.QuestionPaper;
import com.steins.entity.QuestionType;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class QuestionPaperServiceTest extends BaseTest {
    @Autowired
    private QuestionPaperService questionPaperService;
    @Test
    public void ckAdminQuestion() {
        List<QuestionPaper> questionPaperList=new ArrayList<>();
        questionPaperList=questionPaperService.ckAdminQuestionPaper();
        System.out.println(questionPaperList);
        System.out.println("============");

    }
    @Test
    public void allQT(){
        List<QuestionType> list=new ArrayList<>();
        list=questionPaperService.allQT();
        System.out.println(list);
        System.out.println("============");
    }
}