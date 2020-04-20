package com.cz.demo.test;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created 2019-09-23.
 *
 * @author changzheng
 */
public class NetTest {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress local = InetAddress.getLocalHost();
        InetAddress remote =InetAddress.getByName("www.163.com");

        System.out.println(local.getHostName());
        System.out.println(remote.getHostAddress());
    }
}
