package com.example.demoapplication.ui.WebService;

import android.os.AsyncTask;
import android.widget.TextView;

import com.example.demoapplication.ui.WebService.ws.Datainput;
import com.example.demoapplication.ui.WebService.ws.DatainputService;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class Client2 extends AsyncTask<String, Void, String> {


    private static Datainput port;
    private String str1;
    private TextView tv1;

    public void Textviewset(TextView textView){
        this.tv1 = textView;
    }

    public String getdata( ) throws MalformedURLException {
        URL url = new URL("http://70.106.253.97:8989/webservice?wsdl");
        QName qName = new QName("http://webservice.jd.com/","datainputService");
        Service service = Service.create(url, qName);
        Datainput port = service.getPort(Datainput.class);
        String query = port.query("Nanjing");
        this.str1 = query;
        return query;

    }

    @Override
    protected String doInBackground(String... strings) {


        URL url = null;
        try {
            url = new URL("http://70.106.253.97:8989/webservice?wsdl");
        QName qName = new QName("http://webservice.jd.com/","datainputService");
        Service service = Service.create(url, qName);
        Datainput port = service.getPort(Datainput.class);
        String query = port.query("Nanjing");
            this.str1 = query;
            return query;
        } catch (MalformedURLException e) {
            return "crash";
        }

    }


        protected void onPostExecute()
        {
       tv1.setText(str1);
    }

}
