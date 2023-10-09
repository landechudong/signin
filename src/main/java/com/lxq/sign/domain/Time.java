package com.lxq.sign.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalTime;

@Data
public class Time {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String sections;
    private LocalTime startTime;
    private LocalTime lastTime;
    private LocalTime lateTime;
}
