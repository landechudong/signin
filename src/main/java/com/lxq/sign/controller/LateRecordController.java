package com.lxq.sign.controller;

import com.lxq.sign.domain.LateOneRecord;
import com.lxq.sign.service.LateRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@SuppressWarnings({"all"})
@RestController
@RequestMapping("/lateRecord")
public class LateRecordController {

    @Autowired
    LateRecordService lateRecordService;

    @GetMapping
    public Result getLateRecord(){
        Result lateRecord = lateRecordService.getLateRecord();
        return lateRecord;
    }

    @PostMapping
    public Result addLateInf(@RequestBody LateOneRecord lateOneRecord){
        Result result = lateRecordService.addLateInf(lateOneRecord);
        return result;
    }

    @GetMapping("/{stuCode}")
    public Result getOneLateRecord(@PathVariable String stuCode){
        Result oneLateRecord = lateRecordService.getOneLateRecord(stuCode);
        return oneLateRecord;
    }

}
