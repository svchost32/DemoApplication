package com.jd.webservice.jd.webservice.client;

import com.example.demoapplication.ui.WebService.ws.Datainput;
import com.example.demoapplication.ui.WebService.ws.DatainputService;

public class Client {
    private static Datainput port;

    public String getdata( ){
        //服务视图
        DatainputService service = new DatainputService();
        //实现类
        Datainput port = service.getPort(Datainput.class);
        //调用方法
        String query = port.query("深圳");
//        String others = port.others();

        return  query;
//		System.out.println(others);


    }
}
