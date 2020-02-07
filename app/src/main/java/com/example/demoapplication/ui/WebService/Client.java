package com.example.demoapplication.ui.WebService;

import android.os.AsyncTask;
import android.widget.TextView;

import com.example.demoapplication.ui.WebService.ws.Datainput;
import com.example.demoapplication.ui.WebService.ws.DatainputService;

public class Client extends AsyncTask<String, Void, String> {


    private static Datainput port;
    private TextView tv1;

    public void Textviewset(TextView textView){
        this.tv1 = textView;
    }

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

    @Override
    protected String doInBackground(String... strings) {
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


        protected void onPostExecute(String str)
        {
       tv1.setText(str);
    }

}
