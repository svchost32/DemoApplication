package com.example.demoapplication.ui.WebService;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.demoapplication.R;
import com.example.demoapplication.ui.WebService.Model.WebModel;


public class WebServiceFragment extends Fragment {

    private WebServiceViewModel galleryViewModel;
    private Button mBtnws;
    private EditText et_wsadr;
    private EditText et_wscont;
    private TextView textResult;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
//        galleryViewModel =
//                ViewModelProviders.of(this).get(WebServiceViewModel.class);
        View root = inflater.inflate(R.layout.fragment_webservice, container, false);

        return root;
    }

    private WebModel model;

    private static final String TAG = "WebServiceFragment";
    @Override
    public void onViewCreated (@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        model= ViewModelProviders.of(this).get(WebModel.class);

        mBtnws = getActivity().findViewById(R.id.btn_ws);
        et_wsadr = getActivity().findViewById(R.id.et_wsaddr);
        textResult = getActivity().findViewById(R.id.Text_dataoutput);
        et_wscont = getActivity().findViewById(R.id.et_wscontent);

        model.simpledata.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Log.d(TAG, "onChanged: "+s);
            }
        });

        mBtnws.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                try {
//                    model.requestWeb();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }

//                httprequesttask task = new httprequesttask();
//                task.execute();
//                System.out.println(task.getStr());
//                textResult.setText("hello");
//                new CXFtest().execute("String");




//                CXFtest c1 = new CXFtest();
//                Toast.makeText(getActivity(),c1.getdata("000"),Toast.LENGTH_SHORT).show();
//                textResult.setText(c1.getdata("000"));
//                DataServiceClient ds1 = new DataServiceClient();
//                ds1.getData("hello");
//                Toast.makeText(getActivity(),"Hello",Toast.LENGTH_SHORT).show();

//                httprequesttask task = new httprequesttask();
//                task.Textviewset(textResult);
//                task.execute();
//                Toast.makeText(getActivity(),task.getStr(),Toast.LENGTH_SHORT).show();
//                textResult.setText(task.getStr());
//                Client2 c2 = new Client2();
//                try {
//
//                    Toast.makeText(getActivity(),c2.getdata(),Toast.LENGTH_SHORT).show();
//                } catch (MalformedURLException e) {
//                    Toast.makeText(getActivity(),"获取失败",Toast.LENGTH_SHORT).show();
//                }
//                c2.Textviewset(textResult);
//                c2.execute();
//                Toast.makeText(getActivity(),c2.getStr1(),Toast.LENGTH_SHORT).show();
//                try {
//                    Toast.makeText(getActivity(),c2.getdata(),Toast.LENGTH_SHORT).show();
//                } catch (MalformedURLException e) {
//                    Toast.makeText(getActivity(),"执行错误",Toast.LENGTH_SHORT).show();
//                }


                //Toast.makeText(getActivity(),"被执行了",Toast.LENGTH_SHORT).show();

//                String phoneSec = et_wsadr.getText().toString().trim();
//                // 简单判断用户输入的手机号码（段）是否合法
//                if ("".equals(phoneSec) || phoneSec.length() < 7) {
//                    // 给出错误提示
//                    et_wsadr.setError("您输入的手机号码（段）有误！");
//                    et_wsadr.requestFocus();
//                    // 将显示查询结果的TextView清空
//                    et_wscont.setText("");
//                    return;
//                }
            }
        });
    }

//    class CallWebService extends AsyncTask<String, Void, String> {
//        @Override
//        protected void onPostExecute(String s) {
//            et_wscont.setText("Square = " + s);
//        }
//
//        @Override
//        protected String doInBackground(String... params) {
//            String result = "";
//
//            SoapObject soapObject = new SoapObject("", "");
//
//            PropertyInfo propertyInfo = new PropertyInfo();
//            propertyInfo.setName(PARAMETER_NAME);
//            propertyInfo.setValue(params[0]);
//            propertyInfo.setType(String.class);
//
//            soapObject.addProperty(propertyInfo);
//
//            SoapSerializationEnvelope envelope =  new SoapSerializationEnvelope(SoapEnvelope.VER11);
//            envelope.setOutputSoapObject(soapObject);
//
//            HttpTransportSE httpTransportSE = new HttpTransportSE(URL);
//
//            try {
//                httpTransportSE.call(SOAP_ACTION, envelope);
//                SoapPrimitive soapPrimitive = (SoapPrimitive)envelope.getResponse();
//                result = soapPrimitive.toString();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//            return result;
//        }
//    }
}

