package com.example.demoapplication.ui.WebService;

import android.os.AsyncTask;
import android.widget.TextView;

import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

public class getRemoteInfo {

    private String result;

//    public getRemoteInfo(String result) {
//
//    }

//    public getRemoteInfo(String param) {
//        this.result = param;
//    }


    public String getRemoteInfo(String phoneSec) throws Exception {

        String WSDL_URI = "http://webservice.webxml.com.cn/WebServices/MobileCodeWS.asmx?WSDL";//wsdl 的uri
        String namespace = "http://WebXml.com.cn/";//namespace
        String methodName = "getMobileCodeInfo";//要调用的方法名称

        SoapObject request = new SoapObject(namespace, methodName);
        // 设置需调用WebService接口需要传入的两个参数mobileCode、userId
        request.addProperty("mobileCode", phoneSec);
        request.addProperty("userId", "");

        //创建SoapSerializationEnvelope 对象，同时指定soap版本号(之前在wsdl中看到的)
        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapSerializationEnvelope.VER12);
        envelope.bodyOut = request;//由于是发送请求，所以是设置bodyOut
        envelope.dotNet = true;//由于是.net开发的webservice，所以这里要设置为true

        HttpTransportSE httpTransportSE = new HttpTransportSE(WSDL_URI);
        httpTransportSE.call(null, envelope);//调用

        // 获取返回的数据
        SoapObject object = (SoapObject) envelope.bodyIn;
        // 获取返回的结果
        result = object.getProperty(0).toString();

        return result;
    }



    static class QueryAddressTask extends AsyncTask<String, Integer, String> {
        private String result;
        private TextView tv;

        public QueryAddressTask(String s, TextView textView) {
            this.result = s;
            this.tv = textView;

        }

        protected String doInBackground(String... params) {
//             查询手机号码（段）信息*/
            getRemoteInfo test = new getRemoteInfo();
            try {
                result = test.getRemoteInfo(result);

            } catch (Exception e) {
                e.printStackTrace();
            }

//            将结果返回给onPostExecute方法
            return result;
        }





        //此方法可以在主线程改变UI
        protected void onPostExecute(String rv) {
            // 将WebService返回的结果显示在TextView中

            tv.setText(rv);
        }
    }



}
