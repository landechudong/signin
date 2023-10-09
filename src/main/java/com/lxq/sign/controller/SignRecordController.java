package com.lxq.sign.controller;

import com.lxq.sign.service.SignRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@SuppressWarnings({"all"})
@RestController
@RequestMapping("/signRecord")
public class SignRecordController {
    @Autowired
    SignRecordService signRecordService;

    @GetMapping("/loginIf")
    public Result loginIf(){
        Result result = signRecordService.loginInf();
        return result;
    }

    @GetMapping("/{stuName}")
    public Result addSignRecord(@PathVariable String stuName){
        Result result = signRecordService.addSignInf(stuName);
        return result;
    }

    @GetMapping("/getInf/{page}")
    public Result getLoginInf(@PathVariable Integer page){
        Result loginInf = signRecordService.getSignInf(page);
        return loginInf;
    }

    @DeleteMapping("/deleted")
    public Result delLoginInf(){
        Result result = signRecordService.delSignInf();
        return result;
    }

}
