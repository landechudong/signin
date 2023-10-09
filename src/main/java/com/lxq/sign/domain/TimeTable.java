package com.lxq.sign.domain;

import lombok.Data;

@Data
public class TimeTable {
    private String stuName;
    private String stuCode;
    private String dayWeek;
    private String isSingle;
    private String classToClass;
    private Integer startWeek;
    private Integer endWeek;

}
