package com.lxq.sign.service;

import com.lxq.sign.controller.Result;
import com.lxq.sign.domain.ProxySignInf;

public interface ProxySignService {
    Result getProxyInf();
    Result proxySign(ProxySignInf proxySignInf);
}
