package com.lxq.sign.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class LateRecord {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String classToClass;
    private String stuName;
    private String stuCode;
    private String conditions;
    private Integer monday;
    private Integer tuesday;
    private Integer wednesday;
    private Integer thursday;
    private Integer friday;


}
