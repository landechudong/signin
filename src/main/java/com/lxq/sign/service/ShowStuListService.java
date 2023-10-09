package com.lxq.sign.service;

import com.lxq.sign.controller.Result;
import com.lxq.sign.domain.UpdateStu;

public interface ShowStuListService {
    Result getStuInf(Integer currentPage);
    Result getOneInf(String stuCode);
    Result delStuById(Integer id);
    Result updateInf(UpdateStu updateStu);
    Result getOneTableTime(Integer id);
    Result getStuTable(String stuCode);
}
