package com.lxq.sign.controller;


import com.lxq.sign.domain.Time;
import com.lxq.sign.domain.TrueTime;
import com.lxq.sign.service.ShowTimeService;
import com.sun.tracing.dtrace.ProviderAttributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@SuppressWarnings({"all"})
@RestController
@RequestMapping("/schedule")
public class ShowTimeController {

    @Autowired
    ShowTimeService showTimeService;

    @GetMapping("/getSchedule")
    public Result getAllTimeInf(){
        Result result = showTimeService.GetAllTimeInf();
        return result;
    }

    @GetMapping("/getOneTime/{section}")
    public Result getOneTime(@PathVariable String section){
        Result result = showTimeService.GetOneTimeInf(section);
        return result;
    }


    @PutMapping("/updateTime")
    public Result updateTime(@RequestBody TrueTime time){
        Result result = showTimeService.UpdateTimeBySections(time);
        return result;
    }

    @GetMapping("/getWeek")
    public Result getWeek(){
        Result week = showTimeService.getWeek();
        return week;
    }

    @PutMapping("/updateWeek/{week}")
    public Result updateWeek(@PathVariable Integer week){
        Result result = showTimeService.updateWeek(week);
        return result;
    }

    @PutMapping("/updateOriginalTime")
    public Result updateOrginalTime(){
        Result result = showTimeService.updateOriginalTime();
        return result;
    }
}
