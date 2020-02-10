package com.example.demoapplication.ui.WebService.Model;

import android.os.Handler;
import android.os.Looper;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;


public class WebModel extends ViewModel {
    private MutableLiveData<String> requestResult = new MutableLiveData<>();

    public LiveData<String> simpledata = requestResult;

    private static String buildXML(String str) {
        StringBuilder sbuilder = new StringBuilder();
        sbuilder.append("<?xml version=\"1.0\" ?>");
        sbuilder.append("<S:Envelope xmlns:S=\"http://schemas.xmlsoap.org/soap/envelope/\">");
        sbuilder.append("<S:Body>");
        sbuilder.append("<ns2:query xmlns:ns2=\"http://webservice.jd.com/\">");
        sbuilder.append("<arg0>" + str + "</arg0>");
        sbuilder.append("</ns2:query>");
        sbuilder.append("</S:Body></S:Envelope>");
        return sbuilder.toString();
    }

    private Handler mLooper = new Handler(Looper.getMainLooper());

    public void requestWeb() throws IOException {
        new Thread() {

            @Override
            public void run() {
                URL url = null;
                try {
                    url = new URL("http://70.106.253.97:8989/webservice");

                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("POST");
                    connection.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
                    //打開通信
                    connection.setDoOutput(true);
                    connection.setDoInput(true);
                    //發送請求
                    String info = buildXML("Nanjing");
                    connection.getOutputStream().write(info.getBytes());

                    //獲取response
                    int rescode = connection.getResponseCode();
                    final String rets;
                    if (rescode == 200) {
                        InputStream inputStream = connection.getInputStream();

                        InputStreamReader isReader = new InputStreamReader(inputStream);

                        StringBuilder ret = new StringBuilder();
                        Scanner scanner = new Scanner(inputStream);
                        while (scanner.hasNext()) {
                            String strA = scanner.nextLine();
                            ret.append(strA);
                        }
                        scanner.close();
                        rets = ret.toString();
                    } else {
                        rets
                                = "Error";
                    }
                    mLooper.post(new Runnable() {
                        @Override
                        public void run() {
                            requestResult.setValue(rets);

                        }
                    });

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
