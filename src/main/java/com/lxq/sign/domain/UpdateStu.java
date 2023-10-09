package com.lxq.sign.domain;

import lombok.Data;

@Data
public class UpdateStu {
    private Integer id;
    private String stuName;
    private String stuCode;
    private String dayWeek;
    private String classToClass;
    private Integer startWeek;
    private Integer endWeek;
    private String isSingle;

    public UpdateStu(String stuName, String stuCode, String dayWeek, String classToClass, Integer startWeek, Integer endWeek, String isSingle) {
        this.stuName = stuName;
        this.stuCode = stuCode;
        this.dayWeek = dayWeek;
        this.classToClass = classToClass;
        this.startWeek = startWeek;
        this.endWeek = endWeek;
        this.isSingle = isSingle;
    }
}
