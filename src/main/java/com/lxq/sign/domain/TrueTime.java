package com.lxq.sign.domain;

import lombok.Data;

import java.time.LocalTime;

@Data
public class TrueTime {
    private String sections;
    private String startTime;
    private String lastTime;
    private String lateTime;

    public TrueTime(String sections, String startTime, String lastTime, String lateTime) {
        this.sections = sections;
        this.startTime = startTime;
        this.lastTime = lastTime;
        this.lateTime = lateTime;
    }
}
