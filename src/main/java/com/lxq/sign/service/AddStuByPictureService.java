package com.lxq.sign.service;


import com.lxq.sign.controller.Result;
import com.lxq.sign.domain.UpdateStudentInf;

import java.util.LinkedList;

public interface AddStuByPictureService {
    Result getInf(String path);
    Result addStuInf(LinkedList<UpdateStudentInf> updateStudentInfs);
    Result changeInf(UpdateStudentInf updateStudentInf);
    Result changeTable(UpdateStudentInf updateStudentInf);
}
