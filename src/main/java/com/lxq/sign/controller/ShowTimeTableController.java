package com.lxq.sign.controller;

import com.lxq.sign.domain.TimeTables;
import com.lxq.sign.service.ShowScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@SuppressWarnings({"all"})
@RestController
@RequestMapping("/stuTableTime")
public class ShowTimeTableController {

    @Autowired
    ShowScheduleService showScheduleService;

    @GetMapping("/{code}")
    public Result getSchedule(@PathVariable String code){
        Result schedule = showScheduleService.getSchedule(code);
        return schedule;
    }

    @PutMapping("/{day}")
    public Result changeSchedule(@PathVariable String day,@RequestBody TimeTables timeTables) {
        Result result = showScheduleService.changeSchedule(day,timeTables);
        return result;
    }

}
