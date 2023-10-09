package com.lxq.sign.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class TimeTables {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String stuCode;
    private String classToClass;
    private Integer Monday;
    private Integer Tuesday;
    private Integer Wednesday;
    private Integer Thursday;
    private Integer Friday;
}
