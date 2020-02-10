//package com.example.demoapplication.ui.WebService;
//
//
//import android.os.AsyncTask;
//
//import com.example.demoapplication.ui.WebService.CXF.DataService;
//
//import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
//
//public class CXFtest extends AsyncTask<String,Void,String> {
//    private String str1;
//
//
//
//    @Override
//    protected String doInBackground(String... strings) {
//        JaxWsProxyFactoryBean proxyFactoryBean = new JaxWsProxyFactoryBean();
//        proxyFactoryBean.setAddress("http://70.106.253.97:8888/DataService");
//        proxyFactoryBean.setServiceClass(DataService.class);
//        proxyFactoryBean.create();
//        DataService dataService = (DataService) proxyFactoryBean.create();
//        //
//        String query  = dataService.query("Nanjing");
//        System.out.println(query);
//
//
//        return query;
//
//    }
//
//    public String getStr(){
//        return this.str1;
//    }
//
//    protected void onPostExecute(String s) {
//        this.str1 = s;
//
//    }
//}
