package com.lxq.sign.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lxq.sign.controller.Code;
import com.lxq.sign.controller.Result;
import com.lxq.sign.dao.AddStuByPictureDao;
import com.lxq.sign.dao.StudentDao;
import com.lxq.sign.domain.*;
import com.lxq.sign.service.ShowStuListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

import java.util.LinkedList;

@SuppressWarnings({"all"})
@Service
public class ShowStuListImpl implements ShowStuListService {

    @Autowired
    StudentDao studentDao;

    @Autowired
    AddStuByPictureDao addStuByPictureDao;

    @Override
    public Result getStuInf(Integer currentPage) {
        IPage ipage =  new Page(currentPage,7);
        QueryWrapper<StudentInf> objectQueryWrapper = new QueryWrapper<>();
        objectQueryWrapper.eq("is_exist",1);
        studentDao.selectPage(ipage, objectQueryWrapper);
        return new Result(ipage != null ? Code.GET_OK : Code.GET_ERR,ipage);
    }

    @Override
    public Result getOneInf(String stuCode) {
        //找到学生信息
        StudentInf studentInf = studentDao.selectByCode(stuCode);
        return new Result(Code.GET_OK,studentInf);
    }

    @Override
    public Result delStuById(Integer id) {
        StudentInf studentInf = studentDao.selectById(id);
        int i = studentDao.deleteById(id);
        int i1 = studentDao.delClassMessage(studentInf.getStuCode());
        Integer integer = studentDao.delTimeTable(studentInf.getStuCode());
        studentDao.delLateRecord(studentInf.getStuCode());
        return new Result(i == 1 ? Code.DELETE_OK : Code.DELETE_ERR,"删除成功!");
    }

    @Override
    public Result updateInf(UpdateStu updateStu) {
        //原来的信息
        StudentInf studentInf1 = studentDao.selectById(updateStu.getId());
        String stuCode = "";
        String stuName = "";
        boolean loop = true;
        //
        if(studentInf1.getStuName().equals(updateStu.getStuName()) && studentInf1.getStuCode().equals(updateStu.getStuCode()) && updateStu.getClassToClass() != null){
            stuCode = studentInf1.getStuCode();
            stuName = studentInf1.getStuName();
            loop = false;
            studentInf1 = null;
        }

        System.out.println(updateStu);
        System.out.println(studentInf1);

        if(studentInf1 == null || !studentInf1.getStuName().equals(updateStu.getStuName()) || !studentInf1.getStuCode().equals(updateStu.getStuCode())){
            Integer integer = 1;


            try {
                integer = studentDao.updateInf(updateStu.getStuName(), updateStu.getStuCode(), updateStu.getId());
            } catch (Exception e) {
                integer = 0;
            }


            if(integer == 0){
                return new Result( Code.UPDATE_ERR, "姓名或者学号重复了!");
            }else {
                Integer integer1 = studentDao.updateTimeTable(stuCode, updateStu.getStuCode());
                Integer integer2 = studentDao.updateClassMessage(stuCode, updateStu.getStuCode());

                Integer i = 0;

                if (updateStu.getClassToClass() != null) {
                    Integer integer3 = studentDao.updateClassMessageInf(updateStu.getIsSingle(), updateStu.getStartWeek(), updateStu.getEndWeek(), updateStu.getDayWeek(), updateStu.getClassToClass());
                    if (integer3 == 0) {
                        i = 2;
                    } else {
                        Integer integer4 = studentDao.delTimeTable(stuCode);
                    }
                }

                return new Result(i == 2 ? Code.SYSTEM_UNKNOW_ERR : Code.UPDATE_OK, "修改成功!");
            }


        } else if(studentInf1.getStuName().equals(updateStu.getStuName()) && studentInf1.getStuCode().equals(updateStu.getStuCode()) && updateStu.getClassToClass() == null){
            return new Result(Code.UPDATE_ERR,"什么也没有改呢!");
        }else{
            return new Result(Code.UPDATE_ERR,"学号重复了!");
        }

    }

