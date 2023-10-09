package com.lxq.sign.controller;


import org.springframework.web.bind.annotation.*;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;

import java.util.Enumeration;

@SuppressWarnings({"all"})
@RestController
@RequestMapping("/ip")
public class IPValidationController {

    @PostMapping
    public Result hello() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();

            while (networkInterfaces.hasMoreElements()) {

                NetworkInterface networkInterface = networkInterfaces.nextElement();

                Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();

                while (inetAddresses.hasMoreElements()) {

                    InetAddress inetAddress = inetAddresses.nextElement();

                    if (!inetAddress.isLoopbackAddress() && inetAddress.getHostAddress().contains(":")) {
                        // Skip IPv6 addresses
                        continue;
                    }

                    System.out.println(inetAddress.getHostAddress());

                    if(inetAddress.getHostAddress().equals("127.0.0.1")){
                        System.out.println(inetAddress.getHostAddress());
                        System.out.println("使用了校园网");
                        return new Result(Code.GET_OK,null);
                    }else {
                        continue;
                    }

                }
            }
        } catch (SocketException e) {
        e.printStackTrace();
        }
        return new Result(Code.GET_ERR,"请使用校园网登录!");
    }

    @GetMapping("/test")
    public String test(){
        System.out.println("????????????????????????????");
        return "123";
    }

    @GetMapping("/test/{id}")
    public String test2(@PathVariable String id){
        return id;
    }
}
//if(hostAddress.equals("192.168.56.1")){
//        System.out.println(hostAddress);
//        System.out.println("使用了校园网");
//        return new Result(Code.GET_OK,null);
//        }else {
//        continue;
//        }

//        try {
//                Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
//
//        while (networkInterfaces.hasMoreElements()) {
//        NetworkInterface networkInterface = networkInterfaces.nextElement();
//
//        Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
//
//        while (inetAddresses.hasMoreElements()) {
//        InetAddress inetAddress = inetAddresses.nextElement();
//
//        if (!inetAddress.isLoopbackAddress() && inetAddress.getHostAddress().contains(":")) {
//        // Skip IPv6 addresses
//        continue;
//        }
//
//        System.out.println("Interface: " + networkInterface.getDisplayName());
//        System.out.println("IPv4 Address: " + inetAddress.getHostAddress());
//        System.out.println();
//        }
//        }
//        } catch (SocketException e) {
//        e.printStackTrace();
//        }