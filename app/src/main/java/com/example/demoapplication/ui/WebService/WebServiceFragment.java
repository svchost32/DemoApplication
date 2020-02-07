package com.example.demoapplication.ui.WebService;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.demoapplication.R;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.io.IOException;
import java.net.MalformedURLException;


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

    @Override
    public void onViewCreated (@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBtnws = getActivity().findViewById(R.id.btn_ws);
        et_wsadr = getActivity().findViewById(R.id.et_wsaddr);
        textResult = getActivity().findViewById(R.id.Text_dataoutput);
        et_wscont = getActivity().findViewById(R.id.et_wscontent);
        mBtnws.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



//                httprequesttask task = new httprequesttask();
//                task.Textviewset(textResult);
//                task.execute();
//                Toast.makeText(getActivity(),task.getStr(),Toast.LENGTH_SHORT).show();
//                textResult.setText(task.getStr());
                Client2 c2 = new Client2();
                try {

                    Toast.makeText(getActivity(),c2.getdata(),Toast.LENGTH_SHORT).show();
                } catch (MalformedURLException e) {
                    Toast.makeText(getActivity(),"获取失败",Toast.LENGTH_SHORT).show();
                }
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

