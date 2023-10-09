package com.lxq.sign.service.Impl;

import com.lxq.sign.controller.Code;
import com.lxq.sign.controller.Result;
import com.lxq.sign.dao.LateOneDao;
import com.lxq.sign.dao.StudentDao;
import com.lxq.sign.dao.TimeTableDao;
import com.lxq.sign.domain.LateOneRecord;
import com.lxq.sign.domain.LateRecord;
import com.lxq.sign.service.LateRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.LinkedList;

@SuppressWarnings({"all"})
@Service
public class LateRecordImpl implements LateRecordService {

    @Autowired
    TimeTableDao timeTableDao;

    @Autowired
    LateOneDao lateOneDao;

    @Autowired
    StudentDao studentDao;


    @Override
    public Result getLateRecord() {
        LocalDateTime now = LocalDateTime.now();
        DayOfWeek dayOfWeek = now.getDayOfWeek();
        String dayWeek = dayOfWeek.name();


        if(dayWeek.equals("MONDAY")){
            LinkedList<LateRecord> lateRecords = timeTableDao.selectLateOnMonday();
            for (LateRecord lateRecord : lateRecords) {

                if(lateRecord.getMonday() != null){
                    if(lateRecord.getMonday() == 0){
                        lateRecord.setConditions("未签");
                    }else{
                        lateRecord.setConditions("迟到");
                    }
                }
                else if(lateRecord.getTuesday() != null){
                    if(lateRecord.getTuesday() == 0){
                        lateRecord.setConditions("未签");
                    }else{
                        lateRecord.setConditions("迟到");
                    }
                }
                else if(lateRecord.getWednesday() != null){
                    if(lateRecord.getWednesday() == 0){
                        lateRecord.setConditions("未签");
                    }else{
                        lateRecord.setConditions("迟到");
                    }
                }
                else if(lateRecord.getThursday() != null){
                    if(lateRecord.getThursday() == 0){
                        lateRecord.setConditions("未签");
                    }else{
                        lateRecord.setConditions("迟到");
                    }
                }
                else if(lateRecord.getFriday() != null){
                    if(lateRecord.getFriday() == 0){
                        lateRecord.setConditions("未签");
                    }else{
                        lateRecord.setConditions("迟到");
                    }
                }

                String stuName = studentDao.selectNameByCode(lateRecord.getStuCode());
                lateRecord.setStuName(stuName);
            }
            return new Result(lateRecords.size() == 0 ? Code.GET_ERR:Code.GET_OK,lateRecords);
        }else if(dayWeek.equals("TUESDAY")){
            LinkedList<LateRecord> lateRecords = timeTableDao.selectLateOnTuesday();
            for (LateRecord lateRecord : lateRecords) {
                if(lateRecord.getMonday() != null){
                    if(lateRecord.getMonday() == 0){
                        lateRecord.setConditions("未签");
                    }else{
                        lateRecord.setConditions("迟到");
                    }
                }
                else if(lateRecord.getTuesday() != null){
                    if(lateRecord.getTuesday() == 0){
                        lateRecord.setConditions("未签");
                    }else{
                        lateRecord.setConditions("迟到");
                    }
                }
                else if(lateRecord.getWednesday() != null){
                    if(lateRecord.getWednesday() == 0){
                        lateRecord.setConditions("未签");
                    }else{
                        lateRecord.setConditions("迟到");
                    }
                }
                else if(lateRecord.getThursday() != null){
                    if(lateRecord.getThursday() == 0){
                        lateRecord.setConditions("未签");
                    }else{
                        lateRecord.setConditions("迟到");
                    }
                }
                else if(lateRecord.getFriday() != null){
                    if(lateRecord.getFriday() == 0){
                        lateRecord.setConditions("未签");
                    }else{
                        lateRecord.setConditions("迟到");
                    }
                }

                String stuName = studentDao.selectNameByCode(lateRecord.getStuCode());
                lateRecord.setStuName(stuName);
            }
            return new Result(lateRecords.size() == 0 ? Code.GET_ERR:Code.GET_OK,lateRecords);
        }else if(dayWeek.equals("WEDNESDAY")){
            LinkedList<LateRecord> lateRecords = timeTableDao.selectLateOnWednesday();
            for (LateRecord lateRecord : lateRecords) {
                if(lateRecord.getMonday() != null){
                    if(lateRecord.getMonday() == 0){
                        lateRecord.setConditions("未签");
                    }else{
                        lateRecord.setConditions("迟到");
                    }
                }
                else if(lateRecord.getTuesday() != null){
                    if(lateRecord.getTuesday() == 0){
                        lateRecord.setConditions("未签");
                    }else{
                        lateRecord.setConditions("迟到");
                    }
                }
                else if(lateRecord.getWednesday() != null){
                    if(lateRecord.getWednesday() == 0){
                        lateRecord.setConditions("未签");
                    }else{
                        lateRecord.setConditions("迟到");
                    }
                }
                else if(lateRecord.getThursday() != null){
                    if(lateRecord.getThursday() == 0){
                        lateRecord.setConditions("未签");
                    }else{
                        lateRecord.setConditions("迟到");
                    }
                }
                else if(lateRecord.getFriday() != null){
                    if(lateRecord.getFriday() == 0){
                        lateRecord.setConditions("未签");
                    }else{
                        lateRecord.setConditions("迟到");
                    }
                }
                String stuName = studentDao.selectNameByCode(lateRecord.getStuCode());
                lateRecord.setStuName(stuName);
            }
            return new Result(lateRecords.size() == 0 ? Code.GET_ERR:Code.GET_OK,lateRecords);
        }else if(dayWeek.equals("THURSDAY")){
            LinkedList<LateRecord> lateRecords = timeTableDao.selectLateOnThursday();
            for (LateRecord lateRecord : lateRecords) {
                if(lateRecord.getMonday() != null){
                    if(lateRecord.getMonday() == 0){
                        lateRecord.setConditions("未签");
                    }else{
                        lateRecord.setConditions("迟到");
                    }
                }
                else if(lateRecord.getTuesday() != null){
                    if(lateRecord.getTuesday() == 0){
                        lateRecord.setConditions("未签");
                    }else{
                        lateRecord.setConditions("迟到");
                    }
                }
                else if(lateRecord.getWednesday() != null){
                    if(lateRecord.getWednesday() == 0){
                        lateRecord.setConditions("未签");
                    }else{
                        lateRecord.setConditions("迟到");
                    }
                }
                else if(lateRecord.getThursday() != null){
                    if(lateRecord.getThursday() == 0){
                        lateRecord.setConditions("未签");
                    }else{
                        lateRecord.setConditions("迟到");
                    }
                }
                else if(lateRecord.getFriday() != null){
                    if(lateRecord.getFriday() == 0){
                        lateRecord.setConditions("未签");
                    }else{
                        lateRecord.setConditions("迟到");
                    }
                }
                String stuName = studentDao.selectNameByCode(lateRecord.getStuCode());
                lateRecord.setStuName(stuName);
            }
            return new Result(lateRecords.size() == 0 ? Code.GET_ERR:Code.GET_OK,lateRecords);
        }else if(dayWeek.equals("FRIDAY")){
            LinkedList<LateRecord> lateRecords = timeTableDao.selectLateOnFriday();
            for (LateRecord lateRecord : lateRecords) {
                if(lateRecord.getMonday() != null){
                    if(lateRecord.getMonday() == 0){
                        lateRecord.setConditions("未签");
                    }else{
                        lateRecord.setConditions("迟到");
                    }
                }
                else if(lateRecord.getTuesday() != null){
                    if(lateRecord.getTuesday() == 0){
                        lateRecord.setConditions("未签");
                    }else{
                        lateRecord.setConditions("迟到");
                    }
                }
                else if(lateRecord.getWednesday() != null){
                    if(lateRecord.getWednesday() == 0){
                        lateRecord.setConditions("未签");
                    }else{
                        lateRecord.setConditions("迟到");
                    }
                }
                else if(lateRecord.getThursday() != null){
                    if(lateRecord.getThursday() == 0){
                        lateRecord.setConditions("未签");
                    }else{
                        lateRecord.setConditions("迟到");
                    }
                }
                else if(lateRecord.getFriday() != null){
                    if(lateRecord.getFriday() == 0){
                        lateRecord.setConditions("未签");
                    }else{
                        lateRecord.setConditions("迟到");
                    }
                }
                String stuName = studentDao.selectNameByCode(lateRecord.getStuCode());
                lateRecord.setStuName(stuName);
            }
            return new Result(lateRecords.size() == 0 ? Code.GET_ERR:Code.GET_OK,lateRecords);
        }else {
            return new Result(0,null);
        }
    }

