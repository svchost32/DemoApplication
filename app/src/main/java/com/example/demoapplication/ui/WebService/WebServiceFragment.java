package com.example.demoapplication.ui.WebService;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.demoapplication.R;


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
}

