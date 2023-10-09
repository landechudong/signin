package com.lxq.sign.controller;

import com.lxq.sign.domain.UpdateStu;
import com.lxq.sign.service.ShowStuListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@SuppressWarnings({"all"})
@RestController
@RequestMapping("/stuInf")
public class ShowStuListController {

    @Autowired
    ShowStuListService showStuListService;

    @GetMapping("/{currentPage}")
    public Result getAllStu(@PathVariable Integer currentPage){
        Result stuInf = showStuListService.getStuInf(currentPage);
        return stuInf;
    }

    @GetMapping("/getOne/{stuCode}")
    public Result getOneStu(@PathVariable String stuCode){
        Result oneInf = showStuListService.getOneInf(stuCode);
        return oneInf;
    }

    @GetMapping("/getTable/{stuCode}")
    public Result getStuTable(@PathVariable String stuCode){
        Result oneInf = showStuListService.getStuTable(stuCode);
        return oneInf;
    }

    @DeleteMapping("/delStu/{id}")
    public Result delStuById(@PathVariable Integer id){
        Result result = showStuListService.delStuById(id);
        return result;
    }

    @PutMapping("/updateStuInf")
    public Result updateInf(@RequestBody UpdateStu updateStu){
        System.out.println(updateStu);
        Result result = showStuListService.updateInf(updateStu);
        return result;
    }

    @GetMapping("/getOneTableTime/{id}")
    public Result getOneTableTime(@PathVariable Integer id){
        Result oneTableTime = showStuListService.getOneTableTime(id);
        return oneTableTime;
    }
}
