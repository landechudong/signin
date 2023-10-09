package com.lxq.sign.service.Impl;

import com.lxq.sign.controller.Code;
import com.lxq.sign.controller.Result;
import com.lxq.sign.dao.AddStuByPictureDao;
import com.lxq.sign.dao.StudentDao;
import com.lxq.sign.domain.*;
import com.lxq.sign.service.AddStuByPictureService;
import com.lxq.sign.service.AddTimeTableService;
import com.lxq.sign.service.getInformation.IdentifyPictureInf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@SuppressWarnings({"all"})
@Service
public class AddStuByPictureImpl implements AddStuByPictureService {


    @Autowired
    AddStuByPictureDao addStuByPictureDao;
    @Autowired
    StudentDao studentDao;

    AddTimeTableService showTimeTableService;

    public static LinkedList<ClassMessages> allClassMessages = new LinkedList<ClassMessages>();
    public static LinkedList<UpdateStudentInf> allUpdateStudentInf = new LinkedList<UpdateStudentInf>();
    public static List<StudentInf> stuList;

    @Override
    public Result getInf(String path) {

        allUpdateStudentInf.clear();

        IdentifyPictureInf identifyPictureInf = new IdentifyPictureInf();
        identifyPictureInf.getInformation(path);

        TimeTables dayClass = new TimeTables();

        UpdateStudentInf updateStudentInf;

        String monday = "";
        String tuesday = "";
        String wednesday = "";
        String thursday = "";
        String friday = "";

        for (MainMessages mainMessages : IdentifyPictureInf.classList) {
            if (mainMessages.getClassToClass().equals("1-2")) {

                if (mainMessages.getDayOfWeek().equals("周一")) {
                    monday = mainMessages.getIsSingle() + "(" + mainMessages.getWeekToWeek() + ")" + mainMessages.getDayOfWeek();
                } else if (mainMessages.getDayOfWeek().equals("周二")) {
                    tuesday = mainMessages.getIsSingle() + "(" + mainMessages.getWeekToWeek() + ")" + mainMessages.getDayOfWeek();
                } else if (mainMessages.getDayOfWeek().equals("周三")) {
                    wednesday = mainMessages.getIsSingle() + "(" + mainMessages.getWeekToWeek() + ")" + mainMessages.getDayOfWeek();
                } else if (mainMessages.getDayOfWeek().equals("周四")) {
                    thursday = mainMessages.getIsSingle() + "(" + mainMessages.getWeekToWeek() + ")" + mainMessages.getDayOfWeek();
                } else if (mainMessages.getDayOfWeek().equals("周五")) {
                    friday = mainMessages.getIsSingle() + "(" + mainMessages.getWeekToWeek() + ")" + mainMessages.getDayOfWeek();
                }
            } else if (mainMessages.getClassToClass().equals("3-4")) {

                if (mainMessages.getDayOfWeek().equals("周一")) {
                    monday = mainMessages.getIsSingle() + "(" + mainMessages.getWeekToWeek() + ")" + mainMessages.getDayOfWeek();
                } else if (mainMessages.getDayOfWeek().equals("周二")) {
                    tuesday = mainMessages.getIsSingle() + "(" + mainMessages.getWeekToWeek() + ")" + mainMessages.getDayOfWeek();
                } else if (mainMessages.getDayOfWeek().equals("周三")) {
                    wednesday = mainMessages.getIsSingle() + "(" + mainMessages.getWeekToWeek() + ")" + mainMessages.getDayOfWeek();
                } else if (mainMessages.getDayOfWeek().equals("周四")) {
                    thursday = mainMessages.getIsSingle() + "(" + mainMessages.getWeekToWeek() + ")" + mainMessages.getDayOfWeek();
                } else if (mainMessages.getDayOfWeek().equals("周五")) {
                    friday = mainMessages.getIsSingle() + "(" + mainMessages.getWeekToWeek() + ")" + mainMessages.getDayOfWeek();
                }
            } else if (mainMessages.getClassToClass().equals("5-6")) {

                if (mainMessages.getDayOfWeek().equals("周一")) {
                    monday = mainMessages.getIsSingle() + "(" + mainMessages.getWeekToWeek() + ")" + mainMessages.getDayOfWeek();
                } else if (mainMessages.getDayOfWeek().equals("周二")) {
                    tuesday = mainMessages.getIsSingle() + "(" + mainMessages.getWeekToWeek() + ")" + mainMessages.getDayOfWeek();
                } else if (mainMessages.getDayOfWeek().equals("周三")) {
                    wednesday = mainMessages.getIsSingle() + "(" + mainMessages.getWeekToWeek() + ")" + mainMessages.getDayOfWeek();
                } else if (mainMessages.getDayOfWeek().equals("周四")) {
                    thursday = mainMessages.getIsSingle() + "(" + mainMessages.getWeekToWeek() + ")" + mainMessages.getDayOfWeek();
                } else if (mainMessages.getDayOfWeek().equals("周五")) {
                    friday = mainMessages.getIsSingle() + "(" + mainMessages.getWeekToWeek() + ")" + mainMessages.getDayOfWeek();
                }
            } else if (mainMessages.getClassToClass().equals("7-8")) {

                if (mainMessages.getDayOfWeek().equals("周一")) {
                    monday = mainMessages.getIsSingle() + "(" + mainMessages.getWeekToWeek() + ")" + mainMessages.getDayOfWeek();
                } else if (mainMessages.getDayOfWeek().equals("周二")) {
                    tuesday = mainMessages.getIsSingle() + "(" + mainMessages.getWeekToWeek() + ")" + mainMessages.getDayOfWeek();
                } else if (mainMessages.getDayOfWeek().equals("周三")) {
                    wednesday = mainMessages.getIsSingle() + "(" + mainMessages.getWeekToWeek() + ")" + mainMessages.getDayOfWeek();
                } else if (mainMessages.getDayOfWeek().equals("周四")) {
                    thursday = mainMessages.getIsSingle() + "(" + mainMessages.getWeekToWeek() + ")" + mainMessages.getDayOfWeek();
                } else if (mainMessages.getDayOfWeek().equals("周五")) {
                    friday = mainMessages.getIsSingle() + "(" + mainMessages.getWeekToWeek() + ")" + mainMessages.getDayOfWeek();
                }
            } else if (mainMessages.getClassToClass().equals("9-10")) {

                if (mainMessages.getDayOfWeek().equals("周一")) {
                    monday = mainMessages.getIsSingle() + "(" + mainMessages.getWeekToWeek() + ")" + mainMessages.getDayOfWeek();
                } else if (mainMessages.getDayOfWeek().equals("周二")) {
                    tuesday = mainMessages.getIsSingle() + "(" + mainMessages.getWeekToWeek() + ")" + mainMessages.getDayOfWeek();
                } else if (mainMessages.getDayOfWeek().equals("周三")) {
                    wednesday = mainMessages.getIsSingle() + "(" + mainMessages.getWeekToWeek() + ")" + mainMessages.getDayOfWeek();
                } else if (mainMessages.getDayOfWeek().equals("周四")) {
                    thursday = mainMessages.getIsSingle() + "(" + mainMessages.getWeekToWeek() + ")" + mainMessages.getDayOfWeek();
                } else if (mainMessages.getDayOfWeek().equals("周五")) {
                    friday = mainMessages.getIsSingle() + "(" + mainMessages.getWeekToWeek() + ")" + mainMessages.getDayOfWeek();
                }
            }

            if (monday != "" && tuesday != "" && wednesday != "" && thursday != "" && friday != "") {
                System.out.println(IdentifyPictureInf.stuList.get(0).getStuName());
                System.out.println(IdentifyPictureInf.stuList.get(0).getStuCode());
                updateStudentInf = new UpdateStudentInf(IdentifyPictureInf.stuList.get(0).getStuName(), IdentifyPictureInf.stuList.get(0).getStuCode(), mainMessages.getClassToClass(), monday, tuesday, wednesday, thursday, friday);
                allUpdateStudentInf.add(updateStudentInf);
                monday = "";
                tuesday = "";
                wednesday = "";
                thursday = "";
                friday = "";
            }
        }

        for (UpdateStudentInf studentInf : allUpdateStudentInf) {
            System.out.println(studentInf);
        }


        return new Result(Code.GET_OK, allUpdateStudentInf);

    }

    @Override
    public Result changeTable(UpdateStudentInf updateStudentInf) {
        return new Result(Code.GET_OK, updateStudentInf);
    }

    @Override
    public Result changeInf(UpdateStudentInf updateStudentInf) {

        if(updateStudentInf.getStuName().length() >= 5||updateStudentInf.getStuCode().length() != 13 || updateStudentInf.getMonday().length() >= 11 || updateStudentInf.getTuesday().length() >= 11 || updateStudentInf.getWednesday().length() >= 11 || updateStudentInf.getThursday().length() >= 11 || updateStudentInf.getFriday().length() >= 11 || !updateStudentInf.getMonday().contains("-") || !updateStudentInf.getTuesday().contains("-")|| !updateStudentInf.getWednesday().contains("-") || !updateStudentInf.getThursday().contains("-") || !updateStudentInf.getFriday().contains("-")){
            return new Result(Code.UPDATE_ERR,"请提交正确格式的信息");
        }else{
            for (int i = 0; i < allUpdateStudentInf.size(); i++) {
                if (allUpdateStudentInf.get(i).getClassToClass().equals(updateStudentInf.getClassToClass())) {
                    allUpdateStudentInf.get(i).setClassToClass(updateStudentInf.getClassToClass());
                    allUpdateStudentInf.get(i).setMonday(updateStudentInf.getMonday());
                    allUpdateStudentInf.get(i).setTuesday(updateStudentInf.getTuesday());
                    allUpdateStudentInf.get(i).setWednesday(updateStudentInf.getWednesday());
                    allUpdateStudentInf.get(i).setThursday(updateStudentInf.getThursday());
                    allUpdateStudentInf.get(i).setFriday(updateStudentInf.getFriday());

                    if (!(allUpdateStudentInf.get(i).getStuName().equals(updateStudentInf.getStuName()))) {
                        for (int j = 0; j < allUpdateStudentInf.size(); j++) {
                            allUpdateStudentInf.get(j).setStuName(updateStudentInf.getStuName());
                        }
                    }

                    if (!(allUpdateStudentInf.get(i).getStuCode().equals(updateStudentInf.getStuCode()))) {
                        for (int j = 0; j < allUpdateStudentInf.size(); j++) {
                            allUpdateStudentInf.get(j).setStuCode(updateStudentInf.getStuCode());
                        }
                    }


                }
            }
            return new Result(Code.UPDATE_OK, allUpdateStudentInf);
        }
    }

