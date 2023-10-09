package com.lxq.sign.service;

import com.lxq.sign.controller.Result;
import com.lxq.sign.domain.StudentInf;
import sun.security.krb5.internal.crypto.RsaMd5CksumType;

public interface AdminService {
    Result getAllAdmin();
    Result getOneAdmin(Integer id);
    Result delOneAdmin(Integer id);
    Result updateAdmin(StudentInf studentInf);
    Result addAdmin(StudentInf studentInf);
}
