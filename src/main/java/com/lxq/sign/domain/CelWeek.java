package com.lxq.sign.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;


import java.time.LocalDate;


@Data
public class CelWeek {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer week;
    private LocalDate originalTime;
    private LocalDate changeTime;



}