    @Override
    public Result getOneTableTime(Integer id) {
        StudentInf studentInf = studentDao.selectById(id);

        LocalDateTime now = LocalDateTime.now();
        DayOfWeek dayOfWeek = now.getDayOfWeek();
        String name = dayOfWeek.name();
        String dayWeek = "";
        if(name.equals("MONDAY")){
            dayWeek = "周一";
        }else if(name.equals("TUESDAY")){
            dayWeek = "周二";
        }else if(name.equals("WEDNESDAY")){
            dayWeek = "周三";
        }else if(name.equals("THURSDAY")){
            dayWeek = "周四";
        }else if(name.equals("FRIDAY")){
            dayWeek = "周五";
        }

        LinkedList<TimeTable> timeTables = addStuByPictureDao.selectTableInf(studentInf.getStuCode(),dayWeek);

        for (int i = 0; i < timeTables.size(); i++) {
            timeTables.get(i).setStuName(studentInf.getStuName());
        }

        return new Result(Code.GET_OK,timeTables);
    }

    @Override
    public Result getStuTable(String stuCode) {
        LinkedList<TimeTable> tableInf = addStuByPictureDao.getTableInf(stuCode);
        LinkedList<UpdateStudentInf> updateStudentInfs = new LinkedList<>();

        String monday = "";
        String tuesday = "";
        String wednesday = "";
        String thursday = "";
        String friday = "";

        for (TimeTable timeTable :tableInf) {


            if(timeTable.getClassToClass().equals("1-2")){
                if(timeTable.getDayWeek().equals("周一")) {
                    monday = timeTable.getIsSingle() + "(" + timeTable.getStartWeek() + "-" + timeTable.getEndWeek() + ")";
                    continue;
                }else if(timeTable.getDayWeek().equals("周二")) {
                    tuesday = timeTable.getIsSingle() + "(" + timeTable.getStartWeek() + "-" + timeTable.getEndWeek() + ")";
                    continue;
                }else if(timeTable.getDayWeek().equals("周三")) {
                    wednesday = timeTable.getIsSingle() + "(" + timeTable.getStartWeek() + "-" + timeTable.getEndWeek() + ")";
                    continue;
                }else if(timeTable.getDayWeek().equals("周四")) {
                    thursday = timeTable.getIsSingle() + "(" + timeTable.getStartWeek() + "-" + timeTable.getEndWeek() + ")";
                    continue;
                }else if(timeTable.getDayWeek().equals("周五")) {
                    friday = timeTable.getIsSingle() + "(" + timeTable.getStartWeek() + "-" + timeTable.getEndWeek() + ")";
                }
            }
            if(timeTable.getClassToClass().equals("1-2")) {
                updateStudentInfs.add(new UpdateStudentInf("1-2", monday, tuesday, wednesday, thursday, friday));
            }

            if(timeTable.getClassToClass().equals("3-4")){
                if(timeTable.getDayWeek().equals("周一")) {
                    monday = timeTable.getIsSingle() + "(" + timeTable.getStartWeek() + "-" + timeTable.getEndWeek() + ")";
                    continue;
                }else if(timeTable.getDayWeek().equals("周二")) {
                    tuesday = timeTable.getIsSingle() + "(" + timeTable.getStartWeek() + "-" + timeTable.getEndWeek() + ")";
                    continue;
                }else if(timeTable.getDayWeek().equals("周三")) {
                    wednesday = timeTable.getIsSingle() + "(" + timeTable.getStartWeek() + "-" + timeTable.getEndWeek() + ")";
                    continue;
                }else if(timeTable.getDayWeek().equals("周四")) {
                    thursday = timeTable.getIsSingle() + "(" + timeTable.getStartWeek() + "-" + timeTable.getEndWeek() + ")";
                    continue;
                }else if(timeTable.getDayWeek().equals("周五")) {
                    friday = timeTable.getIsSingle() + "(" + timeTable.getStartWeek() + "-" + timeTable.getEndWeek() + ")";
                }
            }
            if(timeTable.getClassToClass().equals("3-4")) {
                updateStudentInfs.add(new UpdateStudentInf("3-4", monday, tuesday, wednesday, thursday, friday));
            }

            if(timeTable.getClassToClass().equals("5-6")){
                if(timeTable.getDayWeek().equals("周一")) {
                    monday = timeTable.getIsSingle() + "(" + timeTable.getStartWeek() + "-" + timeTable.getEndWeek() + ")";
                    continue;
                }else if(timeTable.getDayWeek().equals("周二")) {
                    tuesday = timeTable.getIsSingle() + "(" + timeTable.getStartWeek() + "-" + timeTable.getEndWeek() + ")";
                    continue;
                }else if(timeTable.getDayWeek().equals("周三")) {
                    wednesday = timeTable.getIsSingle() + "(" + timeTable.getStartWeek() + "-" + timeTable.getEndWeek() + ")";
                    continue;
                }else if(timeTable.getDayWeek().equals("周四")) {
                    thursday = timeTable.getIsSingle() + "(" + timeTable.getStartWeek() + "-" + timeTable.getEndWeek() + ")";
                    continue;
                }else if(timeTable.getDayWeek().equals("周五")) {
                    friday = timeTable.getIsSingle() + "(" + timeTable.getStartWeek() + "-" + timeTable.getEndWeek() + ")";
                }
            }
            if(timeTable.getClassToClass().equals("5-6")) {
                updateStudentInfs.add(new UpdateStudentInf("5-6", monday, tuesday, wednesday, thursday, friday));
            }

            if(timeTable.getClassToClass().equals("7-8")){
                if(timeTable.getDayWeek().equals("周一")) {
                    monday = timeTable.getIsSingle() + "(" + timeTable.getStartWeek() + "-" + timeTable.getEndWeek() + ")";
                    continue;
                }else if(timeTable.getDayWeek().equals("周二")) {
                    tuesday = timeTable.getIsSingle() + "(" + timeTable.getStartWeek() + "-" + timeTable.getEndWeek() + ")";
                    continue;
                }else if(timeTable.getDayWeek().equals("周三")) {
                    wednesday = timeTable.getIsSingle() + "(" + timeTable.getStartWeek() + "-" + timeTable.getEndWeek() + ")";
                    continue;
                }else if(timeTable.getDayWeek().equals("周四")) {
                    thursday = timeTable.getIsSingle() + "(" + timeTable.getStartWeek() + "-" + timeTable.getEndWeek() + ")";
                    continue;
                }else if(timeTable.getDayWeek().equals("周五")) {
                    friday = timeTable.getIsSingle() + "(" + timeTable.getStartWeek() + "-" + timeTable.getEndWeek() + ")";
                }
            }
            if(timeTable.getClassToClass().equals("7-8")) {
                updateStudentInfs.add(new UpdateStudentInf("7-8", monday, tuesday, wednesday, thursday, friday));
            }

            if(timeTable.getClassToClass().equals("9-10")){
                if(timeTable.getDayWeek().equals("周一")) {
                    monday = timeTable.getIsSingle() + "(" + timeTable.getStartWeek() + "-" + timeTable.getEndWeek() + ")";
                    continue;
                }else if(timeTable.getDayWeek().equals("周二")) {
                    tuesday = timeTable.getIsSingle() + "(" + timeTable.getStartWeek() + "-" + timeTable.getEndWeek() + ")";
                    continue;
                }else if(timeTable.getDayWeek().equals("周三")) {
                    wednesday = timeTable.getIsSingle() + "(" + timeTable.getStartWeek() + "-" + timeTable.getEndWeek() + ")";
                    continue;
                }else if(timeTable.getDayWeek().equals("周四")) {
                    thursday = timeTable.getIsSingle() + "(" + timeTable.getStartWeek() + "-" + timeTable.getEndWeek() + ")";
                    continue;
                }else if(timeTable.getDayWeek().equals("周五")) {
                    friday = timeTable.getIsSingle() + "(" + timeTable.getStartWeek() + "-" + timeTable.getEndWeek() + ")";
                }
            }
            if(timeTable.getClassToClass().equals("9-10")) {
                updateStudentInfs.add(new UpdateStudentInf("9-10", monday, tuesday, wednesday, thursday, friday));
            }

        }

        return new Result(Code.GET_OK,updateStudentInfs);
    }

}
