package com.lxq.sign.dao;

import ch.qos.logback.core.rolling.helper.IntegerTokenConverter;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lxq.sign.domain.ClassMessages;
import com.lxq.sign.domain.StudentInf;
import org.apache.ibatis.annotations.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDateTime;
import java.util.LinkedList;

@SuppressWarnings({"all"})
@Mapper
public interface StudentDao extends BaseMapper<StudentInf> {

    @Select("select stu_name,stu_code,id,is_exist from student_inf where stu_code = #{stuCode}")
    StudentInf selectByCode(String stuCode);

    @Update("update student_inf set stu_name = #{stuName},stu_code = #{stuCode},password = #{stuCode},update_time = now() where id = #{id}")
    Integer updateInf(String stuName, String stuCode, Integer id);

    @Update("update class_messages set stu_code = #{stuCode1} where stu_code = #{stuCode}")
    Integer updateClassMessage(String stuCode, String stuCode1);

    @Update("update time_tables set stu_code = #{stuCode1} where stu_code = #{stuCode}")
    Integer updateTimeTable(String stuCode,String stuCode1);

    @Update("update class_messages set is_single = #{isSingle} ,start_week = #{startWeek} , end_week = #{endWeek} where day_week = #{dayWeek} and class_to_class = #{classToClass}")
    Integer updateClassMessageInf(String isSingle,Integer startWeek,Integer endWeek,String dayWeek,String classToClass);

    @Delete("delete from time_tables where stu_code = #{stucode}")
    Integer delTimeTable(String stuCode);

    @Select("select stu_code from student_inf where stu_name = #{stuName}")
    String selectByName(String stuName);

    @Select("select stu_name from student_inf where stu_code = #{stuCode}")
    String selectNameByCode(String stuCode);

    @Select("select id,stu_name,stu_code,password,update_time,create_time from student_inf where is_exist = 2")
    LinkedList<StudentInf> selectAllAdmin();

    @Select("select id,stu_name,stu_code,password,update_time,create_time from student_inf where id = #{id}")
    StudentInf selectOneAdmin(Integer id);

    @Delete("delete from student_inf where id = #{id}")
    Integer delOneAdmin(Integer id);

    @Update("update student_inf set stu_code = #{stuCode},password = #{stuCode},update_time = now(),stu_name = #{stuName} where id = #{id}")
    int updateAdminInf(Integer id,String stuCode,String stuName);

    @Insert("insert into student_inf values (null,#{stuName},#{stuCode},#{stuCode},0,now(),2,now())")
    int insertAdmin(String stuName, String stuCode);

    @Delete("delete from class_messages where stu_code = #{stuCode}")
    int delClassMessage(String stuCode);

    @Update("update student_inf set late_time = #{lateTime} where stu_name = #{stuName} and stu_code = #{stuCode}")
    void addLateTime(String stuName, String stuCode,Integer lateTime);

    @Select("select late_time from student_inf where stu_name = #{stuName} and stu_code = #{stuCode}")
    Integer selectLateTime(String stuName, String stuCode);

    @Delete("delete from late_one_record where stu_code = #{stuCode}")
    Integer delLateRecord(String stuCode);


}