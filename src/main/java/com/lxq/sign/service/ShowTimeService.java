package com.lxq.sign.service;

import com.lxq.sign.controller.Result;
import com.lxq.sign.domain.TrueTime;

public interface ShowTimeService {
    Result GetAllTimeInf();
    Result GetOneTimeInf(String section);
    Result UpdateTimeBySections(TrueTime time);
    Result getWeek();
    Result updateWeek(Integer week);
    Result updateOriginalTime();
}
