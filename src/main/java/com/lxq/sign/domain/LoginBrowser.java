package com.lxq.sign.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class LoginBrowser {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String stuCode;
    private String browser;

    public LoginBrowser(Integer id, String stuCode, String browser) {
        this.id = id;
        this.stuCode = stuCode;
        this.browser = browser;
    }
}
