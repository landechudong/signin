package com.lxq.sign.service.Impl;

import com.lxq.sign.controller.Code;
import com.lxq.sign.controller.Result;
import com.lxq.sign.dao.LoginBrowserDao;
import com.lxq.sign.dao.StudentDao;
import com.lxq.sign.domain.LoginBrowser;
import com.lxq.sign.domain.StudentInf;
import com.lxq.sign.service.StuLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@SuppressWarnings({"all"})
@Service
public class StuLoginImpl implements StuLoginService {

    @Autowired
    StudentDao studentDao;

    @Autowired
    LoginBrowserDao loginBrowserDao;

    @Override
    public Result FindStu(StudentInf student,String browser) {
        LoginBrowser loginBrowser = loginBrowserDao.selectStuCode(student.getStuCode());
        if(loginBrowser == null){
            int insert = loginBrowserDao.insert(new LoginBrowser(null, student.getStuCode(), browser));
            if(student.getPassword().equals(student.getStuCode())) {
                StudentInf studentInf1 = studentDao.selectByCode(student.getStuCode());
                if (studentInf1 != null) {
                    studentInf1.setStuCode(student.getStuCode());
                }
                return new Result(studentInf1 == null ? Code.GET_ERR : Code.GET_OK , studentInf1);
            }else{
                return new Result(Code.GET_ERR,null);
            }
        }else {
            String s = loginBrowserDao.selectBrowser(student.getStuCode());
            if(s.equals(browser)){
                if(student.getPassword().equals(student.getStuCode())) {
                    StudentInf studentInf1 = studentDao.selectByCode(student.getStuCode());
                    if (studentInf1 != null) {
                        studentInf1.setStuCode(student.getStuCode());
                    }
                    return new Result(studentInf1 == null ? Code.GET_ERR : Code.GET_OK , studentInf1);
                }else{
                    return new Result(Code.GET_ERR,null);
                }
            }else {
                return new Result(Code.SYSTEM_UNKNOW_ERR,"请使用你首次登录的浏览器登录");
            }
        }

    }
}
