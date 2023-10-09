package com.lxq.sign.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SignRecord {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String stuName;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime signTime;

    public SignRecord(Integer id, String stuName, LocalDateTime signTime) {
        this.id = id;
        this.stuName = stuName;
        this.signTime = signTime;
    }
}
