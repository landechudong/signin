package com.lxq.sign.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.lxq.sign.domain.ClassMessages;
import com.lxq.sign.domain.TimeTable;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.LinkedList;

@SuppressWarnings({"all"})
@Mapper
public interface AddStuByPictureDao extends BaseMapper<ClassMessages> {

    @Select("select stu_code , is_single , class_to_class , start_week , end_week from class_messages where class_to_class = #{classToClass} and stu_code = #{stuCode} order by  day_num;")
    LinkedList<TimeTable> getTable(String classToClass, String stuCode);

    @Select("select stu_code , is_single , class_to_class , start_week , end_week from class_messages where stu_code = #{stuCode} order by day_num;")
    LinkedList<TimeTable> getInf(String stuCode);


    @Select("select week from celweek")
    Integer getWeek();

    @Select("select day_week , is_single , class_to_class , start_week , end_week from class_messages where stu_code = #{stuCode} and day_week = #{dayWeek};")
    LinkedList<TimeTable> selectTableInf(String stuCode,String dayWeek);

    @Select("select day_week , is_single , class_to_class , start_week , end_week from class_messages where stu_code = #{stuCode}")
    LinkedList<TimeTable> getTableInf(String stuCode);
}
