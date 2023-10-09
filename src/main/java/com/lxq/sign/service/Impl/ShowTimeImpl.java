package com.lxq.sign.service.Impl;

import com.lxq.sign.controller.Code;
import com.lxq.sign.controller.Result;
import com.lxq.sign.dao.LateOneDao;
import com.lxq.sign.dao.SignRecordDao;
import com.lxq.sign.dao.TimeDao;
import com.lxq.sign.dao.TimeTableDao;
import com.lxq.sign.domain.CelWeek;
import com.lxq.sign.domain.Time;
import com.lxq.sign.domain.TrueTime;
import com.lxq.sign.service.ShowTimeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalTime;
import java.util.LinkedList;

@SuppressWarnings({"all"})
@Service
public class ShowTimeImpl implements ShowTimeService {

    @Autowired
    TimeDao timeDao;
    @Autowired
    SignRecordDao loginRecordDao;
    @Autowired
    TimeTableDao timeTableDao;
    @Autowired
    LateOneDao lateOneDao;

    @Override
    public Result GetAllTimeInf() {
        LinkedList<Time> times = timeDao.selectAll();
        return new Result(Code.GET_OK,times);
    }

    @Override
    public Result GetOneTimeInf(String section) {
        Time timeBySection = timeDao.getTimeBySection(section);
        return new Result(Code.GET_OK,timeBySection);
    }

    @Override
    public Result UpdateTimeBySections(TrueTime time) {

        String[] split1 = time.getStartTime().split(":");
        String[] split2 = time.getLastTime().split(":");
        String[] split3 = time.getLateTime().split(":");
        if(split1.length != 8 && split2.length != 8 && split3.length != 8){

        }

        LocalTime startTime = LocalTime.of(Integer.parseInt(split1[0]),Integer.parseInt(split1[1]),Integer.parseInt(split1[2]));
        LocalTime lastTime = LocalTime.of(Integer.parseInt(split2[0]),Integer.parseInt(split2[1]),Integer.parseInt(split2[2]));
        LocalTime lateTime = LocalTime.of(Integer.parseInt(split3[0]),Integer.parseInt(split3[1]),Integer.parseInt(split3[2]));

        Time timeBySection = timeDao.getTimeBySection(time.getSections());
        int i = startTime.compareTo(timeBySection.getStartTime());
        int i1 = lastTime.compareTo(timeBySection.getLastTime());
        int i2 = lateTime.compareTo(timeBySection.getLateTime());

        if(i == 0 && i1 == 0 && i2 == 0){
            return new Result(Code.UPDATE_ERR,"也没修改呢!");
        }else {
            Integer integer = timeDao.updateBySection(time.getSections(), startTime, lastTime, lateTime);
            System.out.println("??????????????????????" + integer);
            return new Result(integer == 1 ? Code.UPDATE_OK : Code.UPDATE_ERR, "修改成功!");
        }

    }

    @Override
    public Result getWeek() {
        LinkedList<CelWeek> week = timeDao.getWeek();
        return new Result(Code.GET_OK,week);
    }

    @Override
    public Result updateWeek(Integer week) {
        if(week > 0 && week <= 20) {
            Integer integer = timeDao.updateWeek(week);
            timeTableDao.deleteTableTime();
            lateOneDao.delLateRecord();
            return new Result(integer == 1 ? Code.UPDATE_OK : Code.UPDATE_ERR, "修改成功!");
        }else {
            return new Result(Code.UPDATE_ERR,"输入的周需要大于零小于等于二十");
        }
    }

    @Override
    public Result updateOriginalTime() {
        Integer integer = loginRecordDao.updateOriginalTime();
        return new Result(integer == 1 ? Code.UPDATE_OK:Code.UPDATE_ERR,"修改成功!");
    }


}