    @Override
    public Result addStuInf(LinkedList<UpdateStudentInf> updateStudentInfs) {

        allClassMessages.clear();

        ClassMessages classMessages;
        for (int i = 0; i < updateStudentInfs.size(); i++) {
            if (updateStudentInfs.get(i).getClassToClass().equals("1-2")) {
                String isSingle = "";
                Integer startWeek = 0;
                Integer endWeek = 0;
                String dayWeek = "";
                Integer dayNum = 0;

                //周一
                isSingle = updateStudentInfs.get(i).getMonday().substring(0, 1);
                startWeek = Integer.parseInt(updateStudentInfs.get(i).getMonday().substring(2, 3));

                if (updateStudentInfs.get(i).getMonday().length() == 9) {
                    endWeek = Integer.parseInt(updateStudentInfs.get(i).getMonday().substring(4, 6));
                    dayWeek = updateStudentInfs.get(i).getMonday().substring(7);
                    if (dayWeek.equals("周一")) {
                        dayNum = 1;
                    } else if (dayWeek.equals("周二")) {
                        dayNum = 2;
                    } else if (dayWeek.equals("周三")) {
                        dayNum = 3;
                    } else if (dayWeek.equals("周四")) {
                        dayNum = 4;
                    } else if (dayWeek.equals("周五")) {
                        dayNum = 5;
                    }
                }
                else if (updateStudentInfs.get(i).getMonday().length() == 8){
                    endWeek = Integer.parseInt(updateStudentInfs.get(i).getMonday().substring(4, 5));
                    dayWeek = updateStudentInfs.get(i).getMonday().substring(6);
                    if (dayWeek.equals("周一")) {
                        dayNum = 1;
                    } else if (dayWeek.equals("周二")) {
                        dayNum = 2;
                    } else if (dayWeek.equals("周三")) {
                        dayNum = 3;
                    } else if (dayWeek.equals("周四")) {
                        dayNum = 4;
                    } else if (dayWeek.equals("周五")) {
                        dayNum = 5;
                    }
                }
                else if(updateStudentInfs.get(i).getMonday().length() == 10){
                    System.out.println(updateStudentInfs.get(i).getMonday());
                    startWeek = Integer.parseInt(updateStudentInfs.get(i).getMonday().substring(2,4));
                    endWeek = Integer.parseInt(updateStudentInfs.get(i).getMonday().substring(5,7));
                    dayWeek = updateStudentInfs.get(i).getMonday().substring(8);
                    if (dayWeek.equals("周一")) {
                        dayNum = 1;
                    } else if (dayWeek.equals("周二")) {
                        dayNum = 2;
                    } else if (dayWeek.equals("周三")) {
                        dayNum = 3;
                    } else if (dayWeek.equals("周四")) {
                        dayNum = 4;
                    } else if (dayWeek.equals("周五")) {
                        dayNum = 5;
                    }
                }
                classMessages = new ClassMessages(updateStudentInfs.get(i).getStuCode(), dayWeek, isSingle, updateStudentInfs.get(i).getClassToClass(), startWeek, endWeek, dayNum);
                allClassMessages.add(classMessages);

                //周二
                isSingle = updateStudentInfs.get(i).getTuesday().substring(0, 1);
                startWeek = Integer.parseInt(updateStudentInfs.get(i).getTuesday().substring(2, 3));

                if (updateStudentInfs.get(i).getTuesday().length() == 9) {
                    endWeek = Integer.parseInt(updateStudentInfs.get(i).getTuesday().substring(4, 6));
                    dayWeek = updateStudentInfs.get(i).getTuesday().substring(7);
                    if (dayWeek.equals("周一")) {
                        dayNum = 1;
                    } else if (dayWeek.equals("周二")) {
                        dayNum = 2;
                    } else if (dayWeek.equals("周三")) {
                        dayNum = 3;
                    } else if (dayWeek.equals("周四")) {
                        dayNum = 4;
                    } else if (dayWeek.equals("周五")) {
                        dayNum = 5;
                    }
                } else if(updateStudentInfs.get(i).getTuesday().length() == 8){
                    endWeek = Integer.parseInt(updateStudentInfs.get(i).getTuesday().substring(4, 5));
                    dayWeek = updateStudentInfs.get(i).getTuesday().substring(6);
                    if (dayWeek.equals("周一")) {
                        dayNum = 1;
                    } else if (dayWeek.equals("周二")) {
                        dayNum = 2;
                    } else if (dayWeek.equals("周三")) {
                        dayNum = 3;
                    } else if (dayWeek.equals("周四")) {
                        dayNum = 4;
                    } else if (dayWeek.equals("周五")) {
                        dayNum = 5;
                    }
                }else if(updateStudentInfs.get(i).getTuesday().length() == 10){
                    System.out.println(updateStudentInfs.get(i).getTuesday());
                    startWeek = Integer.parseInt(updateStudentInfs.get(i).getTuesday().substring(2,4));
                    endWeek = Integer.parseInt(updateStudentInfs.get(i).getTuesday().substring(5,7));
                    dayWeek = updateStudentInfs.get(i).getTuesday().substring(8);
                    if (dayWeek.equals("周一")) {
                        dayNum = 1;
                    } else if (dayWeek.equals("周二")) {
                        dayNum = 2;
                    } else if (dayWeek.equals("周三")) {
                        dayNum = 3;
                    } else if (dayWeek.equals("周四")) {
                        dayNum = 4;
                    } else if (dayWeek.equals("周五")) {
                        dayNum = 5;
                    }
                }
                classMessages = new ClassMessages(updateStudentInfs.get(i).getStuCode(), dayWeek, isSingle, updateStudentInfs.get(i).getClassToClass(), startWeek, endWeek, dayNum);
                allClassMessages.add(classMessages);

                //周三
                isSingle = updateStudentInfs.get(i).getWednesday().substring(0, 1);
                startWeek = Integer.parseInt(updateStudentInfs.get(i).getWednesday().substring(2, 3));

                if (updateStudentInfs.get(i).getWednesday().length() == 9) {
                    endWeek = Integer.parseInt(updateStudentInfs.get(i).getWednesday().substring(4, 6));
                    dayWeek = updateStudentInfs.get(i).getWednesday().substring(7);
                    if (dayWeek.equals("周一")) {
                        dayNum = 1;
                    } else if (dayWeek.equals("周二")) {
                        dayNum = 2;
                    } else if (dayWeek.equals("周三")) {
                        dayNum = 3;
                    } else if (dayWeek.equals("周四")) {
                        dayNum = 4;
                    } else if (dayWeek.equals("周五")) {
                        dayNum = 5;
                    }
                } else if (updateStudentInfs.get(i).getWednesday().length() == 8){
                    endWeek = Integer.parseInt(updateStudentInfs.get(i).getWednesday().substring(4, 5));
                    dayWeek = updateStudentInfs.get(i).getWednesday().substring(6);
                    if (dayWeek.equals("周一")) {
                        dayNum = 1;
                    } else if (dayWeek.equals("周二")) {
                        dayNum = 2;
                    } else if (dayWeek.equals("周三")) {
                        dayNum = 3;
                    } else if (dayWeek.equals("周四")) {
                        dayNum = 4;
                    } else if (dayWeek.equals("周五")) {
                        dayNum = 5;
                    }
                } else if(updateStudentInfs.get(i).getWednesday().length() == 10){
                    System.out.println(updateStudentInfs.get(i).getWednesday());
                    startWeek = Integer.parseInt(updateStudentInfs.get(i).getWednesday().substring(2,4));
                    endWeek = Integer.parseInt(updateStudentInfs.get(i).getWednesday().substring(5,7));
                    dayWeek = updateStudentInfs.get(i).getWednesday().substring(8);
                    if (dayWeek.equals("周一")) {
                        dayNum = 1;
                    } else if (dayWeek.equals("周二")) {
                        dayNum = 2;
                    } else if (dayWeek.equals("周三")) {
                        dayNum = 3;
                    } else if (dayWeek.equals("周四")) {
                        dayNum = 4;
                    } else if (dayWeek.equals("周五")) {
                        dayNum = 5;
                    }
                }
                classMessages = new ClassMessages(updateStudentInfs.get(i).getStuCode(), dayWeek, isSingle, updateStudentInfs.get(i).getClassToClass(), startWeek, endWeek, dayNum);
                allClassMessages.add(classMessages);

                //周四
                isSingle = updateStudentInfs.get(i).getThursday().substring(0, 1);
                startWeek = Integer.parseInt(updateStudentInfs.get(i).getThursday().substring(2, 3));

                if (updateStudentInfs.get(i).getThursday().length() == 9) {
                    endWeek = Integer.parseInt(updateStudentInfs.get(i).getThursday().substring(4, 6));
                    dayWeek = updateStudentInfs.get(i).getThursday().substring(7);
                    if (dayWeek.equals("周一")) {
                        dayNum = 1;
                    } else if (dayWeek.equals("周二")) {
                        dayNum = 2;
                    } else if (dayWeek.equals("周三")) {
                        dayNum = 3;
                    } else if (dayWeek.equals("周四")) {
                        dayNum = 4;
                    } else if (dayWeek.equals("周五")) {
                        dayNum = 5;
                    }
                } else if(updateStudentInfs.get(i).getThursday().length() == 8){
                    endWeek = Integer.parseInt(updateStudentInfs.get(i).getThursday().substring(4, 5));
                    dayWeek = updateStudentInfs.get(i).getThursday().substring(6);
                    if (dayWeek.equals("周一")) {
                        dayNum = 1;
                    } else if (dayWeek.equals("周二")) {
                        dayNum = 2;
                    } else if (dayWeek.equals("周三")) {
                        dayNum = 3;
                    } else if (dayWeek.equals("周四")) {
                        dayNum = 4;
                    } else if (dayWeek.equals("周五")) {
                        dayNum = 5;
                    }
                } else if(updateStudentInfs.get(i).getThursday().length() == 10){
                    System.out.println(updateStudentInfs.get(i).getThursday());
                    startWeek = Integer.parseInt(updateStudentInfs.get(i).getThursday().substring(2,4));
                    endWeek = Integer.parseInt(updateStudentInfs.get(i).getThursday().substring(5,7));
                    dayWeek = updateStudentInfs.get(i).getThursday().substring(8);
                    if (dayWeek.equals("周一")) {
                        dayNum = 1;
                    } else if (dayWeek.equals("周二")) {
                        dayNum = 2;
                    } else if (dayWeek.equals("周三")) {
                        dayNum = 3;
                    } else if (dayWeek.equals("周四")) {
                        dayNum = 4;
                    } else if (dayWeek.equals("周五")) {
                        dayNum = 5;
                    }
                }
                classMessages = new ClassMessages(updateStudentInfs.get(i).getStuCode(), dayWeek, isSingle, updateStudentInfs.get(i).getClassToClass(), startWeek, endWeek, dayNum);
                allClassMessages.add(classMessages);

                //周五
                isSingle = updateStudentInfs.get(i).getFriday().substring(0, 1);
                startWeek = Integer.parseInt(updateStudentInfs.get(i).getFriday().substring(2, 3));

                if (updateStudentInfs.get(i).getFriday().length() == 9) {
                    endWeek = Integer.parseInt(updateStudentInfs.get(i).getFriday().substring(4, 6));
                    dayWeek = updateStudentInfs.get(i).getFriday().substring(7);
                    if (dayWeek.equals("周一")) {
                        dayNum = 1;
                    } else if (dayWeek.equals("周二")) {
                        dayNum = 2;
                    } else if (dayWeek.equals("周三")) {
                        dayNum = 3;
                    } else if (dayWeek.equals("周四")) {
                        dayNum = 4;
                    } else if (dayWeek.equals("周五")) {
                        dayNum = 5;
                    }
                } else if(updateStudentInfs.get(i).getFriday().length() == 8){
                    System.out.println(updateStudentInfs.get(i).getFriday());
                    endWeek = Integer.parseInt(updateStudentInfs.get(i).getFriday().substring(4, 5));
                    dayWeek = updateStudentInfs.get(i).getFriday().substring(6);
                    if (dayWeek.equals("周一")) {
                        dayNum = 1;
                    } else if (dayWeek.equals("周二")) {
                        dayNum = 2;
                    } else if (dayWeek.equals("周三")) {
                        dayNum = 3;
                    } else if (dayWeek.equals("周四")) {
                        dayNum = 4;
                    } else if (dayWeek.equals("周五")) {
                        dayNum = 5;
                    }
                } else if(updateStudentInfs.get(i).getFriday().length() == 10){
                    System.out.println(updateStudentInfs.get(i).getFriday());
                    startWeek = Integer.parseInt(updateStudentInfs.get(i).getFriday().substring(2,4));
                    endWeek = Integer.parseInt(updateStudentInfs.get(i).getFriday().substring(5,7));
                    dayWeek = updateStudentInfs.get(i).getFriday().substring(8);
                    if (dayWeek.equals("周一")) {
                        dayNum = 1;
                    } else if (dayWeek.equals("周二")) {
                        dayNum = 2;
                    } else if (dayWeek.equals("周三")) {
                        dayNum = 3;
                    } else if (dayWeek.equals("周四")) {
                        dayNum = 4;
                    } else if (dayWeek.equals("周五")) {
                        dayNum = 5;
                    }
                }
                classMessages = new ClassMessages(updateStudentInfs.get(i).getStuCode(), dayWeek, isSingle,updateStudentInfs.get(i).getClassToClass(), startWeek, endWeek, dayNum);
                allClassMessages.add(classMessages);
            }
            else if (updateStudentInfs.get(i).getClassToClass().equals("3-4")) {
                String isSingle = "";
                Integer startWeek = 0;
                Integer endWeek = 0;
                String dayWeek = "";
                Integer dayNum = 0;

                //周一
                isSingle = updateStudentInfs.get(i).getMonday().substring(0, 1);
                startWeek = Integer.parseInt(updateStudentInfs.get(i).getMonday().substring(2, 3));

                if (updateStudentInfs.get(i).getMonday().length() == 9) {
                    endWeek = Integer.parseInt(updateStudentInfs.get(i).getMonday().substring(4, 6));
                    dayWeek = updateStudentInfs.get(i).getMonday().substring(7);
                    if (dayWeek.equals("周一")) {
                        dayNum = 1;
                    } else if (dayWeek.equals("周二")) {
                        dayNum = 2;
                    } else if (dayWeek.equals("周三")) {
                        dayNum = 3;
                    } else if (dayWeek.equals("周四")) {
                        dayNum = 4;
                    } else if (dayWeek.equals("周五")) {
                        dayNum = 5;
                    }
                } else if (updateStudentInfs.get(i).getMonday().length() == 8){
                    endWeek = Integer.parseInt(updateStudentInfs.get(i).getMonday().substring(4, 5));
                    dayWeek = updateStudentInfs.get(i).getMonday().substring(6);
                    if (dayWeek.equals("周一")) {
                        dayNum = 1;
                    } else if (dayWeek.equals("周二")) {
                        dayNum = 2;
                    } else if (dayWeek.equals("周三")) {
                        dayNum = 3;
                    } else if (dayWeek.equals("周四")) {
                        dayNum = 4;
                    } else if (dayWeek.equals("周五")) {
                        dayNum = 5;
                    }
                }else if(updateStudentInfs.get(i).getMonday().length() == 10){
                    System.out.println(updateStudentInfs.get(i).getMonday());
                    startWeek = Integer.parseInt(updateStudentInfs.get(i).getMonday().substring(2,4));
                    endWeek = Integer.parseInt(updateStudentInfs.get(i).getMonday().substring(5,7));
                    dayWeek = updateStudentInfs.get(i).getMonday().substring(8);
                    if (dayWeek.equals("周一")) {
                        dayNum = 1;
                    } else if (dayWeek.equals("周二")) {
                        dayNum = 2;
                    } else if (dayWeek.equals("周三")) {
                        dayNum = 3;
                    } else if (dayWeek.equals("周四")) {
                        dayNum = 4;
                    } else if (dayWeek.equals("周五")) {
                        dayNum = 5;
                    }
                }
                classMessages = new ClassMessages(updateStudentInfs.get(i).getStuCode(), dayWeek, isSingle, updateStudentInfs.get(i).getClassToClass(), startWeek, endWeek, dayNum);
                allClassMessages.add(classMessages);

                //周二
                isSingle = updateStudentInfs.get(i).getTuesday().substring(0, 1);
                startWeek = Integer.parseInt(updateStudentInfs.get(i).getTuesday().substring(2, 3));

                if (updateStudentInfs.get(i).getTuesday().length() == 9) {
                    endWeek = Integer.parseInt(updateStudentInfs.get(i).getTuesday().substring(4, 6));
                    dayWeek = updateStudentInfs.get(i).getTuesday().substring(7);
                    if (dayWeek.equals("周一")) {
                        dayNum = 1;
                    } else if (dayWeek.equals("周二")) {
                        dayNum = 2;
                    } else if (dayWeek.equals("周三")) {
                        dayNum = 3;
                    } else if (dayWeek.equals("周四")) {
                        dayNum = 4;
                    } else if (dayWeek.equals("周五")) {
                        dayNum = 5;
                    }
                } else if(updateStudentInfs.get(i).getTuesday().length() == 8){
                    endWeek = Integer.parseInt(updateStudentInfs.get(i).getTuesday().substring(4, 5));
                    dayWeek = updateStudentInfs.get(i).getTuesday().substring(6);
                    if (dayWeek.equals("周一")) {
                        dayNum = 1;
                    } else if (dayWeek.equals("周二")) {
                        dayNum = 2;
                    } else if (dayWeek.equals("周三")) {
                        dayNum = 3;
                    } else if (dayWeek.equals("周四")) {
                        dayNum = 4;
                    } else if (dayWeek.equals("周五")) {
                        dayNum = 5;
                    }
                }else if(updateStudentInfs.get(i).getTuesday().length() == 10){
                    System.out.println(updateStudentInfs.get(i).getTuesday());
                    startWeek = Integer.parseInt(updateStudentInfs.get(i).getTuesday().substring(2,4));
                    endWeek = Integer.parseInt(updateStudentInfs.get(i).getTuesday().substring(5,7));
                    dayWeek = updateStudentInfs.get(i).getTuesday().substring(8);
                    if (dayWeek.equals("周一")) {
                        dayNum = 1;
                    } else if (dayWeek.equals("周二")) {
                        dayNum = 2;
                    } else if (dayWeek.equals("周三")) {
                        dayNum = 3;
                    } else if (dayWeek.equals("周四")) {
                        dayNum = 4;
                    } else if (dayWeek.equals("周五")) {
                        dayNum = 5;
                    }
                }
                classMessages = new ClassMessages(updateStudentInfs.get(i).getStuCode(), dayWeek, isSingle, updateStudentInfs.get(i).getClassToClass(), startWeek, endWeek, dayNum);
                allClassMessages.add(classMessages);

                //周三
                isSingle = updateStudentInfs.get(i).getWednesday().substring(0, 1);
                startWeek = Integer.parseInt(updateStudentInfs.get(i).getWednesday().substring(2, 3));

                if (updateStudentInfs.get(i).getWednesday().length() == 9) {
                    endWeek = Integer.parseInt(updateStudentInfs.get(i).getWednesday().substring(4, 6));
                    dayWeek = updateStudentInfs.get(i).getWednesday().substring(7);
                    if (dayWeek.equals("周一")) {
                        dayNum = 1;
                    } else if (dayWeek.equals("周二")) {
                        dayNum = 2;
                    } else if (dayWeek.equals("周三")) {
                        dayNum = 3;
                    } else if (dayWeek.equals("周四")) {
                        dayNum = 4;
                    } else if (dayWeek.equals("周五")) {
                        dayNum = 5;
                    }
                } else if (updateStudentInfs.get(i).getWednesday().length() == 8){
                    endWeek = Integer.parseInt(updateStudentInfs.get(i).getWednesday().substring(4, 5));
                    dayWeek = updateStudentInfs.get(i).getWednesday().substring(6);
                    if (dayWeek.equals("周一")) {
                        dayNum = 1;
                    } else if (dayWeek.equals("周二")) {
                        dayNum = 2;
                    } else if (dayWeek.equals("周三")) {
                        dayNum = 3;
                    } else if (dayWeek.equals("周四")) {
                        dayNum = 4;
                    } else if (dayWeek.equals("周五")) {
                        dayNum = 5;
                    }
                } else if(updateStudentInfs.get(i).getWednesday().length() == 10){
                    System.out.println(updateStudentInfs.get(i).getWednesday());
                    startWeek = Integer.parseInt(updateStudentInfs.get(i).getWednesday().substring(2,4));
                    endWeek = Integer.parseInt(updateStudentInfs.get(i).getWednesday().substring(5,7));
                    dayWeek = updateStudentInfs.get(i).getWednesday().substring(8);
                    if (dayWeek.equals("周一")) {
                        dayNum = 1;
                    } else if (dayWeek.equals("周二")) {
                        dayNum = 2;
                    } else if (dayWeek.equals("周三")) {
                        dayNum = 3;
                    } else if (dayWeek.equals("周四")) {
                        dayNum = 4;
                    } else if (dayWeek.equals("周五")) {
                        dayNum = 5;
                    }
                }
                classMessages = new ClassMessages(updateStudentInfs.get(i).getStuCode(), dayWeek, isSingle, updateStudentInfs.get(i).getClassToClass(), startWeek, endWeek, dayNum);
                allClassMessages.add(classMessages);

                //周四
                isSingle = updateStudentInfs.get(i).getThursday().substring(0, 1);
                startWeek = Integer.parseInt(updateStudentInfs.get(i).getThursday().substring(2, 3));

                if (updateStudentInfs.get(i).getThursday().length() == 9) {
                    endWeek = Integer.parseInt(updateStudentInfs.get(i).getThursday().substring(4, 6));
                    dayWeek = updateStudentInfs.get(i).getThursday().substring(7);
                    if (dayWeek.equals("周一")) {
                        dayNum = 1;
                    } else if (dayWeek.equals("周二")) {
                        dayNum = 2;
                    } else if (dayWeek.equals("周三")) {
                        dayNum = 3;
                    } else if (dayWeek.equals("周四")) {
                        dayNum = 4;
                    } else if (dayWeek.equals("周五")) {
                        dayNum = 5;
                    }
                } else if(updateStudentInfs.get(i).getThursday().length() == 8){
                    endWeek = Integer.parseInt(updateStudentInfs.get(i).getThursday().substring(4, 5));
                    dayWeek = updateStudentInfs.get(i).getThursday().substring(6);
                    if (dayWeek.equals("周一")) {
                        dayNum = 1;
                    } else if (dayWeek.equals("周二")) {
                        dayNum = 2;
                    } else if (dayWeek.equals("周三")) {
                        dayNum = 3;
                    } else if (dayWeek.equals("周四")) {
                        dayNum = 4;
                    } else if (dayWeek.equals("周五")) {
                        dayNum = 5;
                    }
                } else if(updateStudentInfs.get(i).getThursday().length() == 10){
                    System.out.println(updateStudentInfs.get(i).getThursday());
                    startWeek = Integer.parseInt(updateStudentInfs.get(i).getThursday().substring(2,4));
                    endWeek = Integer.parseInt(updateStudentInfs.get(i).getThursday().substring(5,7));
                    dayWeek = updateStudentInfs.get(i).getThursday().substring(8);
                    if (dayWeek.equals("周一")) {
                        dayNum = 1;
                    } else if (dayWeek.equals("周二")) {
                        dayNum = 2;
                    } else if (dayWeek.equals("周三")) {
                        dayNum = 3;
                    } else if (dayWeek.equals("周四")) {
                        dayNum = 4;
                    } else if (dayWeek.equals("周五")) {
                        dayNum = 5;
                    }
                }
                classMessages = new ClassMessages(updateStudentInfs.get(i).getStuCode(), dayWeek, isSingle, updateStudentInfs.get(i).getClassToClass(), startWeek, endWeek, dayNum);
                allClassMessages.add(classMessages);

                //周五
                isSingle = updateStudentInfs.get(i).getFriday().substring(0, 1);
                startWeek = Integer.parseInt(updateStudentInfs.get(i).getFriday().substring(2, 3));

                if (updateStudentInfs.get(i).getFriday().length() == 9) {
                    endWeek = Integer.parseInt(updateStudentInfs.get(i).getFriday().substring(4, 6));
                    dayWeek = updateStudentInfs.get(i).getFriday().substring(7);
                    if (dayWeek.equals("周一")) {
                        dayNum = 1;
                    } else if (dayWeek.equals("周二")) {
                        dayNum = 2;
                    } else if (dayWeek.equals("周三")) {
                        dayNum = 3;
                    } else if (dayWeek.equals("周四")) {
                        dayNum = 4;
                    } else if (dayWeek.equals("周五")) {
                        dayNum = 5;
                    }
                } else if(updateStudentInfs.get(i).getFriday().length() == 8){
                    System.out.println(updateStudentInfs.get(i).getFriday());
                    endWeek = Integer.parseInt(updateStudentInfs.get(i).getFriday().substring(4, 5));
                    dayWeek = updateStudentInfs.get(i).getFriday().substring(6);
                    if (dayWeek.equals("周一")) {
                        dayNum = 1;
                    } else if (dayWeek.equals("周二")) {
                        dayNum = 2;
                    } else if (dayWeek.equals("周三")) {
                        dayNum = 3;
                    } else if (dayWeek.equals("周四")) {
                        dayNum = 4;
                    } else if (dayWeek.equals("周五")) {
                        dayNum = 5;
                    }
                } else if(updateStudentInfs.get(i).getFriday().length() == 10){
                    System.out.println(updateStudentInfs.get(i).getFriday());
                    startWeek = Integer.parseInt(updateStudentInfs.get(i).getFriday().substring(2,4));
                    endWeek = Integer.parseInt(updateStudentInfs.get(i).getFriday().substring(5,7));
                    dayWeek = updateStudentInfs.get(i).getFriday().substring(8);
                    if (dayWeek.equals("周一")) {
                        dayNum = 1;
                    } else if (dayWeek.equals("周二")) {
                        dayNum = 2;
                    } else if (dayWeek.equals("周三")) {
                        dayNum = 3;
                    } else if (dayWeek.equals("周四")) {
                        dayNum = 4;
                    } else if (dayWeek.equals("周五")) {
                        dayNum = 5;
                    }
                }
                classMessages = new ClassMessages(updateStudentInfs.get(i).getStuCode(), dayWeek, isSingle,updateStudentInfs.get(i).getClassToClass(), startWeek, endWeek, dayNum);
                allClassMessages.add(classMessages);
            }
            else if (updateStudentInfs.get(i).getClassToClass().equals("5-6")) {
                String isSingle = "";
                Integer startWeek = 0;
                Integer endWeek = 0;
                String dayWeek = "";
                Integer dayNum = 0;

                //周一
                isSingle = updateStudentInfs.get(i).getMonday().substring(0, 1);
                startWeek = Integer.parseInt(updateStudentInfs.get(i).getMonday().substring(2, 3));

                if (updateStudentInfs.get(i).getMonday().length() == 9) {
                    endWeek = Integer.parseInt(updateStudentInfs.get(i).getMonday().substring(4, 6));
                    dayWeek = updateStudentInfs.get(i).getMonday().substring(7);
                    if (dayWeek.equals("周一")) {
                        dayNum = 1;
                    } else if (dayWeek.equals("周二")) {
                        dayNum = 2;
                    } else if (dayWeek.equals("周三")) {
                        dayNum = 3;
                    } else if (dayWeek.equals("周四")) {
                        dayNum = 4;
                    } else if (dayWeek.equals("周五")) {
                        dayNum = 5;
                    }
                } else if (updateStudentInfs.get(i).getMonday().length() == 8){
                    endWeek = Integer.parseInt(updateStudentInfs.get(i).getMonday().substring(4, 5));
                    dayWeek = updateStudentInfs.get(i).getMonday().substring(6);
                    if (dayWeek.equals("周一")) {
                        dayNum = 1;
                    } else if (dayWeek.equals("周二")) {
                        dayNum = 2;
                    } else if (dayWeek.equals("周三")) {
                        dayNum = 3;
                    } else if (dayWeek.equals("周四")) {
                        dayNum = 4;
                    } else if (dayWeek.equals("周五")) {
                        dayNum = 5;
                    }
                }else if(updateStudentInfs.get(i).getMonday().length() == 10){
                    System.out.println(updateStudentInfs.get(i).getMonday());
                    startWeek = Integer.parseInt(updateStudentInfs.get(i).getMonday().substring(2,4));
                    endWeek = Integer.parseInt(updateStudentInfs.get(i).getMonday().substring(5,7));
                    dayWeek = updateStudentInfs.get(i).getMonday().substring(8);
                    if (dayWeek.equals("周一")) {
                        dayNum = 1;
                    } else if (dayWeek.equals("周二")) {
                        dayNum = 2;
                    } else if (dayWeek.equals("周三")) {
                        dayNum = 3;
                    } else if (dayWeek.equals("周四")) {
                        dayNum = 4;
                    } else if (dayWeek.equals("周五")) {
                        dayNum = 5;
                    }
                }
                classMessages = new ClassMessages(updateStudentInfs.get(i).getStuCode(), dayWeek, isSingle, updateStudentInfs.get(i).getClassToClass(), startWeek, endWeek, dayNum);
                allClassMessages.add(classMessages);

                //周二
                isSingle = updateStudentInfs.get(i).getTuesday().substring(0, 1);
                startWeek = Integer.parseInt(updateStudentInfs.get(i).getTuesday().substring(2, 3));

                if (updateStudentInfs.get(i).getTuesday().length() == 9) {
                    endWeek = Integer.parseInt(updateStudentInfs.get(i).getTuesday().substring(4, 6));
                    dayWeek = updateStudentInfs.get(i).getTuesday().substring(7);
                    if (dayWeek.equals("周一")) {
                        dayNum = 1;
                    } else if (dayWeek.equals("周二")) {
                        dayNum = 2;
                    } else if (dayWeek.equals("周三")) {
                        dayNum = 3;
                    } else if (dayWeek.equals("周四")) {
                        dayNum = 4;
                    } else if (dayWeek.equals("周五")) {
                        dayNum = 5;
                    }
                } else if(updateStudentInfs.get(i).getTuesday().length() == 8){
                    endWeek = Integer.parseInt(updateStudentInfs.get(i).getTuesday().substring(4, 5));
                    dayWeek = updateStudentInfs.get(i).getTuesday().substring(6);
                    if (dayWeek.equals("周一")) {
                        dayNum = 1;
                    } else if (dayWeek.equals("周二")) {
                        dayNum = 2;
                    } else if (dayWeek.equals("周三")) {
                        dayNum = 3;
                    } else if (dayWeek.equals("周四")) {
                        dayNum = 4;
                    } else if (dayWeek.equals("周五")) {
                        dayNum = 5;
                    }
                }else if(updateStudentInfs.get(i).getTuesday().length() == 10){
                    System.out.println(updateStudentInfs.get(i).getTuesday());
                    startWeek = Integer.parseInt(updateStudentInfs.get(i).getTuesday().substring(2,4));
                    endWeek = Integer.parseInt(updateStudentInfs.get(i).getTuesday().substring(5,7));
                    dayWeek = updateStudentInfs.get(i).getTuesday().substring(8);
                    if (dayWeek.equals("周一")) {
                        dayNum = 1;
                    } else if (dayWeek.equals("周二")) {
                        dayNum = 2;
                    } else if (dayWeek.equals("周三")) {
                        dayNum = 3;
                    } else if (dayWeek.equals("周四")) {
                        dayNum = 4;
                    } else if (dayWeek.equals("周五")) {
                        dayNum = 5;
                    }
                }
                classMessages = new ClassMessages(updateStudentInfs.get(i).getStuCode(), dayWeek, isSingle, updateStudentInfs.get(i).getClassToClass(), startWeek, endWeek, dayNum);
                allClassMessages.add(classMessages);

                //周三
                isSingle = updateStudentInfs.get(i).getWednesday().substring(0, 1);
                startWeek = Integer.parseInt(updateStudentInfs.get(i).getWednesday().substring(2, 3));

                if (updateStudentInfs.get(i).getWednesday().length() == 9) {
                    endWeek = Integer.parseInt(updateStudentInfs.get(i).getWednesday().substring(4, 6));
                    dayWeek = updateStudentInfs.get(i).getWednesday().substring(7);
                    if (dayWeek.equals("周一")) {
                        dayNum = 1;
                    } else if (dayWeek.equals("周二")) {
                        dayNum = 2;
                    } else if (dayWeek.equals("周三")) {
                        dayNum = 3;
                    } else if (dayWeek.equals("周四")) {
                        dayNum = 4;
                    } else if (dayWeek.equals("周五")) {
                        dayNum = 5;
                    }
                } else if (updateStudentInfs.get(i).getWednesday().length() == 8){
                    endWeek = Integer.parseInt(updateStudentInfs.get(i).getWednesday().substring(4, 5));
                    dayWeek = updateStudentInfs.get(i).getWednesday().substring(6);
                    if (dayWeek.equals("周一")) {
                        dayNum = 1;
                    } else if (dayWeek.equals("周二")) {
                        dayNum = 2;
                    } else if (dayWeek.equals("周三")) {
                        dayNum = 3;
                    } else if (dayWeek.equals("周四")) {
                        dayNum = 4;
                    } else if (dayWeek.equals("周五")) {
                        dayNum = 5;
                    }
                } else if(updateStudentInfs.get(i).getWednesday().length() == 10){
                    System.out.println(updateStudentInfs.get(i).getWednesday());
                    startWeek = Integer.parseInt(updateStudentInfs.get(i).getWednesday().substring(2,4));
                    endWeek = Integer.parseInt(updateStudentInfs.get(i).getWednesday().substring(5,7));
                    dayWeek = updateStudentInfs.get(i).getWednesday().substring(8);
                    if (dayWeek.equals("周一")) {
                        dayNum = 1;
                    } else if (dayWeek.equals("周二")) {
                        dayNum = 2;
                    } else if (dayWeek.equals("周三")) {
                        dayNum = 3;
                    } else if (dayWeek.equals("周四")) {
                        dayNum = 4;
                    } else if (dayWeek.equals("周五")) {
                        dayNum = 5;
                    }
                }
                classMessages = new ClassMessages(updateStudentInfs.get(i).getStuCode(), dayWeek, isSingle, updateStudentInfs.get(i).getClassToClass(), startWeek, endWeek, dayNum);
                allClassMessages.add(classMessages);

                //周四
                isSingle = updateStudentInfs.get(i).getThursday().substring(0, 1);
                startWeek = Integer.parseInt(updateStudentInfs.get(i).getThursday().substring(2, 3));

                if (updateStudentInfs.get(i).getThursday().length() == 9) {
                    endWeek = Integer.parseInt(updateStudentInfs.get(i).getThursday().substring(4, 6));
                    dayWeek = updateStudentInfs.get(i).getThursday().substring(7);
                    if (dayWeek.equals("周一")) {
                        dayNum = 1;
                    } else if (dayWeek.equals("周二")) {
                        dayNum = 2;
                    } else if (dayWeek.equals("周三")) {
                        dayNum = 3;
                    } else if (dayWeek.equals("周四")) {
                        dayNum = 4;
                    } else if (dayWeek.equals("周五")) {
                        dayNum = 5;
                    }
                } else if(updateStudentInfs.get(i).getThursday().length() == 8){
                    endWeek = Integer.parseInt(updateStudentInfs.get(i).getThursday().substring(4, 5));
                    dayWeek = updateStudentInfs.get(i).getThursday().substring(6);
                    if (dayWeek.equals("周一")) {
                        dayNum = 1;
                    } else if (dayWeek.equals("周二")) {
                        dayNum = 2;
                    } else if (dayWeek.equals("周三")) {
                        dayNum = 3;
                    } else if (dayWeek.equals("周四")) {
                        dayNum = 4;
                    } else if (dayWeek.equals("周五")) {
                        dayNum = 5;
                    }
                } else if(updateStudentInfs.get(i).getThursday().length() == 10){
                    System.out.println(updateStudentInfs.get(i).getThursday());
                    startWeek = Integer.parseInt(updateStudentInfs.get(i).getThursday().substring(2,4));
                    endWeek = Integer.parseInt(updateStudentInfs.get(i).getThursday().substring(5,7));
                    dayWeek = updateStudentInfs.get(i).getThursday().substring(8);
                    if (dayWeek.equals("周一")) {
                        dayNum = 1;
                    } else if (dayWeek.equals("周二")) {
                        dayNum = 2;
                    } else if (dayWeek.equals("周三")) {
                        dayNum = 3;
                    } else if (dayWeek.equals("周四")) {
                        dayNum = 4;
                    } else if (dayWeek.equals("周五")) {
                        dayNum = 5;
                    }
                }
                classMessages = new ClassMessages(updateStudentInfs.get(i).getStuCode(), dayWeek, isSingle, updateStudentInfs.get(i).getClassToClass(), startWeek, endWeek, dayNum);
                allClassMessages.add(classMessages);

                //周五
                isSingle = updateStudentInfs.get(i).getFriday().substring(0, 1);
                startWeek = Integer.parseInt(updateStudentInfs.get(i).getFriday().substring(2, 3));

                if (updateStudentInfs.get(i).getFriday().length() == 9) {
                    endWeek = Integer.parseInt(updateStudentInfs.get(i).getFriday().substring(4, 6));
                    dayWeek = updateStudentInfs.get(i).getFriday().substring(7);
                    if (dayWeek.equals("周一")) {
                        dayNum = 1;
                    } else if (dayWeek.equals("周二")) {
                        dayNum = 2;
                    } else if (dayWeek.equals("周三")) {
                        dayNum = 3;
                    } else if (dayWeek.equals("周四")) {
                        dayNum = 4;
                    } else if (dayWeek.equals("周五")) {
                        dayNum = 5;
                    }
                } else if(updateStudentInfs.get(i).getFriday().length() == 8){
                    System.out.println(updateStudentInfs.get(i).getFriday());
                    endWeek = Integer.parseInt(updateStudentInfs.get(i).getFriday().substring(4, 5));
                    dayWeek = updateStudentInfs.get(i).getFriday().substring(6);
                    if (dayWeek.equals("周一")) {
                        dayNum = 1;
                    } else if (dayWeek.equals("周二")) {
                        dayNum = 2;
                    } else if (dayWeek.equals("周三")) {
                        dayNum = 3;
                    } else if (dayWeek.equals("周四")) {
                        dayNum = 4;
                    } else if (dayWeek.equals("周五")) {
                        dayNum = 5;
                    }
                } else if(updateStudentInfs.get(i).getFriday().length() == 10){
                    System.out.println(updateStudentInfs.get(i).getFriday());
                    startWeek = Integer.parseInt(updateStudentInfs.get(i).getFriday().substring(2,4));
                    endWeek = Integer.parseInt(updateStudentInfs.get(i).getFriday().substring(5,7));
                    dayWeek = updateStudentInfs.get(i).getFriday().substring(8);
                    if (dayWeek.equals("周一")) {
                        dayNum = 1;
                    } else if (dayWeek.equals("周二")) {
                        dayNum = 2;
                    } else if (dayWeek.equals("周三")) {
                        dayNum = 3;
                    } else if (dayWeek.equals("周四")) {
                        dayNum = 4;
                    } else if (dayWeek.equals("周五")) {
                        dayNum = 5;
                    }
                }
                classMessages = new ClassMessages(updateStudentInfs.get(i).getStuCode(), dayWeek, isSingle,updateStudentInfs.get(i).getClassToClass(), startWeek, endWeek, dayNum);
                allClassMessages.add(classMessages);
            }
            else if (updateStudentInfs.get(i).getClassToClass().equals("7-8")) {
                String isSingle = "";
                Integer startWeek = 0;
                Integer endWeek = 0;
                String dayWeek = "";
                Integer dayNum = 0;

                //周一
                isSingle = updateStudentInfs.get(i).getMonday().substring(0, 1);
                startWeek = Integer.parseInt(updateStudentInfs.get(i).getMonday().substring(2, 3));

                if (updateStudentInfs.get(i).getMonday().length() == 9) {
                    endWeek = Integer.parseInt(updateStudentInfs.get(i).getMonday().substring(4, 6));
                    dayWeek = updateStudentInfs.get(i).getMonday().substring(7);
                    if (dayWeek.equals("周一")) {
                        dayNum = 1;
                    } else if (dayWeek.equals("周二")) {
                        dayNum = 2;
                    } else if (dayWeek.equals("周三")) {
                        dayNum = 3;
                    } else if (dayWeek.equals("周四")) {
                        dayNum = 4;
                    } else if (dayWeek.equals("周五")) {
                        dayNum = 5;
                    }
                } else if (updateStudentInfs.get(i).getMonday().length() == 8){
                    endWeek = Integer.parseInt(updateStudentInfs.get(i).getMonday().substring(4, 5));
                    dayWeek = updateStudentInfs.get(i).getMonday().substring(6);
                    if (dayWeek.equals("周一")) {
                        dayNum = 1;
                    } else if (dayWeek.equals("周二")) {
                        dayNum = 2;
                    } else if (dayWeek.equals("周三")) {
                        dayNum = 3;
                    } else if (dayWeek.equals("周四")) {
                        dayNum = 4;
                    } else if (dayWeek.equals("周五")) {
                        dayNum = 5;
                    }
                }else if(updateStudentInfs.get(i).getMonday().length() == 10){
                    System.out.println(updateStudentInfs.get(i).getMonday());
                    startWeek = Integer.parseInt(updateStudentInfs.get(i).getMonday().substring(2,4));
                    endWeek = Integer.parseInt(updateStudentInfs.get(i).getMonday().substring(5,7));
                    dayWeek = updateStudentInfs.get(i).getMonday().substring(8);
                    if (dayWeek.equals("周一")) {
                        dayNum = 1;
                    } else if (dayWeek.equals("周二")) {
                        dayNum = 2;
                    } else if (dayWeek.equals("周三")) {
                        dayNum = 3;
                    } else if (dayWeek.equals("周四")) {
                        dayNum = 4;
                    } else if (dayWeek.equals("周五")) {
                        dayNum = 5;
                    }
                }
                classMessages = new ClassMessages(updateStudentInfs.get(i).getStuCode(), dayWeek, isSingle, updateStudentInfs.get(i).getClassToClass(), startWeek, endWeek, dayNum);
                allClassMessages.add(classMessages);

                //周二
                isSingle = updateStudentInfs.get(i).getTuesday().substring(0, 1);
                startWeek = Integer.parseInt(updateStudentInfs.get(i).getTuesday().substring(2, 3));

                if (updateStudentInfs.get(i).getTuesday().length() == 9) {
                    endWeek = Integer.parseInt(updateStudentInfs.get(i).getTuesday().substring(4, 6));
                    dayWeek = updateStudentInfs.get(i).getTuesday().substring(7);
                    if (dayWeek.equals("周一")) {
                        dayNum = 1;
                    } else if (dayWeek.equals("周二")) {
                        dayNum = 2;
                    } else if (dayWeek.equals("周三")) {
                        dayNum = 3;
                    } else if (dayWeek.equals("周四")) {
                        dayNum = 4;
                    } else if (dayWeek.equals("周五")) {
                        dayNum = 5;
                    }
                } else if(updateStudentInfs.get(i).getTuesday().length() == 8){
                    endWeek = Integer.parseInt(updateStudentInfs.get(i).getTuesday().substring(4, 5));
                    dayWeek = updateStudentInfs.get(i).getTuesday().substring(6);
                    if (dayWeek.equals("周一")) {
                        dayNum = 1;
                    } else if (dayWeek.equals("周二")) {
                        dayNum = 2;
                    } else if (dayWeek.equals("周三")) {
                        dayNum = 3;
                    } else if (dayWeek.equals("周四")) {
                        dayNum = 4;
                    } else if (dayWeek.equals("周五")) {
                        dayNum = 5;
                    }
                }else if(updateStudentInfs.get(i).getTuesday().length() == 10){
                    System.out.println(updateStudentInfs.get(i).getTuesday());
                    startWeek = Integer.parseInt(updateStudentInfs.get(i).getTuesday().substring(2,4));
                    endWeek = Integer.parseInt(updateStudentInfs.get(i).getTuesday().substring(5,7));
                    dayWeek = updateStudentInfs.get(i).getTuesday().substring(8);
                    if (dayWeek.equals("周一")) {
                        dayNum = 1;
                    } else if (dayWeek.equals("周二")) {
                        dayNum = 2;
                    } else if (dayWeek.equals("周三")) {
                        dayNum = 3;
                    } else if (dayWeek.equals("周四")) {
                        dayNum = 4;
                    } else if (dayWeek.equals("周五")) {
                        dayNum = 5;
                    }
                }
                classMessages = new ClassMessages(updateStudentInfs.get(i).getStuCode(), dayWeek, isSingle, updateStudentInfs.get(i).getClassToClass(), startWeek, endWeek, dayNum);
                allClassMessages.add(classMessages);

                //周三
                isSingle = updateStudentInfs.get(i).getWednesday().substring(0, 1);
                startWeek = Integer.parseInt(updateStudentInfs.get(i).getWednesday().substring(2, 3));

                if (updateStudentInfs.get(i).getWednesday().length() == 9) {
                    endWeek = Integer.parseInt(updateStudentInfs.get(i).getWednesday().substring(4, 6));
                    dayWeek = updateStudentInfs.get(i).getWednesday().substring(7);
                    if (dayWeek.equals("周一")) {
                        dayNum = 1;
                    } else if (dayWeek.equals("周二")) {
                        dayNum = 2;
                    } else if (dayWeek.equals("周三")) {
                        dayNum = 3;
                    } else if (dayWeek.equals("周四")) {
                        dayNum = 4;
                    } else if (dayWeek.equals("周五")) {
                        dayNum = 5;
                    }
                } else if (updateStudentInfs.get(i).getWednesday().length() == 8){
                    endWeek = Integer.parseInt(updateStudentInfs.get(i).getWednesday().substring(4, 5));
                    dayWeek = updateStudentInfs.get(i).getWednesday().substring(6);
                    if (dayWeek.equals("周一")) {
                        dayNum = 1;
                    } else if (dayWeek.equals("周二")) {
                        dayNum = 2;
                    } else if (dayWeek.equals("周三")) {
                        dayNum = 3;
                    } else if (dayWeek.equals("周四")) {
                        dayNum = 4;
                    } else if (dayWeek.equals("周五")) {
                        dayNum = 5;
                    }
                } else if(updateStudentInfs.get(i).getWednesday().length() == 10){
                    System.out.println(updateStudentInfs.get(i).getWednesday());
                    startWeek = Integer.parseInt(updateStudentInfs.get(i).getWednesday().substring(2,4));
                    endWeek = Integer.parseInt(updateStudentInfs.get(i).getWednesday().substring(5,7));
                    dayWeek = updateStudentInfs.get(i).getWednesday().substring(8);
                    if (dayWeek.equals("周一")) {
                        dayNum = 1;
                    } else if (dayWeek.equals("周二")) {
                        dayNum = 2;
                    } else if (dayWeek.equals("周三")) {
                        dayNum = 3;
                    } else if (dayWeek.equals("周四")) {
                        dayNum = 4;
                    } else if (dayWeek.equals("周五")) {
                        dayNum = 5;
                    }
                }
                classMessages = new ClassMessages(updateStudentInfs.get(i).getStuCode(), dayWeek, isSingle, updateStudentInfs.get(i).getClassToClass(), startWeek, endWeek, dayNum);
                allClassMessages.add(classMessages);

                //周四
                isSingle = updateStudentInfs.get(i).getThursday().substring(0, 1);
                startWeek = Integer.parseInt(updateStudentInfs.get(i).getThursday().substring(2, 3));

                if (updateStudentInfs.get(i).getThursday().length() == 9) {
                    endWeek = Integer.parseInt(updateStudentInfs.get(i).getThursday().substring(4, 6));
                    dayWeek = updateStudentInfs.get(i).getThursday().substring(7);
                    if (dayWeek.equals("周一")) {
                        dayNum = 1;
                    } else if (dayWeek.equals("周二")) {
                        dayNum = 2;
                    } else if (dayWeek.equals("周三")) {
                        dayNum = 3;
                    } else if (dayWeek.equals("周四")) {
                        dayNum = 4;
                    } else if (dayWeek.equals("周五")) {
                        dayNum = 5;
                    }
                } else if(updateStudentInfs.get(i).getThursday().length() == 8){
                    endWeek = Integer.parseInt(updateStudentInfs.get(i).getThursday().substring(4, 5));
                    dayWeek = updateStudentInfs.get(i).getThursday().substring(6);
                    if (dayWeek.equals("周一")) {
                        dayNum = 1;
                    } else if (dayWeek.equals("周二")) {
                        dayNum = 2;
                    } else if (dayWeek.equals("周三")) {
                        dayNum = 3;
                    } else if (dayWeek.equals("周四")) {
                        dayNum = 4;
                    } else if (dayWeek.equals("周五")) {
                        dayNum = 5;
                    }
                } else if(updateStudentInfs.get(i).getThursday().length() == 10){
                    System.out.println(updateStudentInfs.get(i).getThursday());
                    startWeek = Integer.parseInt(updateStudentInfs.get(i).getThursday().substring(2,4));
                    endWeek = Integer.parseInt(updateStudentInfs.get(i).getThursday().substring(5,7));
                    dayWeek = updateStudentInfs.get(i).getThursday().substring(8);
                    if (dayWeek.equals("周一")) {
                        dayNum = 1;
                    } else if (dayWeek.equals("周二")) {
                        dayNum = 2;
                    } else if (dayWeek.equals("周三")) {
                        dayNum = 3;
                    } else if (dayWeek.equals("周四")) {
                        dayNum = 4;
                    } else if (dayWeek.equals("周五")) {
                        dayNum = 5;
                    }
                }
                classMessages = new ClassMessages(updateStudentInfs.get(i).getStuCode(), dayWeek, isSingle, updateStudentInfs.get(i).getClassToClass(), startWeek, endWeek, dayNum);
                allClassMessages.add(classMessages);

                //周五
                isSingle = updateStudentInfs.get(i).getFriday().substring(0, 1);
                startWeek = Integer.parseInt(updateStudentInfs.get(i).getFriday().substring(2, 3));

                if (updateStudentInfs.get(i).getFriday().length() == 9) {
                    endWeek = Integer.parseInt(updateStudentInfs.get(i).getFriday().substring(4, 6));
                    dayWeek = updateStudentInfs.get(i).getFriday().substring(7);
                    if (dayWeek.equals("周一")) {
                        dayNum = 1;
                    } else if (dayWeek.equals("周二")) {
                        dayNum = 2;
                    } else if (dayWeek.equals("周三")) {
                        dayNum = 3;
                    } else if (dayWeek.equals("周四")) {
                        dayNum = 4;
                    } else if (dayWeek.equals("周五")) {
                        dayNum = 5;
                    }
                } else if(updateStudentInfs.get(i).getFriday().length() == 8){
                    System.out.println(updateStudentInfs.get(i).getFriday());
                    endWeek = Integer.parseInt(updateStudentInfs.get(i).getFriday().substring(4, 5));
                    dayWeek = updateStudentInfs.get(i).getFriday().substring(6);
                    if (dayWeek.equals("周一")) {
                        dayNum = 1;
                    } else if (dayWeek.equals("周二")) {
                        dayNum = 2;
                    } else if (dayWeek.equals("周三")) {
                        dayNum = 3;
                    } else if (dayWeek.equals("周四")) {
                        dayNum = 4;
                    } else if (dayWeek.equals("周五")) {
                        dayNum = 5;
                    }
                } else if(updateStudentInfs.get(i).getFriday().length() == 10){
                    System.out.println(updateStudentInfs.get(i).getFriday());
                    startWeek = Integer.parseInt(updateStudentInfs.get(i).getFriday().substring(2,4));
                    endWeek = Integer.parseInt(updateStudentInfs.get(i).getFriday().substring(5,7));
                    dayWeek = updateStudentInfs.get(i).getFriday().substring(8);
                    if (dayWeek.equals("周一")) {
                        dayNum = 1;
                    } else if (dayWeek.equals("周二")) {
                        dayNum = 2;
                    } else if (dayWeek.equals("周三")) {
                        dayNum = 3;
                    } else if (dayWeek.equals("周四")) {
                        dayNum = 4;
                    } else if (dayWeek.equals("周五")) {
                        dayNum = 5;
                    }
                }
                classMessages = new ClassMessages(updateStudentInfs.get(i).getStuCode(), dayWeek, isSingle,updateStudentInfs.get(i).getClassToClass(), startWeek, endWeek, dayNum);
                allClassMessages.add(classMessages);
            }
            else if (updateStudentInfs.get(i).getClassToClass().equals("9-10")) {
                String isSingle = "";
                Integer startWeek = 0;
                Integer endWeek = 0;
                String dayWeek = "";
                Integer dayNum = 0;

                //周一
                isSingle = updateStudentInfs.get(i).getMonday().substring(0, 1);
                startWeek = Integer.parseInt(updateStudentInfs.get(i).getMonday().substring(2, 3));

                if (updateStudentInfs.get(i).getMonday().length() == 9) {
                    endWeek = Integer.parseInt(updateStudentInfs.get(i).getMonday().substring(4, 6));
                    dayWeek = updateStudentInfs.get(i).getMonday().substring(7);
                    if (dayWeek.equals("周一")) {
                        dayNum = 1;
                    } else if (dayWeek.equals("周二")) {
                        dayNum = 2;
                    } else if (dayWeek.equals("周三")) {
                        dayNum = 3;
                    } else if (dayWeek.equals("周四")) {
                        dayNum = 4;
                    } else if (dayWeek.equals("周五")) {
                        dayNum = 5;
                    }
                } else if (updateStudentInfs.get(i).getMonday().length() == 8){
                    endWeek = Integer.parseInt(updateStudentInfs.get(i).getMonday().substring(4, 5));
                    dayWeek = updateStudentInfs.get(i).getMonday().substring(6);
                    if (dayWeek.equals("周一")) {
                        dayNum = 1;
                    } else if (dayWeek.equals("周二")) {
                        dayNum = 2;
                    } else if (dayWeek.equals("周三")) {
                        dayNum = 3;
                    } else if (dayWeek.equals("周四")) {
                        dayNum = 4;
                    } else if (dayWeek.equals("周五")) {
                        dayNum = 5;
                    }
                }else if(updateStudentInfs.get(i).getMonday().length() == 10){
                    System.out.println(updateStudentInfs.get(i).getMonday());
                    startWeek = Integer.parseInt(updateStudentInfs.get(i).getMonday().substring(2,4));
                    endWeek = Integer.parseInt(updateStudentInfs.get(i).getMonday().substring(5,7));
                    dayWeek = updateStudentInfs.get(i).getMonday().substring(8);
                    if (dayWeek.equals("周一")) {
                        dayNum = 1;
                    } else if (dayWeek.equals("周二")) {
                        dayNum = 2;
                    } else if (dayWeek.equals("周三")) {
                        dayNum = 3;
                    } else if (dayWeek.equals("周四")) {
                        dayNum = 4;
                    } else if (dayWeek.equals("周五")) {
                        dayNum = 5;
                    }
                }
                classMessages = new ClassMessages(updateStudentInfs.get(i).getStuCode(), dayWeek, isSingle, updateStudentInfs.get(i).getClassToClass(), startWeek, endWeek, dayNum);
                allClassMessages.add(classMessages);

                //周二
                isSingle = updateStudentInfs.get(i).getTuesday().substring(0, 1);
                startWeek = Integer.parseInt(updateStudentInfs.get(i).getTuesday().substring(2, 3));

                if (updateStudentInfs.get(i).getTuesday().length() == 9) {
                    endWeek = Integer.parseInt(updateStudentInfs.get(i).getTuesday().substring(4, 6));
                    dayWeek = updateStudentInfs.get(i).getTuesday().substring(7);
                    if (dayWeek.equals("周一")) {
                        dayNum = 1;
                    } else if (dayWeek.equals("周二")) {
                        dayNum = 2;
                    } else if (dayWeek.equals("周三")) {
                        dayNum = 3;
                    } else if (dayWeek.equals("周四")) {
                        dayNum = 4;
                    } else if (dayWeek.equals("周五")) {
                        dayNum = 5;
                    }
                } else if(updateStudentInfs.get(i).getTuesday().length() == 8){
                    endWeek = Integer.parseInt(updateStudentInfs.get(i).getTuesday().substring(4, 5));
                    dayWeek = updateStudentInfs.get(i).getTuesday().substring(6);
                    if (dayWeek.equals("周一")) {
                        dayNum = 1;
                    } else if (dayWeek.equals("周二")) {
                        dayNum = 2;
                    } else if (dayWeek.equals("周三")) {
                        dayNum = 3;
                    } else if (dayWeek.equals("周四")) {
                        dayNum = 4;
                    } else if (dayWeek.equals("周五")) {
                        dayNum = 5;
                    }
                }else if(updateStudentInfs.get(i).getTuesday().length() == 10){
                    System.out.println(updateStudentInfs.get(i).getTuesday());
                    startWeek = Integer.parseInt(updateStudentInfs.get(i).getTuesday().substring(2,4));
                    endWeek = Integer.parseInt(updateStudentInfs.get(i).getTuesday().substring(5,7));
                    dayWeek = updateStudentInfs.get(i).getTuesday().substring(8);
                    if (dayWeek.equals("周一")) {
                        dayNum = 1;
                    } else if (dayWeek.equals("周二")) {
                        dayNum = 2;
                    } else if (dayWeek.equals("周三")) {
                        dayNum = 3;
                    } else if (dayWeek.equals("周四")) {
                        dayNum = 4;
                    } else if (dayWeek.equals("周五")) {
                        dayNum = 5;
                    }
                }
                classMessages = new ClassMessages(updateStudentInfs.get(i).getStuCode(), dayWeek, isSingle, updateStudentInfs.get(i).getClassToClass(), startWeek, endWeek, dayNum);
                allClassMessages.add(classMessages);

                //周三
                isSingle = updateStudentInfs.get(i).getWednesday().substring(0, 1);
                startWeek = Integer.parseInt(updateStudentInfs.get(i).getWednesday().substring(2, 3));

                if (updateStudentInfs.get(i).getWednesday().length() == 9) {
                    endWeek = Integer.parseInt(updateStudentInfs.get(i).getWednesday().substring(4, 6));
                    dayWeek = updateStudentInfs.get(i).getWednesday().substring(7);
                    if (dayWeek.equals("周一")) {
                        dayNum = 1;
                    } else if (dayWeek.equals("周二")) {
                        dayNum = 2;
                    } else if (dayWeek.equals("周三")) {
                        dayNum = 3;
                    } else if (dayWeek.equals("周四")) {
                        dayNum = 4;
                    } else if (dayWeek.equals("周五")) {
                        dayNum = 5;
                    }
                } else if (updateStudentInfs.get(i).getWednesday().length() == 8){
                    endWeek = Integer.parseInt(updateStudentInfs.get(i).getWednesday().substring(4, 5));
                    dayWeek = updateStudentInfs.get(i).getWednesday().substring(6);
                    if (dayWeek.equals("周一")) {
                        dayNum = 1;
                    } else if (dayWeek.equals("周二")) {
                        dayNum = 2;
                    } else if (dayWeek.equals("周三")) {
                        dayNum = 3;
                    } else if (dayWeek.equals("周四")) {
                        dayNum = 4;
                    } else if (dayWeek.equals("周五")) {
                        dayNum = 5;
                    }
                } else if(updateStudentInfs.get(i).getWednesday().length() == 10){
                    System.out.println(updateStudentInfs.get(i).getWednesday());
                    startWeek = Integer.parseInt(updateStudentInfs.get(i).getWednesday().substring(2,4));
                    endWeek = Integer.parseInt(updateStudentInfs.get(i).getWednesday().substring(5,7));
                    dayWeek = updateStudentInfs.get(i).getWednesday().substring(8);
                    if (dayWeek.equals("周一")) {
                        dayNum = 1;
                    } else if (dayWeek.equals("周二")) {
                        dayNum = 2;
                    } else if (dayWeek.equals("周三")) {
                        dayNum = 3;
                    } else if (dayWeek.equals("周四")) {
                        dayNum = 4;
                    } else if (dayWeek.equals("周五")) {
                        dayNum = 5;
                    }
                }
                classMessages = new ClassMessages(updateStudentInfs.get(i).getStuCode(), dayWeek, isSingle, updateStudentInfs.get(i).getClassToClass(), startWeek, endWeek, dayNum);
                allClassMessages.add(classMessages);

                //周四
                isSingle = updateStudentInfs.get(i).getThursday().substring(0, 1);
                startWeek = Integer.parseInt(updateStudentInfs.get(i).getThursday().substring(2, 3));

                if (updateStudentInfs.get(i).getThursday().length() == 9) {
                    endWeek = Integer.parseInt(updateStudentInfs.get(i).getThursday().substring(4, 6));
                    dayWeek = updateStudentInfs.get(i).getThursday().substring(7);
                    if (dayWeek.equals("周一")) {
                        dayNum = 1;
                    } else if (dayWeek.equals("周二")) {
                        dayNum = 2;
                    } else if (dayWeek.equals("周三")) {
                        dayNum = 3;
                    } else if (dayWeek.equals("周四")) {
                        dayNum = 4;
                    } else if (dayWeek.equals("周五")) {
                        dayNum = 5;
                    }
                } else if(updateStudentInfs.get(i).getThursday().length() == 8){
                    endWeek = Integer.parseInt(updateStudentInfs.get(i).getThursday().substring(4, 5));
                    dayWeek = updateStudentInfs.get(i).getThursday().substring(6);
                    if (dayWeek.equals("周一")) {
                        dayNum = 1;
                    } else if (dayWeek.equals("周二")) {
                        dayNum = 2;
                    } else if (dayWeek.equals("周三")) {
                        dayNum = 3;
                    } else if (dayWeek.equals("周四")) {
                        dayNum = 4;
                    } else if (dayWeek.equals("周五")) {
                        dayNum = 5;
                    }
                } else if(updateStudentInfs.get(i).getThursday().length() == 10){
                    System.out.println(updateStudentInfs.get(i).getThursday());
                    startWeek = Integer.parseInt(updateStudentInfs.get(i).getThursday().substring(2,4));
                    endWeek = Integer.parseInt(updateStudentInfs.get(i).getThursday().substring(5,7));
                    dayWeek = updateStudentInfs.get(i).getThursday().substring(8);
                    if (dayWeek.equals("周一")) {
                        dayNum = 1;
                    } else if (dayWeek.equals("周二")) {
                        dayNum = 2;
                    } else if (dayWeek.equals("周三")) {
                        dayNum = 3;
                    } else if (dayWeek.equals("周四")) {
                        dayNum = 4;
                    } else if (dayWeek.equals("周五")) {
                        dayNum = 5;
                    }
                }
                classMessages = new ClassMessages(updateStudentInfs.get(i).getStuCode(), dayWeek, isSingle, updateStudentInfs.get(i).getClassToClass(), startWeek, endWeek, dayNum);
                allClassMessages.add(classMessages);

                //周五
                isSingle = updateStudentInfs.get(i).getFriday().substring(0, 1);
                startWeek = Integer.parseInt(updateStudentInfs.get(i).getFriday().substring(2, 3));

                if (updateStudentInfs.get(i).getFriday().length() == 9) {
                    endWeek = Integer.parseInt(updateStudentInfs.get(i).getFriday().substring(4, 6));
                    dayWeek = updateStudentInfs.get(i).getFriday().substring(7);
                    if (dayWeek.equals("周一")) {
                        dayNum = 1;
                    } else if (dayWeek.equals("周二")) {
                        dayNum = 2;
                    } else if (dayWeek.equals("周三")) {
                        dayNum = 3;
                    } else if (dayWeek.equals("周四")) {
                        dayNum = 4;
                    } else if (dayWeek.equals("周五")) {
                        dayNum = 5;
                    }
                } else if(updateStudentInfs.get(i).getFriday().length() == 8){
                    System.out.println(updateStudentInfs.get(i).getFriday());
                    endWeek = Integer.parseInt(updateStudentInfs.get(i).getFriday().substring(4, 5));
                    dayWeek = updateStudentInfs.get(i).getFriday().substring(6);
                    if (dayWeek.equals("周一")) {
                        dayNum = 1;
                    } else if (dayWeek.equals("周二")) {
                        dayNum = 2;
                    } else if (dayWeek.equals("周三")) {
                        dayNum = 3;
                    } else if (dayWeek.equals("周四")) {
                        dayNum = 4;
                    } else if (dayWeek.equals("周五")) {
                        dayNum = 5;
                    }
                } else if(updateStudentInfs.get(i).getFriday().length() == 10){
                    System.out.println(updateStudentInfs.get(i).getFriday());
                    startWeek = Integer.parseInt(updateStudentInfs.get(i).getFriday().substring(2,4));
                    endWeek = Integer.parseInt(updateStudentInfs.get(i).getFriday().substring(5,7));
                    dayWeek = updateStudentInfs.get(i).getFriday().substring(8);
                    if (dayWeek.equals("周一")) {
                        dayNum = 1;
                    } else if (dayWeek.equals("周二")) {
                        dayNum = 2;
                    } else if (dayWeek.equals("周三")) {
                        dayNum = 3;
                    } else if (dayWeek.equals("周四")) {
                        dayNum = 4;
                    } else if (dayWeek.equals("周五")) {
                        dayNum = 5;
                    }
                }
                classMessages = new ClassMessages(updateStudentInfs.get(i).getStuCode(), dayWeek, isSingle,updateStudentInfs.get(i).getClassToClass(), startWeek, endWeek, dayNum);
                allClassMessages.add(classMessages);
            }
        }

        int stuInsert = 0;
        int stuClassInsert = 0;

        StudentInf studentInf = new StudentInf();
        studentInf.setStuName(updateStudentInfs.get(0).getStuName());
        studentInf.setStuCode(updateStudentInfs.get(0).getStuCode());
        studentInf.setPassword(updateStudentInfs.get(0).getStuCode());
        try {
            //添加进数据库
            stuInsert = studentDao.insert(studentInf);
        } catch (Exception e) {
            System.out.println("重复提交了！！！！！！！！！！！！！！！！！！");
        }

        for (ClassMessages messages : allClassMessages) {
            System.out.println(messages);
        }

        if (stuInsert != 0) {
            for (ClassMessages messages : allClassMessages) {
                try {
                    //添加进数据库
                    stuClassInsert = addStuByPictureDao.insert(messages);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return new Result(stuInsert != 0 && stuClassInsert != 0 ? Code.INSERT_OK : Code.INSERT_ERR, stuInsert != 0 ? "提交成功！" : "重复提交了！！！");
    }

}
