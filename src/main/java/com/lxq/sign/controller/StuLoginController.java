package com.lxq.sign.controller;

import com.lxq.sign.domain.StudentInf;
import com.lxq.sign.service.StuLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@SuppressWarnings({"all"})
@RestController
@RequestMapping("/stuLogin")
public class StuLoginController {

    @Autowired
    StuLoginService stuLoginService;

    @PostMapping("/{browser}")
    public Result stuLogin(@PathVariable String browser,@RequestBody StudentInf student){
        Result result = stuLoginService.FindStu(student,browser);
        return result;
    }


}
