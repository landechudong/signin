package com.lxq.sign.service.Impl;

import com.lxq.sign.controller.Code;
import com.lxq.sign.controller.Result;
import com.lxq.sign.dao.StudentDao;
import com.lxq.sign.dao.TimeTableDao;
import com.lxq.sign.domain.ProxySignInf;
import com.lxq.sign.domain.StudentInf;
import com.lxq.sign.domain.TimeTables;
import com.lxq.sign.service.ProxySignService;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.LinkedList;

@SuppressWarnings({"all"})
@Service
public class ProxySignImpl implements ProxySignService {

    @Autowired
    TimeTableDao timeTableDao;

    @Autowired
    StudentDao studentDao;

    @Override
    public Result getProxyInf() {
        LocalDateTime now = LocalDateTime.now();
        DayOfWeek dayOfWeek = now.getDayOfWeek();
        String dayWeek = dayOfWeek.name();

        LinkedList<ProxySignInf> proxySignInfs = new LinkedList<>();
        ProxySignInf proxySignInf;

        if (dayWeek.equals("MONDAY")){
            LinkedList<TimeTables> mondayInf = timeTableDao.getMondayInf();
            for (TimeTables timeTables : mondayInf) {
                StudentInf studentInf = studentDao.selectByCode(timeTables.getStuCode());
                String stuName = studentInf.getStuName();
                proxySignInf = new ProxySignInf(timeTables.getClassToClass(), stuName);
                proxySignInfs.add(proxySignInf);
            }
            return new Result(Code.GET_OK,proxySignInfs);
        }else if(dayWeek.equals("TUESDAY")){
            LinkedList<TimeTables> tuesdayInf = timeTableDao.getTuesdayInf();
            for (TimeTables timeTables : tuesdayInf) {
                StudentInf studentInf = studentDao.selectByCode(timeTables.getStuCode());
                String stuName = studentInf.getStuName();
                proxySignInf = new ProxySignInf(timeTables.getClassToClass(), stuName);
                proxySignInfs.add(proxySignInf);
            }
            return new Result(Code.GET_OK,proxySignInfs);
        }else if(dayWeek.equals("WEDNESDAY")){
            LinkedList<TimeTables> wednesdayInf = timeTableDao.getWednesdayInf();
            for (TimeTables timeTables : wednesdayInf) {
                StudentInf studentInf = studentDao.selectByCode(timeTables.getStuCode());
                String stuName = studentInf.getStuName();
                proxySignInf = new ProxySignInf(timeTables.getClassToClass(), stuName);
                proxySignInfs.add(proxySignInf);
            }
            return new Result(Code.GET_OK,proxySignInfs);
        }else if(dayWeek.equals("THURSDAY")){
            LinkedList<TimeTables> thursdayInf = timeTableDao.getThursdayInf();
            for (TimeTables timeTables : thursdayInf) {
                StudentInf studentInf = studentDao.selectByCode(timeTables.getStuCode());
                String stuName = studentInf.getStuName();
                proxySignInf = new ProxySignInf(timeTables.getClassToClass(), stuName);
                proxySignInfs.add(proxySignInf);
            }
            return new Result(Code.GET_OK,proxySignInfs);
        }else if(dayWeek.equals("FRIDAY")){
            LinkedList<TimeTables> fridayInf = timeTableDao.getFridayInf();
            for (TimeTables timeTables : fridayInf) {
                StudentInf studentInf = studentDao.selectByCode(timeTables.getStuCode());
                String stuName = studentInf.getStuName();
                proxySignInf = new ProxySignInf(timeTables.getClassToClass(), stuName);
                proxySignInfs.add(proxySignInf);
            }
            return new Result(Code.GET_OK,proxySignInfs);
        }else {
            return new Result(Code.GET_ERR,null);
        }

    }

    @Override
    public Result proxySign(ProxySignInf proxySignInf) {
        String stuCode = studentDao.selectByName(proxySignInf.getStuName());
        LocalDateTime now = LocalDateTime.now();
        DayOfWeek dayOfWeek = now.getDayOfWeek();
        String dayWeek = dayOfWeek.name();

        Integer integer = 0;
        if(dayWeek.equals("MONDAY")){
            integer = timeTableDao.updateByProxyOnMonday(proxySignInf.getSections(), stuCode);
        }else if(dayWeek.equals("TUESDAY")){
            integer = timeTableDao.updateByProxyOnTuesday(proxySignInf.getSections(), stuCode);
        }else if(dayWeek.equals("WEDNESDAY")){
            integer = timeTableDao.updateByProxyOnWednesday(proxySignInf.getSections(), stuCode);
        }else if(dayWeek.equals("THURSDAY")){
            integer = timeTableDao.updateByProxyOnThursday(proxySignInf.getSections(), stuCode);
        }else if(dayWeek.equals("FRIDAY")){
            integer = timeTableDao.updateByProxyOnFriday(proxySignInf.getSections(), stuCode);
        }

        return new Result(integer != 0 ? Code.UPDATE_OK:Code.UPDATE_ERR,"代签成功!");
    }


}
