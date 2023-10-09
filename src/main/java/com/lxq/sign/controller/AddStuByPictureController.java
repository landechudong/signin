package com.lxq.sign.controller;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

import java.io.*;

import com.lxq.sign.domain.UpdateStudentInf;
import com.lxq.sign.service.AddStuByPictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;

@SuppressWarnings({"all"})
@RestController
@RequestMapping("/addStu")
public class AddStuByPictureController {

    @Autowired
    AddStuByPictureService addStuByPictureService;
    public static Integer pictureNum = 0;

    @PostMapping("/{path}")
    public Result addStu(@PathVariable String path) {

        pictureNum++;
        String pathName = path.substring(0, path.length() - 1);
//
        String path2 = "/www/wwwroot/picture/"+pathName;
//        String path2 = "D:\\Picture\\"+pathName;
        System.out.println(path2);
        File file1 = new File(path2);
        System.out.println("云服务器"+file1.exists());
        if(file1.exists()) {
            Result inf = addStuByPictureService.getInf(path2);
            return inf;
        }else {
            return new Result(Code.INSERT_ERR,"请将文件存放在/www/wwwroot目录的picture文件下才可以上传");
        }

    }

    @PostMapping("/change")
    public Result changeStuTable(@RequestBody UpdateStudentInf updateStudentInf){
        Result result = addStuByPictureService.changeTable(updateStudentInf);
        return result;
    }

    @PutMapping("/update")
    public Result updateStu(@RequestBody UpdateStudentInf updateStudentInf){
        Result result = addStuByPictureService.changeInf(updateStudentInf);
        return result;
    }

    @PostMapping()
    public Result add(@RequestBody LinkedList<UpdateStudentInf> updateStudentInfs){
        Result result = addStuByPictureService.addStuInf(updateStudentInfs);
        return result;
    }

}
