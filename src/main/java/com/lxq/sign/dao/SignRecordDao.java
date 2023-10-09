package com.lxq.sign.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lxq.sign.domain.CelWeek;
import com.lxq.sign.domain.SignRecord;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@SuppressWarnings({"all"})
@Mapper
public interface SignRecordDao extends BaseMapper<SignRecord> {

    @Update("update celweek set change_time = now()")
    Integer updateNowTime();

    @Select("select week,original_time,change_time from celweek")
    CelWeek getCelWeek();

    @Update("update celweek set original_time = now(),change_time = now()")
    Integer updateOriginalTime();

    @Update("update celweek set week = #{week}")
    Integer updateWeek(Integer week);

    @Delete("delete from sign_record")
    Integer deleteLoginRecord();

    @Delete("delete from late_one_record")
    Integer deleteLateRecord();

    @Delete("delete from time_tables")
    Integer deleteTimeTable();
}
