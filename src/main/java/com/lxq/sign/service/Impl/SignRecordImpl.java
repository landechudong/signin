package com.lxq.sign.service.Impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lxq.sign.controller.Code;
import com.lxq.sign.controller.Result;
import com.lxq.sign.dao.SignRecordDao;
import com.lxq.sign.domain.CelWeek;
import com.lxq.sign.domain.SignRecord;
import com.lxq.sign.service.SignRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SuppressWarnings({"all"})
@Service
public class SignRecordImpl implements SignRecordService {

    @Autowired
    SignRecordDao signRecordDao;

    @Scheduled(cron = "0 0 6 * * *")
    public void changeTime(){
        Integer integer = signRecordDao.updateNowTime();
    }

    @Override
    public Result addSignInf(String stuName) {


        if(!stuName.equals("null")) {
            LocalDateTime now = LocalDateTime.now();
            SignRecord signRecord = new SignRecord(null, stuName, now);
            int insert = signRecordDao.insert(signRecord);

            return new Result(insert == 0 ? Code.INSERT_ERR : Code.INSERT_OK, null);
        }else {
            return null;
        }
    }

    @Override
    public Result getSignInf(Integer page) {
        IPage ipage = new Page(page,8);
        signRecordDao.selectPage(ipage, null);
        return new Result(ipage != null ? Code.GET_OK:Code.GET_ERR,ipage);

    }

    @Override
    public Result delSignInf() {
        int delete = signRecordDao.deleteLoginRecord();
        return new Result(delete == 0 ? Code.DELETE_ERR:Code.DELETE_OK,null);
    }

    @Override
    @Scheduled(cron = "0 30 6 * * *")
    public Result loginInf() {

        CelWeek celWeek = signRecordDao.getCelWeek();

        LocalDate plusDays = celWeek.getOriginalTime().plusDays(7);
        int i = plusDays.compareTo(celWeek.getChangeTime());
        System.out.println(celWeek.getChangeTime());
        System.out.println(celWeek.getOriginalTime());
        System.out.println(plusDays);
        System.out.println(i);
        if(plusDays.compareTo(celWeek.getChangeTime()) <= 0){
            Integer integer1 = signRecordDao.updateOriginalTime();
            signRecordDao.updateWeek(celWeek.getWeek()+1);
            signRecordDao.deleteLoginRecord();
            signRecordDao.deleteTimeTable();
            signRecordDao.deleteLateRecord();
        }

        return null;
    }
}
