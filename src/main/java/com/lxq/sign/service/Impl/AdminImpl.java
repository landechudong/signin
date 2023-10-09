package com.lxq.sign.service.Impl;

import com.lxq.sign.controller.Code;
import com.lxq.sign.controller.Result;
import com.lxq.sign.dao.StudentDao;
import com.lxq.sign.domain.StudentInf;
import com.lxq.sign.service.AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.LinkedList;

@SuppressWarnings({"all"})
@Service
public class AdminImpl implements AdminService {

    @Autowired
    StudentDao studentDao;

    @Override
    public Result getAllAdmin() {
        LinkedList<StudentInf> studentInfs = studentDao.selectAllAdmin();
        return new Result(studentInfs.size() == 0 ? Code.GET_ERR:Code.GET_OK,studentInfs);
    }

    @Override
    public Result getOneAdmin(Integer id) {
        StudentInf studentInf = studentDao.selectOneAdmin(id);
        return new Result(Code.GET_OK,studentInf);
    }

    @Override
    public Result delOneAdmin(Integer id) {
        Integer integer = studentDao.delOneAdmin(id);
        return new Result(integer == 0 ? Code.DELETE_ERR:Code.DELETE_OK,"删除成功!");
    }

    @Override
    public Result updateAdmin(StudentInf studentInf) {
        if(studentInf.getStuName().length() != 0 && studentInf.getStuCode().length() != 0 && studentInf.getStuCode().length() <13) {
            int i = 0;
            try {
                i = studentDao.updateAdminInf(studentInf.getId(), studentInf.getStuCode(), studentInf.getStuName());
            } catch (Exception e) {
                i = 0;
            }
            return new Result(i == 0 ? Code.UPDATE_ERR : Code.UPDATE_OK, "修改成功!");
        }else{
            return new Result(0,"请正确输入格式(长度不能超过13)!");
        }
    }

    @Override
    public Result addAdmin(StudentInf studentInf) {
        System.out.println(studentInf);
        if(studentInf.getStuName().length() == 0 || studentInf.getStuCode().length() == 0){
            return new Result(0,"请输入内容!");
        }else {
            int insert = studentDao.insertAdmin(studentInf.getStuName(),studentInf.getStuCode());
            System.out.println(insert);
            return new Result(insert == 0?Code.INSERT_ERR:Code.INSERT_OK,"添加成功!");
        }


    }
}