    @Override
    public Result addLateInf(LateOneRecord lateOneRecord) {

        LocalDateTime now = LocalDateTime.now();
        DayOfWeek dayOfWeek = now.getDayOfWeek();
        String dayWeek = dayOfWeek.name();
        if(dayWeek.equals("MONDAY")){
            lateOneRecord.setDayWeek("周一");
            Integer integer = timeTableDao.updateMonday(lateOneRecord.getStuCode(), lateOneRecord.getClassToClass(), dayWeek.toLowerCase());
        }else if(dayWeek.equals("TUESDAY")){
            lateOneRecord.setDayWeek("周二");
            Integer integer = timeTableDao.updateTuesday(lateOneRecord.getStuCode(), lateOneRecord.getClassToClass(), dayWeek.toLowerCase());
        }else if(dayWeek.equals("WEDNESDAY")){
            lateOneRecord.setDayWeek("周三");
            Integer integer = timeTableDao.updateWednesday(lateOneRecord.getStuCode(), lateOneRecord.getClassToClass(), dayWeek.toLowerCase());
        }else if(dayWeek.equals("THURSDAY")){
            lateOneRecord.setDayWeek("周四");
            Integer integer = timeTableDao.updateThursday(lateOneRecord.getStuCode(), lateOneRecord.getClassToClass(), dayWeek.toLowerCase());
        }else if(dayWeek.equals("FRIDAY")){
            lateOneRecord.setDayWeek("周五");
            Integer integer = timeTableDao.updateFriday(lateOneRecord.getStuCode(), lateOneRecord.getClassToClass(), dayWeek.toLowerCase());
        }

        Integer integer = studentDao.selectLateTime(lateOneRecord.getStuName(), lateOneRecord.getStuCode());
        studentDao.addLateTime(lateOneRecord.getStuName(),lateOneRecord.getStuCode(),integer+1);

        int insert = lateOneDao.insert(lateOneRecord);
        return new Result(insert != 0 ?Code.INSERT_OK:Code.INSERT_ERR,"已警告学生!");
    }

    @Override
    public Result getOneLateRecord(String stuCode) {
        LinkedList<LateOneRecord> lateOneRecords = lateOneDao.selectByCode(stuCode);
        return new Result(lateOneRecords.size() != 0 ? Code.GET_OK:Code.GET_ERR,lateOneRecords);
    }

}
