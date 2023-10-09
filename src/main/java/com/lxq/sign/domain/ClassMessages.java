package com.lxq.sign.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalTime;

@Data
public class ClassMessages {
    @TableId(type = IdType.AUTO)
    private Integer classId;
    private String stuCode;
    private String dayWeek;
    private String isSingle;
    private String classToClass;
    private Integer startWeek;
    private Integer endWeek;
    private Integer dayNum;


    public ClassMessages(String stuCode, String dayWeek, String isSingle, String classToClass, Integer startWeek, Integer endWeek, Integer dayNum) {
        this.stuCode = stuCode;
        this.dayWeek = dayWeek;
        this.isSingle = isSingle;
        this.classToClass = classToClass;
        this.startWeek = startWeek;
        this.endWeek = endWeek;
        this.dayNum = dayNum;
    }
}
