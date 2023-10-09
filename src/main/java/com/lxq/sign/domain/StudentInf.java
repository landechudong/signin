package com.lxq.sign.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class StudentInf {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String stuName;
    private String stuCode;
    private String password;
    private Integer lateTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;
    private Integer isExist;

    public StudentInf() {
    }

    public StudentInf(String stuCode, String password) {
        this.stuCode = stuCode;
        this.password = password;
    }

}
