package com.lxq.sign.domain;

import lombok.Data;


import java.time.LocalTime;

@Data
public class MainMessages {

    private String isSingle;
    private String weekToWeek;
    private String dayOfWeek;
    private String classToClass;


    public MainMessages() {
    }

    public MainMessages(String isSingle, String weekToWeek, String dayOfWeek, String classToClass) {
        this.isSingle = isSingle;
        this.weekToWeek = weekToWeek;
        this.dayOfWeek = dayOfWeek;
        this.classToClass = classToClass;
    }
}
