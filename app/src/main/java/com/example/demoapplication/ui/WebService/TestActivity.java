//package com.example.demoapplication.ui.WebService;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.os.Bundle;
//
//import com.example.demoapplication.MainActivity;
//import com.example.demoapplication.R;
//import android.app.ProgressDialog;
//import android.os.AsyncTask;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import org.ksoap2.SoapEnvelope;
//import org.ksoap2.serialization.PropertyInfo;
//import org.ksoap2.serialization.SoapObject;
//import org.ksoap2.serialization.SoapPrimitive;
//import org.ksoap2.serialization.SoapSerializationEnvelope;
//import org.ksoap2.transport.HttpTransportSE;
//
//public class TestActivity extends AppCompatActivity {
//
//    String getCel;
//    String TAG = "Response";
//    SoapPrimitive resultString;
//
//    EditText cel;
//
//    Button sopaBtn;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_test);
//        cel = findViewById(R.id.textBox);
//        sopaBtn = findViewById(R.id.button);
//        sopaBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dataset();
//            }
//        });
//
//    }
//
//    public void dataset() {
//        getCel = cel.getText().toString();
////        异步任务执行Webservice请求
//        AsyncCallWS task = new AsyncCallWS();
//        task.execute();
//    }
//
//
//
//    private class AsyncCallWS extends AsyncTask<Void, Void, Void> {
//
//        @Override
//        protected void onPreExecute() {
//            Log.i(TAG, "onPreExecute");
//        }
//
//        @Override
//        protected Void doInBackground(Void... params) {
//            Log.i(TAG, "doInBackground");
//            calculate();
//            return null;
//        }
//
//        @Override
//        protected void onPostExecute(Void result) {
//            Log.i(TAG, "onPostExecute");
//            Toast.makeText(TestActivity.this, "Response" + resultString.toString(), Toast.LENGTH_LONG).show();
//        }
//
//    }
//
//    public void calculate() {
////        设置命名空间、访问地址、方法名
//        String SOAP_ACTION = "http://www.w3schools.com/xml/CelsiusToFahrenheit";
//        String METHOD_NAME = "CelsiusToFahrenheit";
//        String NAMESPACE = "http://www.w3schools.com/xml/";
//        String URL = "http://www.w3schools.com/xml/tempconvert.asmx";
//
//        try {
////            创建soapObject,即拼装soap bodyin
//            SoapObject Request = new SoapObject(NAMESPACE, METHOD_NAME);
////            添加传入参数，根据具体格式测试
//            Request.addProperty("Celsius", getCel);
////            创建soap 数据
//            SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER10);
//            soapEnvelope.dotNet = true;
//            soapEnvelope.setOutputSoapObject(Request);
//
//            HttpTransportSE transport = new HttpTransportSE(URL);
////          soap 协议发送
//            transport.call(SOAP_ACTION, soapEnvelope);
////            soap 请求完成后返回数据并转换成字符串
//            resultString = (SoapPrimitive) soapEnvelope.getResponse();
//
//            Log.i(TAG, "Result Celsius: " + resultString);
//        } catch (Exception ex) {
//            Log.e(TAG, "Error: " + ex.getMessage());
//        }
//    }
//
//}