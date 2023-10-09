package com.lxq.sign.controller;

import com.lxq.sign.domain.StudentInf;
import com.lxq.sign.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@SuppressWarnings({"all"})
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @GetMapping
    public Result getAllAdmin(){
        Result allAdmin = adminService.getAllAdmin();
        return allAdmin;
    }

    @GetMapping("/{id}")
    public Result getOneAdmin(@PathVariable Integer id){
        Result oneAdmin = adminService.getOneAdmin(id);
        return oneAdmin;
    }

    @DeleteMapping("/{id}")
    public Result delOneAdmin(@PathVariable Integer id){
        Result result = adminService.delOneAdmin(id);
        return result;
    }

    @PutMapping
    public Result updateAdmin(@RequestBody StudentInf studentInf){
        Result result = adminService.updateAdmin(studentInf);
        return result;
    }

    @PostMapping
    public Result addAdmin(@RequestBody StudentInf studentInf){
        Result result = adminService.addAdmin(studentInf);
        return result;
    }
}
