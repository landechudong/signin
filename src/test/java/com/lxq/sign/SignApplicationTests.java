package com.lxq.sign;

import com.lxq.sign.controller.Result;
import com.lxq.sign.dao.*;

import com.lxq.sign.domain.ClassMessages;
import com.lxq.sign.domain.TimeTable;
import com.lxq.sign.service.AddStuByPictureService;
import com.lxq.sign.service.AddTimeTableService;
import com.lxq.sign.service.Impl.SignRecordImpl;
import com.lxq.sign.service.ShowStuListService;
import com.lxq.sign.service.ShowTimeService;
import com.lxq.sign.service.getInformation.IdentifyPictureInf;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.LinkedList;

@SpringBootTest
class SignApplicationTests {

    @Autowired
    TimeDao timeDao;
    @Autowired
    AddStuByPictureService addStuByPictureService;

    @Autowired
    AddTimeTableService showTimeTableService;

    @Autowired
    IdentifyPictureInf identifyPictureInf;

    @Autowired
    ShowTimeService showTimeService;
    @Autowired
    TimeTableDao timeTableDao;
    @Autowired
    LateOneDao lateOneDao;
    @Autowired
    StudentDao studentDao;

    @Autowired
    SignRecordDao loginRecordDao;
    @Autowired
    LoginBrowserDao loginBrowserDao;
    @Autowired
    SignRecordImpl loginRecord;
    @Autowired
    AddStuByPictureDao addStuByPictureDao;
    @Autowired
    ShowStuListService showStuListService;
    @Test
    void contextLoads() {
//        Result result = showTimeService.UpdateTimeBySections(new TrueTime("1-2", "07:40:00", "08:00:00", "08:20:00"));
//        System.out.println(result);
//        identifyPictureInf.getInformation("D:\\Picture\\2.jpg");
//        Time timeBySection = timeDao.getTimeBySection("1-2");
//        System.out.println(timeBySection);
//        LocalTime of = LocalTime.of(timeBySection.getStartTime().getHour(), timeBySection.getStartTime().getMinute());
//        LocalDateTime now = LocalDateTime.now();
//        LocalTime of1 = LocalTime.of(now.getHour(), now.getMinute());
//
//        int i = of1.compareTo(of);
//        System.out.println(i + " 6666666");
//
//        System.out.println(timeBySection.getStartTime().getHour());
//        System.out.println(timeBySection.getStartTime().getMinute());

//        LateOneRecord lateOneRecord = new LateOneRecord();
//        lateOneRecord.setConditions(">>");
//        lateOneRecord.setStuCode("456");
//        lateOneRecord.setStuName("llx");
//        lateOneDao.insert(lateOneRecord);
//        loginRecordDao.updateNowTime();
//        LoginBrowser loginBrowser = loginBrowserDao.selectStuCode("123");
//        loginRecord.delLoginInf();

//        LinkedList<TimeTable> tableInf = addStuByPictureDao.getTableInf("2022105380127");
//        for (TimeTable classMessages : tableInf) {
//            System.out.println(classMessages);
//        }
        new SignApplication();



    }
}
