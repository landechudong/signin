package com.lxq.sign.domain;

import lombok.Data;

@Data
public class ProxySignInf {
    private String sections;
    private String stuName;

    public ProxySignInf(String sections, String stuName) {
        this.sections = sections;
        this.stuName = stuName;
    }
}
