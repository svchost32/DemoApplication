//package com.example.demoapplication.ui.WebService;
//
//import android.os.AsyncTask;
//import android.os.Bundle;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.Spinner;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.example.demoapplication.R;
//
//import org.ksoap2.SoapEnvelope;
//import org.ksoap2.serialization.SoapObject;
//import org.ksoap2.serialization.SoapSerializationEnvelope;
//import org.ksoap2.transport.HttpTransportSE;
//
//public class TestActivity extends AppCompatActivity{
//
//
//    private String NAME_SPACE = "http://webservice.jd.com";
//    private String METHOD_NAME = "Datainput";
//
//    private String SOAP_ACTION = NAME_SPACE+"/"+METHOD_NAME;
//    private String url = "http://70.106.253.97:8989/webservice?wsdl";
//
//    private int LOADER_ID = 1;
//
//    private EditText datainput;
//    private Button databtn;
//    private String resp;
//
//    Spinner sp1;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_test2);
//        datainput = findViewById(R.id.data);
//        databtn = findViewById(R.id.go);
//        getData();
//
//
//
//
//
//
//    }
//
//    public void getData(){
//
//
//        Mytask mt = new Mytask();
//        mt.execute();
//
//    }
//    class Mytask extends AsyncTask{
//
//        @Override
//        protected Object doInBackground(Object[] objects) {
//
//            loadData();
//            return null;
//        }
//
//        @Override
//        protected void onPostExecute(Object o) {
//            super.onPostExecute(o);
//
//        }
//    }
//
//    public void loadData(){
//        SoapObject soapObject = new SoapObject(NAME_SPACE,METHOD_NAME);
//        soapObject.addProperty("arg0","Nanjing");
//        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.ENC);
//        envelope.dotNet = true;
//        envelope.setOutputSoapObject(soapObject);
//
//        HttpTransportSE hts = new HttpTransportSE(url);
//        try {
//            hts.call(SOAP_ACTION,envelope);
//            SoapObject obj = (SoapObject) envelope.bodyIn;
//            resp = obj.getProperty(0).toString();
//            System.out.println(resp);
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//
//
//}
