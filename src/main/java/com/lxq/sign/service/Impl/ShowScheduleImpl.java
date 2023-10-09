package com.lxq.sign.service.Impl;

import com.lxq.sign.controller.Code;
import com.lxq.sign.controller.Result;
import com.lxq.sign.dao.SignRecordDao;
import com.lxq.sign.dao.StudentDao;
import com.lxq.sign.dao.TimeDao;
import com.lxq.sign.dao.TimeTableDao;
import com.lxq.sign.domain.StudentInf;
import com.lxq.sign.domain.Time;
import com.lxq.sign.domain.TimeTables;
import com.lxq.sign.service.AddTimeTableService;
import com.lxq.sign.service.ShowScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.LinkedList;

@SuppressWarnings({"all"})
@Service
public class ShowScheduleImpl implements ShowScheduleService {

    @Autowired
    TimeTableDao timeTableDao;

    @Autowired
    TimeDao timeDao;

    @Autowired
    AddTimeTableService addTimeTableDao;

    @Autowired
    SignRecordDao signRecordDao;

    @Override
    public Result getSchedule(String code) {

        LinkedList<String> code1 = timeTableDao.findCode(code);
        if(code1.size() == 0) {
            Result timeTable = addTimeTableDao.getTimeTable(code);
            LinkedList<TimeTables> timeTables = timeTableDao.selectByCode(code);
            return new Result(Code.GET_OK , timeTables);
        }else {
            LinkedList<TimeTables> timeTables = timeTableDao.selectByCode(code);
            return new Result(Code.GET_OK,timeTables);
        }

    }

    @Override
    public Result changeSchedule(String day,TimeTables timeTables) {
        //获取当下的时间
        LocalDateTime now = LocalDateTime.now();
        int hour = now.getHour();
        int minute = now.getMinute();
        DayOfWeek dayOfWeek = now.getDayOfWeek();

        //获取签到时间
        Time timeBySection = timeDao.getTimeBySection(timeTables.getClassToClass());

        int hour1 = timeBySection.getStartTime().getHour();
        int minute1 = timeBySection.getStartTime().getMinute();

        int hour2 = timeBySection.getLastTime().getHour();
        int minute2 = timeBySection.getLastTime().getMinute();

        int hour3 = timeBySection.getLateTime().getHour();
        int minute3 = timeBySection.getLateTime().getMinute();

        //当下时间点
        LocalTime of = LocalTime.of(hour, minute);
        //开始签到时间点
        LocalTime of1 = LocalTime.of(hour1, minute1);
        //结束签到时间点
        LocalTime of2 = LocalTime.of(hour2, minute2);
        //迟到签到时间点
        LocalTime of3 = LocalTime.of(hour3, minute3);

        int i1 = of.compareTo(of1);
        int i2 = of.compareTo(of2);
        int i3 = of.compareTo(of3);


        if(day.equals(dayOfWeek.name().toLowerCase())) {
            if (dayOfWeek.name().toLowerCase().equals("monday")) {
                if (i1 == 0 || i1 == 1 && i2 == -1 || i2 == 0) {
                    Integer integer = timeTableDao.updateByMonday(timeTables.getClassToClass(), timeTables.getStuCode());
                    return new Result(Code.UPDATE_OK,"签到成功!!");
                }else if(i2 == 0 || i2 == 1 && i3 == -1 || i3 == 0){
                    Integer integer = timeTableDao.updateByLateMonday(timeTables.getClassToClass(), timeTables.getStuCode());
                    return new Result(Code.UPDATE_OK,"迟到了!请向负责人说明理由!");
                }else{
                    return new Result(Code.UPDATE_ERR,"请在正确的时间点签到!!");
                }
            } else if (dayOfWeek.name().toLowerCase().equals("tuesday")) {
                if (i1 == 0 || i1 == 1 && i2 == -1 || i2 == 0) {
                    Integer integer = timeTableDao.updateByTuesday(timeTables.getClassToClass(), timeTables.getStuCode());
                    return new Result(Code.UPDATE_OK,"签到成功!!");
                }else if(i2 == 0 || i2 == 1 && i3 == -1 || i3 == 0){
                    Integer integer = timeTableDao.updateByLateTuesday(timeTables.getClassToClass(), timeTables.getStuCode());
                    return new Result(Code.UPDATE_OK,"迟到了!请向负责人说明理由!");
                }else{
                    return new Result(Code.UPDATE_ERR,"请在正确的时间点签到!!");
                }
            } else if (dayOfWeek.name().toLowerCase().equals("wednesday")) {
                if (i1 == 0 || i1 == 1 && i2 == -1 || i2 == 0) {
                    Integer integer = timeTableDao.updateByWednesday(timeTables.getClassToClass(), timeTables.getStuCode());
                    return new Result(Code.UPDATE_OK,"签到成功!!");
                }else if(i2 == 0 || i2 == 1 && i3 == -1 || i3 == 0){
                    Integer integer = timeTableDao.updateByLateWednesday(timeTables.getClassToClass(), timeTables.getStuCode());
                    return new Result(Code.UPDATE_OK,"迟到了!请向负责人说明理由!");
                }else{
                    return new Result(Code.UPDATE_ERR,"请在正确的时间点签到!!");
                }
            } else if (dayOfWeek.name().toLowerCase().equals("thursday")) {
                if (i1 == 0 || i1 == 1 && i2 == -1 || i2 == 0) {
                    Integer integer = timeTableDao.updateByThursday(timeTables.getClassToClass(), timeTables.getStuCode());
                    return new Result(Code.UPDATE_OK,"签到成功!!");
                }else if(i2 == 0 || i2 == 1 && i3 == -1 || i3 == 0){
                    Integer integer = timeTableDao.updateByLateThursday(timeTables.getClassToClass(), timeTables.getStuCode());
                    return new Result(Code.UPDATE_OK,"迟到了!请向负责人说明理由!");
                }else{
                    return new Result(Code.UPDATE_ERR,"请在正确的时间点签到!!");
                }
            } else if (dayOfWeek.name().toLowerCase().equals("friday")) {
                if (i1 == 0 || i1 == 1 && i2 == -1 || i2 == 0) {
                    Integer integer = timeTableDao.updateByFriday(timeTables.getClassToClass(), timeTables.getStuCode());
                    return new Result(Code.UPDATE_OK,"签到成功!!");
                }else if(i2 == 0 || i2 == 1 && i3 == -1 || i3 == 0){
                    Integer integer = timeTableDao.updateByLateFriday(timeTables.getClassToClass(), timeTables.getStuCode());
                    return new Result(Code.UPDATE_OK,"迟到了!请向负责人说明理由!");
                }else{
                    return new Result(Code.UPDATE_ERR,"请在正确的时间点签到!!");
                }
            }else {
                return null;
            }
        }else{
            return new Result(Code.UPDATE_ERR,"请在正确的时间点签到!!");
        }

    }


}
