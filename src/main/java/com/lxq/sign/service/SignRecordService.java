package com.lxq.sign.service;

import com.lxq.sign.controller.Result;

public interface SignRecordService {
    Result addSignInf(String stuName);
    Result getSignInf(Integer page);
    Result delSignInf();
    Result loginInf();
}
