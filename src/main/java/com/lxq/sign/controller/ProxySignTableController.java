package com.lxq.sign.controller;

import com.lxq.sign.domain.ProxySignInf;
import com.lxq.sign.service.ProxySignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@SuppressWarnings({"all"})
@RestController
@RequestMapping("/proxy")
public class ProxySignTableController {

    @Autowired
    ProxySignService proxySignService;

    @GetMapping
    public Result getProxyInf(){
        Result proxyInf = proxySignService.getProxyInf();
        return proxyInf;
    }

    @PutMapping
    public Result proxySign(@RequestBody ProxySignInf proxySignInf){
        Result result = proxySignService.proxySign(proxySignInf);
        return result;
    }
}
