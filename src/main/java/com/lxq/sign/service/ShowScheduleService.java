package com.lxq.sign.service;

import com.lxq.sign.controller.Result;
import com.lxq.sign.domain.TimeTables;

public interface ShowScheduleService {
    Result getSchedule(String code);
    Result changeSchedule(String day,TimeTables timeTables);
}
