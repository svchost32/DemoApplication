package com.example.demoapplication.ui.WebService;

import android.os.AsyncTask;
import android.widget.TextView;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class RetrieveFeedTask extends AsyncTask<String, Integer, String> {


    private TextView tv;

    @Override
    protected String doInBackground(String... strings) {

        StringBuffer sb = new StringBuffer();
        try {
            URL url = new URL("http://70.106.253.97:8989/webservice");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type","text/xml; charset=utf-8");
            //打開通信
            connection.setDoOutput(true);
            connection.setDoInput(true);
            //發送請求
            String info = buildXML("Nanjing");
            connection.getOutputStream().write(info.getBytes());

            String str = "";


            //獲取response
            int rescode = connection.getResponseCode();
            if (rescode == 200) {
                InputStream inputStream = connection.getInputStream();

                InputStreamReader isReader = new InputStreamReader(inputStream);


                Scanner scanner = new Scanner(inputStream);
                while (scanner.hasNext()){
                    scanner.nextLine();
                    sb.append(str);

                }
                scanner.close();

            }else
            {
                return "Error to get";
            }
        }catch (Exception e){

        }
        String result = sb.toString();

        return result;
    }


    private static String buildXML(String str){
        StringBuilder sbuilder = new StringBuilder();
        sbuilder.append("<?xml version=\"1.0\" ?>");
        sbuilder.append("<S:Envelope xmlns:S=\"http://schemas.xmlsoap.org/soap/envelope/\">");
        sbuilder.append("<S:Body>");
        sbuilder.append("<ns2:query xmlns:ns2=\"http://webservice.jd.com/\">");
        sbuilder.append("<arg0>"+str+"</arg0>");
        sbuilder.append("</ns2:query>");
        sbuilder.append("</S:Body></S:Envelope>");
        return sbuilder.toString();
    }

    protected void onPostExecute(String str) {
        // TODO: check this.exception
        // TODO: do something with the feed

        tv.setText(str);
    }
}
