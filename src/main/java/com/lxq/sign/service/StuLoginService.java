package com.lxq.sign.service;

import com.lxq.sign.controller.Result;
import com.lxq.sign.domain.StudentInf;


public interface StuLoginService {
    Result FindStu(StudentInf student,String browser);
}
