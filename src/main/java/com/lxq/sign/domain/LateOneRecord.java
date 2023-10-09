package com.lxq.sign.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class LateOneRecord {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private String stuCode;
    private String stuName;
    private String dayWeek;
    private String classToClass;
    private String conditions;

}
