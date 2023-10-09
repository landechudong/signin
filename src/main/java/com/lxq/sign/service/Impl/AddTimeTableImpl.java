package com.lxq.sign.service.Impl;

import com.lxq.sign.controller.Code;
import com.lxq.sign.controller.Result;
import com.lxq.sign.dao.AddStuByPictureDao;
import com.lxq.sign.dao.TimeTableDao;
import com.lxq.sign.domain.TimeTable;
import com.lxq.sign.domain.TimeTables;
import com.lxq.sign.service.AddTimeTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;

@SuppressWarnings({"all"})
@Service
public class AddTimeTableImpl implements AddTimeTableService {

    @Autowired
    AddStuByPictureDao addStuByPictureDao;

    @Autowired
    TimeTableDao timeTableDao;

    public static Integer week = 0;
    public static String stuCode = "";

    @Override
    public Result getTimeTable(String code) {

        if(code != null) {

            LinkedList<TimeTable> firstClass = addStuByPictureDao.getTable("1-2", code);
            LinkedList<TimeTable> secondClass = addStuByPictureDao.getTable("3-4", code);
            LinkedList<TimeTable> thirdClass = addStuByPictureDao.getTable("5-6", code);
            LinkedList<TimeTable> fourthClass = addStuByPictureDao.getTable("7-8", code);
            LinkedList<TimeTable> fifthClass = addStuByPictureDao.getTable("9-10", code);

            Integer weeks = addStuByPictureDao.getWeek();

            Integer integer = timeTableDao.selectCount(null);

            System.out.println("现在第几周" + weeks);
            System.out.println("之前第几周" + week);
            System.out.println(code);
            System.out.println(stuCode);
            if (weeks != week || !(code.equals(stuCode)) || integer == 0) {
                if (weeks != week) {
                    timeTableDao.deleteTable(code);
                    week = addStuByPictureDao.getWeek();
                }

                stuCode = code;

                LinkedList<Integer> lineClass1 = new LinkedList<Integer>();
                LinkedList<Integer> lineClass2 = new LinkedList<Integer>();
                LinkedList<Integer> lineClass3 = new LinkedList<Integer>();
                LinkedList<Integer> lineClass4 = new LinkedList<Integer>();
                LinkedList<Integer> lineClass5 = new LinkedList<Integer>();

                for (TimeTable timeTable : firstClass) {
                    System.out.println(timeTable + ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                }


                for (TimeTable classMessages : firstClass) {
                    if (classMessages.getIsSingle().equals("全") && week >= classMessages.getStartWeek() && week <= classMessages.getEndWeek()) {
                        lineClass1.add(1);
                    } else if (classMessages.getIsSingle().equals("单") && week >= classMessages.getStartWeek() && week <= classMessages.getEndWeek()) {
                        lineClass1.add(1);
                    } else if (classMessages.getIsSingle().equals("双") && week % 2 == 0 && week >= classMessages.getStartWeek() && week <= classMessages.getEndWeek()) {
                        lineClass1.add(1);
                    } else {
                        lineClass1.add(0);
                    }
                }
                for (TimeTable classMessages : secondClass) {
                    if (classMessages.getIsSingle().equals("全") && week >= classMessages.getStartWeek() && week <= classMessages.getEndWeek()) {
                        lineClass2.add(1);
                    } else if (classMessages.getIsSingle().equals("单") && week >= classMessages.getStartWeek() && week <= classMessages.getEndWeek()) {
                        lineClass2.add(1);
                    } else if (classMessages.getIsSingle().equals("双") && week % 2 == 0 && week >= classMessages.getStartWeek() && week <= classMessages.getEndWeek()) {
                        lineClass2.add(1);
                    } else {
                        lineClass2.add(0);
                    }
                }
                for (TimeTable classMessages : thirdClass) {
                    if (classMessages.getIsSingle().equals("全") && week >= classMessages.getStartWeek() && week <= classMessages.getEndWeek()) {
                        lineClass3.add(1);
                    } else if (classMessages.getIsSingle().equals("单") && week >= classMessages.getStartWeek() && week <= classMessages.getEndWeek()) {
                        lineClass3.add(1);
                    } else if (classMessages.getIsSingle().equals("双") && week % 2 == 0 && week >= classMessages.getStartWeek() && week <= classMessages.getEndWeek()) {
                        lineClass3.add(1);
                    } else {
                        lineClass3.add(0);
                    }
                }
                for (TimeTable classMessages : fourthClass) {
                    if (classMessages.getIsSingle().equals("全") && week >= classMessages.getStartWeek() && week <= classMessages.getEndWeek()) {
                        lineClass4.add(1);
                    } else if (classMessages.getIsSingle().equals("单") && week >= classMessages.getStartWeek() && week <= classMessages.getEndWeek()) {
                        lineClass4.add(1);
                    } else if (classMessages.getIsSingle().equals("双") && week % 2 == 0 && week >= classMessages.getStartWeek() && week <= classMessages.getEndWeek()) {
                        lineClass4.add(1);
                    } else {
                        lineClass4.add(0);
                    }
                }
                for (TimeTable classMessages : fifthClass) {
                    if (classMessages.getIsSingle().equals("全") && week >= classMessages.getStartWeek() && week <= classMessages.getEndWeek()) {
                        lineClass5.add(1);
                    } else if (classMessages.getIsSingle().equals("单") && week >= classMessages.getStartWeek() && week <= classMessages.getEndWeek()) {
                        lineClass5.add(1);
                    } else if (classMessages.getIsSingle().equals("双") && week % 2 == 0 && week >= classMessages.getStartWeek() && week <= classMessages.getEndWeek()) {
                        lineClass5.add(1);
                    } else {
                        lineClass5.add(0);
                    }
                }

                for (int i = 0; i < lineClass1.size(); i++) {
                    if (lineClass1.get(i) == 0) {
                        if (lineClass2.get(i) == 0) {
                            lineClass2.set(i, 1);
                        }
                    }
                }

                for (int i = 0; i < lineClass3.size(); i++) {
                    if (lineClass3.get(i) == 0) {
                        if (lineClass4.get(i) == 0) {
                            lineClass4.set(i, 1);
                            if (lineClass5.get(i) == 0) {
                                lineClass5.set(i, 1);
                            }
                        }
                    }
                }

                for (int i = 0; i < lineClass4.size(); i++) {
                    if (lineClass4.get(i) == 0) {
                        if (lineClass5.get(i) == 0) {
                            lineClass5.set(i, 1);
                        }
                    }
                }



                TimeTables timeTables1 = new TimeTables();
                change(timeTables1, lineClass1, code, "1-2");

                TimeTables timeTables2 = new TimeTables();
                change(timeTables2, lineClass2, code, "3-4");

                TimeTables timeTables3 = new TimeTables();
                change(timeTables3, lineClass3, code, "5-6");

                TimeTables timeTables4 = new TimeTables();
                change(timeTables4, lineClass4, code, "7-8");

                TimeTables timeTables5 = new TimeTables();
                change(timeTables5, lineClass5, code, "9-10");


                timeTableDao.insert(timeTables1);
                timeTableDao.insert(timeTables2);
                timeTableDao.insert(timeTables3);
                timeTableDao.insert(timeTables4);
                timeTableDao.insert(timeTables5);

                return new Result(Code.INSERT_OK, "加入成功!");
            } else {
                return new Result(Code.INSERT_ERR, "不需要添加");
            }
        }else {
            return null;
        }
    }

    public void change(TimeTables timeTables,LinkedList<Integer> linkedList,String code,String classToClass){
        timeTables.setStuCode(code);
        timeTables.setClassToClass(classToClass);
        timeTables.setMonday(linkedList.get(0));
        timeTables.setTuesday(linkedList.get(1));
        timeTables.setWednesday(linkedList.get(2));
        timeTables.setThursday(linkedList.get(3));
        timeTables.setFriday(linkedList.get(4));
    }
}
