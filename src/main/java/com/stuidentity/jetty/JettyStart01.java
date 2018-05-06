package com.stuidentity.jetty;

import cq.hlideal.jetty.main.server.JettyWebServer;

/**
 * Created by Administrator on 2018-04-21.
 */
public class JettyStart01 {
    //实际部署时删除
    public static int port = 8082;
    public static String host = "192.168.31.156";
    public static String tempdir = "d://temp14";
    public static String logdir = "d://temp14";
    public static String webdir = "src/main/webapp/";
    public static String contextpath = "";

    public static void main(String[] args) throws Exception{
        JettyWebServer server = new JettyWebServer(
                port,
                host,
                tempdir,
                webdir,
                logdir,
                contextpath);
        server.start();
        server.join();
    }
}
