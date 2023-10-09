package com.lxq.sign.service;

import com.lxq.sign.controller.Result;
import com.lxq.sign.domain.LateOneRecord;

public interface LateRecordService {
    Result getLateRecord();
    Result addLateInf(LateOneRecord lateOneRecord);
    Result getOneLateRecord(String stuCode);
}
