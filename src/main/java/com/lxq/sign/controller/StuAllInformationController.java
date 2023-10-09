package com.lxq.sign.controller;

import com.lxq.sign.service.AddStuByPictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SuppressWarnings({"all"})
@RestController
@RequestMapping("/stu")
public class StuAllInformationController {

    @Autowired
    AddStuByPictureService addStuByPictureService;

    @GetMapping("/{path}")
    public Result insertStuInf(@PathVariable String path){
        Result inf = addStuByPictureService.getInf(path);
        return inf;
    }

}
