package com.lxq.sign.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lxq.sign.domain.LateOneRecord;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.LinkedList;

@SuppressWarnings({"all"})
@Mapper
public interface LateOneDao extends BaseMapper<LateOneRecord> {

    @Select("select stu_code,stu_name,day_week,class_to_class,conditions from late_one_record where stu_code = #{stuCode}")
    LinkedList<LateOneRecord> selectByCode(String stuCode);

    @Delete("delete from late_one_record")
    void delLateRecord();


    @Insert("insert into late_one_record values(null,#{stuCode},#{stuName},#{dayWeek},#{s},#{play})")
    void insertRecord(String stuCode, String stuName, String dayWeek, String s, String play);

}
