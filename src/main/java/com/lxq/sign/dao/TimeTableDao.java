package com.lxq.sign.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lxq.sign.domain.LateRecord;
import com.lxq.sign.domain.TimeTables;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;

import java.util.LinkedList;

@SuppressWarnings({"all"})
@Mapper
public interface TimeTableDao extends BaseMapper<TimeTables> {

    @Delete("delete from time_tables where stu_code = #{code}")
    void deleteTable(String code);

    @Delete("delete from time_tables")
    void deleteTableTime();

    @Select("select stu_code,class_to_class,monday,tuesday,wednesday,thursday,friday from time_tables where stu_code = #{code}")
    LinkedList<TimeTables> selectByCode(String code);

    @Update("update time_tables set monday = 2 where class_to_class = #{classToClass} and stu_code = #{code}")
    Integer updateByMonday(String classToClass,String code);

    @Update("update time_tables set tuesday = 2 where class_to_class = #{classToClass} and stu_code = #{code}")
    Integer updateByTuesday(String classToClass,String code);

    @Update("update time_tables set wednesday = 2 where class_to_class = #{classToClass} and stu_code = #{code}")
    Integer updateByWednesday(String classToClass,String code);

    @Update("update time_tables set thursday = 2 where class_to_class = #{classToClass} and stu_code = #{code}")
    Integer updateByThursday(String classToClass,String code);

    @Update("update time_tables set friday = 2 where class_to_class = #{classToClass} and stu_code = #{code}")
    Integer updateByFriday(String classToClass,String code);

    @Update("update time_tables set monday = 3 where class_to_class = #{classToClass} and stu_code = #{code}")
    Integer updateByLateMonday(String classToClass, String code);

    @Update("update time_tables set tuesday = 3 where class_to_class = #{classToClass} and stu_code = #{code}")
    Integer updateByLateTuesday(String classToClass,String code);

    @Update("update time_tables set wednesday = 3 where class_to_class = #{classToClass} and stu_code = #{code}")
    Integer updateByLateWednesday(String classToClass,String code);

    @Update("update time_tables set thursday = 3 where class_to_class = #{classToClass} and stu_code = #{code}")
    Integer updateByLateThursday(String classToClass,String code);

    @Update("update time_tables set friday = 3 where class_to_class = #{classToClass} and stu_code = #{code}")
    Integer updateByLateFriday(String classToClass,String code);
    //,tuesday,wednesday,thursday,friday
    @Select("select stu_code,class_to_class from time_tables where monday = 0 ")
    LinkedList<TimeTables> getMondayInf();

    @Select("select stu_code,class_to_class from time_tables where tuesday = 0")
    LinkedList<TimeTables> getTuesdayInf();

    @Select("select stu_code,class_to_class from time_tables where wednesday = 0")
    LinkedList<TimeTables> getWednesdayInf();

    @Select("select stu_code,class_to_class from time_tables where thursday = 0")
    LinkedList<TimeTables> getThursdayInf();

    @Select("select stu_code,class_to_class from time_tables where friday = 0")
    LinkedList<TimeTables> getFridayInf();

    @Update("update time_tables set monday = 2 where class_to_class = #{sections} and stu_code = #{stuCode}")
    Integer updateByProxyOnMonday(String sections, String stuCode);

    @Update("update time_tables set tuesday = 2 where class_to_class = #{sections} and stu_code = #{stuCode}")
    Integer updateByProxyOnTuesday(String sections, String stuCode);

    @Update("update time_tables set wednesday = 2 where class_to_class = #{sections} and stu_code = #{stuCode}")
    Integer updateByProxyOnWednesday(String sections, String stuCode);

    @Update("update time_tables set thursday = 2 where class_to_class = #{sections} and stu_code = #{stuCode}")
    Integer updateByProxyOnThursday(String sections, String stuCode);

    @Update("update time_tables set friday = 2 where class_to_class = #{sections} and stu_code = #{stuCode}")
    Integer updateByProxyOnFriday(String sections, String stuCode);

    @Select("select stu_code,class_to_class,monday from time_tables where monday = 0 or monday = 3")
    LinkedList<LateRecord> selectLateOnMonday();

    @Select("select stu_code,class_to_class,tuesday from time_tables where tuesday = 0 or tuesday = 3")
    LinkedList<LateRecord> selectLateOnTuesday();

    @Select("select stu_code,class_to_class,wednesday from time_tables where wednesday = 0 or wednesday = 3")
    LinkedList<LateRecord> selectLateOnWednesday();

    @Select("select stu_code,class_to_class,thursday from time_tables where thursday = 0 or thursday = 3 ")
    LinkedList<LateRecord> selectLateOnThursday();

    @Select("select stu_code,class_to_class,friday from time_tables where friday = 0 or friday = 3")
    LinkedList<LateRecord> selectLateOnFriday();

    @Update("update time_tables set monday = 4 where stu_code = #{stuCode} and class_to_class = #{classToClass}")
    Integer updateMonday(String stuCode, String classToClass, String toLowerCase);

    @Update("update time_tables set tuesday = 4 where stu_code = #{stuCode} and class_to_class = #{classToClass}")
    Integer updateTuesday(String stuCode, String classToClass, String toLowerCase);

    @Update("update time_tables set wednesday = 4 where stu_code = #{stuCode} and class_to_class = #{classToClass}")
    Integer updateWednesday(String stuCode, String classToClass, String toLowerCase);

    @Update("update time_tables set thursday = 4 where stu_code = #{stuCode} and class_to_class = #{classToClass}")
    Integer updateThursday(String stuCode, String classToClass, String toLowerCase);

    @Update("update time_tables set friday = 4 where stu_code = #{stuCode} and class_to_class = #{classToClass}")
    Integer updateFriday(String stuCode, String classToClass, String toLowerCase);

    @Select("select stu_code from time_tables where stu_code = #{code}")
    LinkedList<String> findCode(String code);


}
