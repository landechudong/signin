package com.lxq.sign.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lxq.sign.domain.CelWeek;
import com.lxq.sign.domain.Time;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.time.LocalTime;
import java.util.LinkedList;

@SuppressWarnings({"all"})
@Mapper
public interface TimeDao extends BaseMapper<Time> {
    @Select("select sections,start_time,last_time,late_time from check_schedule where sections = #{section}")
    Time getTimeBySection(String section);

    @Select("select sections,start_time,last_time,late_time from check_schedule")
    LinkedList<Time> selectAll();

    @Update("update check_schedule set start_time = #{startTime},last_time = #{lastTime},late_time = #{lateTime} where sections = #{sections}")
    Integer updateBySection(String sections, LocalTime startTime, LocalTime lastTime, LocalTime lateTime);

    @Select("select week,original_time,change_time from celweek")
    LinkedList<CelWeek> getWeek();

    @Update("update celweek set week = #{week}")
    Integer updateWeek(Integer week);
}
