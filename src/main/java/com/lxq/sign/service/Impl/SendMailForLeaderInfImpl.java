package com.lxq.sign.service.Impl;

import com.lxq.sign.dao.StudentDao;
import com.lxq.sign.dao.TimeTableDao;
import com.lxq.sign.domain.LateRecord;
import com.lxq.sign.service.SendMailForLeaderInfService;
import com.lxq.sign.service.util.MailUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.LinkedList;

@SuppressWarnings({"all"})


@Service
public class SendMailForLeaderInfImpl implements SendMailForLeaderInfService {

    @Autowired
    TimeTableDao timeTableDao;
    @Autowired
    StudentDao studentDao;

    @Override
    @Scheduled(cron = "50 9 17 * * *")
    public Boolean sendMailForLeader() {

        LocalDateTime now = LocalDateTime.now();
        DayOfWeek dayOfWeek = now.getDayOfWeek();
        String name = dayOfWeek.name();

        LinkedList<LateRecord> lateRecords = new LinkedList<>();

        if(name.equals("MONDAY")){
            lateRecords  = timeTableDao.selectLateOnMonday();
            for (LateRecord tables : lateRecords) {
                String s = studentDao.selectNameByCode(tables.getStuCode());
                tables.setStuName(s);
            }
            String text = "";
            String stuname = "";
            for (LateRecord lateRecord :lateRecords) {
                String condition = "";
                if(lateRecord.getMonday() == 0 || lateRecord.getMonday() == 4){
                    condition = "未签";
                }else{
                    condition = "迟到";
                }

                if(stuname.equals("")) {
                    stuname = lateRecord.getStuName();
                    text += stuname + "(" + lateRecord.getClassToClass() + ")" + condition;
                }else if(stuname.equals(lateRecord.getStuName())){
                    text += " " + "(" + lateRecord.getClassToClass() + ")" + condition;
                }else{
                    stuname = lateRecord.getStuName();
                    text += "     " + stuname + "(" + lateRecord.getClassToClass() + ")" + condition;
                }

            }
            System.out.println(text);
            if(!text.equals("")){
                MailUtils.sendMail("1648025985@qq.com",text,"签到情况");
            }
            return true;

        }
        else if(name.equals("TUESDAY")){
            lateRecords = timeTableDao.selectLateOnTuesday();
            for (LateRecord tables : lateRecords) {
                String s = studentDao.selectNameByCode(tables.getStuCode());
                tables.setStuName(s);
            }
            String text = "";
            String stuname = "";
            for (LateRecord lateRecord :lateRecords) {
                String condition = "";
                if(lateRecord.getTuesday() == 0 || lateRecord.getTuesday() == 4){
                    condition = "未签";
                }else{
                    condition = "迟到";
                }

                if(stuname.equals("")) {
                    stuname = lateRecord.getStuName();
                    text += stuname + "(" + lateRecord.getClassToClass() + ")" + condition;
                }else if(stuname.equals(lateRecord.getStuName())){
                    text += " " + "(" + lateRecord.getClassToClass() + ")" + condition;
                }else{
                    stuname = lateRecord.getStuName();
                    text += "     " + stuname + "(" + lateRecord.getClassToClass() + ")" + condition;
                }

            }
            System.out.println(text);
            if(!text.equals("")){
                MailUtils.sendMail("1648025985@qq.com",text,"签到情况");
            }
            return true;
        }
        else if(name.equals("WEDNESDAY")){
            lateRecords = timeTableDao.selectLateOnWednesday();
            for (LateRecord tables : lateRecords) {
                String s = studentDao.selectNameByCode(tables.getStuCode());
                tables.setStuName(s);
            }
            String text = "";
            String stuname = "";
            for (LateRecord lateRecord :lateRecords) {
                String condition = "";
                if(lateRecord.getWednesday() == 0 || lateRecord.getWednesday() == 4){
                    condition = "未签";
                }else{
                    condition = "迟到";
                }

                if(stuname.equals("")) {
                    stuname = lateRecord.getStuName();
                    text += stuname + "(" + lateRecord.getClassToClass() + ")" + condition;
                }else if(stuname.equals(lateRecord.getStuName())){
                    text += " " + "(" + lateRecord.getClassToClass() + ")" + condition;
                }else{
                    stuname = lateRecord.getStuName();
                    text += "     " + stuname + "(" + lateRecord.getClassToClass() + ")" + condition;
                }

            }
            System.out.println(text);
            if(!text.equals("")){
                MailUtils.sendMail("1648025985@qq.com",text,"签到情况");
            }
            return true;
        }
        else if(name.equals("THURSDAY")){
            lateRecords = timeTableDao.selectLateOnThursday();
            for (LateRecord tables : lateRecords) {
                String s = studentDao.selectNameByCode(tables.getStuCode());
                tables.setStuName(s);
            }
            String text = "";
            String stuname = "";
            for (LateRecord lateRecord :lateRecords) {
                String condition = "";
                if(lateRecord.getThursday() == 0 || lateRecord.getThursday() == 4){
                    condition = "未签";
                }else{
                    condition = "迟到";
                }

                if(stuname.equals("")) {
                    stuname = lateRecord.getStuName();
                    text += stuname + "(" + lateRecord.getClassToClass() + ")" + condition;
                }else if(stuname.equals(lateRecord.getStuName())){
                    text += " " + "(" + lateRecord.getClassToClass() + ")" + condition;
                }else{
                    stuname = lateRecord.getStuName();
                    text += "     " + stuname + "(" + lateRecord.getClassToClass() + ")" + condition;
                }

            }
            System.out.println(text);
            if(!text.equals("")){
                MailUtils.sendMail("1648025985@qq.com",text,"签到情况");
            }
            return true;
        }
        else if(name.equals("FRIDAY")){
            lateRecords = timeTableDao.selectLateOnFriday();
            for (LateRecord tables : lateRecords) {
                String s = studentDao.selectNameByCode(tables.getStuCode());
                tables.setStuName(s);
            }
            String text = "";
            String stuname = "";
            for (LateRecord lateRecord :lateRecords) {
                String condition = "";
                if(lateRecord.getFriday() == 0 || lateRecord.getFriday() == 4){
                    condition = "未签";
                }else{
                    condition = "迟到";
                }

                if(stuname.equals("")) {
                    stuname = lateRecord.getStuName();
                    text += stuname + "(" + lateRecord.getClassToClass() + ")" + condition;
                }else if(stuname.equals(lateRecord.getStuName())){
                    text += " " + "(" + lateRecord.getClassToClass() + ")" + condition;
                }else{
                    stuname = lateRecord.getStuName();
                    text += "     " + stuname + "(" + lateRecord.getClassToClass() + ")" + condition;
                }

            }
            System.out.println(text);
            if(!text.equals("")){
                MailUtils.sendMail("1648025985@qq.com",text,"签到情况");
            }

            return true;
        }else{
            return true;
        }


    }
}
