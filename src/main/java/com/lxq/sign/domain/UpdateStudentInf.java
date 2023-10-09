package com.lxq.sign.domain;

import lombok.Data;

@Data
public class UpdateStudentInf {
    private String stuName;
    private String stuCode;
    private String classToClass;
    private String Monday;
    private String Tuesday;
    private String Wednesday;
    private String Thursday;
    private String Friday;

    public UpdateStudentInf() {
    }

    public UpdateStudentInf(String stuName, String stuCode, String classToClass, String monday, String tuesday, String wednesday, String thursday, String friday) {
        this.stuName = stuName;
        this.stuCode = stuCode;
        this.classToClass = classToClass;
        Monday = monday;
        Tuesday = tuesday;
        Wednesday = wednesday;
        Thursday = thursday;
        Friday = friday;
    }

    public UpdateStudentInf(String classToClass, String monday, String tuesday, String wednesday, String thursday, String friday) {
        this.classToClass = classToClass;
        Monday = monday;
        Tuesday = tuesday;
        Wednesday = wednesday;
        Thursday = thursday;
        Friday = friday;
    }
}
