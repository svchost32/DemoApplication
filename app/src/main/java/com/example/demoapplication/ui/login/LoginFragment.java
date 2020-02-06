package com.example.demoapplication.ui.login;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.hardware.input.InputManager;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.demoapplication.Bean.LoginData;
import com.example.demoapplication.Interface.LoginCallback;
import com.example.demoapplication.MainActivity;
import com.example.demoapplication.R;
import com.example.demoapplication.ui.Other.AllType;

import org.w3c.dom.Text;

import static androidx.core.content.ContextCompat.getSystemService;
import static com.example.demoapplication.ui.Other.AllType.KEY_ISLOGIN;
import static com.example.demoapplication.ui.Other.AllType.KEY_PASSWORD;

public class LoginFragment extends Fragment {


    private LoginCallback mCallback;
    private Context mContext;

    public LoginFragment(LoginCallback callback) {
        mCallback = callback;
    }

    private LoginViewModel shareViewModel;
    private SharedPreferences mSP;

    /**
     * 重写本方法来获取fragment的显示UI
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return 返回view对象  展示用户
     */
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_login, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);




        final Button btlogin = view.findViewById(R.id.btn_login);
        final EditText mUser = view.findViewById(R.id.loin_username);
        final EditText mPwd = view.findViewById(R.id.login_password);
        //view创建完毕后初始化所有id对象  不需在listener中fb。

        //一般事件处理开始

        if (getActivity() == null) {//有时候getactivity会返回null 做判空处理
            return;
        }
        mSP = getActivity().getSharedPreferences(AllType.KEY_SP_NAME
                , Context.MODE_PRIVATE);//初始化sp存储对象

        //下方使用viewmodel处理登录请求的实例
        shareViewModel =
                ViewModelProviders.of(this).get(LoginViewModel.class);


        //观察者模式监听登陆成功状态
        shareViewModel.mLoginD.observe(this, new Observer<LoginData>() {
            @Override
            public void onChanged(LoginData loginData) {
                //此处才是登录成功的处理回调
                //登陆成功  拿到了用户登陆成功session
                //开始本地保存
                mSP.edit().putString(AllType.KEY_USERNAME, loginData.user)
                        .putString(KEY_PASSWORD, loginData.pwd)
                        .putBoolean(KEY_ISLOGIN, true)
                        .apply();
                //首先调用edit方法获取编辑对象  然后开始根据key值存储数据
                //最后调用APPly保存到本地,否则数据是在内存中不会保存到本地.
                if (mCallback != null) {
                    mCallback.loginResult(true, "login success;");
                }
                Toast.makeText(getActivity(), loginData.user + " successful login!", Toast.LENGTH_SHORT).show();
            }
        });

        //开始监听click
        btlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                final String username = mUser.getText().toString();
                final String password = mPwd.getText().toString();

                //拿到用户输入的账号密码后  开始model处理登录

                shareViewModel.loginUser(new LoginData() {{
                    user = username;
                    pwd = password;
                }});//将获取到的账号密码喂给model 开始登录
                //警告：model是异步处理请求
                Intent intent = new Intent(getActivity(),MainActivity.class);
                startActivity(intent);
            }
        });


//        btlogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                final EditText unet = getActivity().findViewById(R.id.loin_username);
//                final EditText pwet = getActivity().findViewById(R.id.login_password);
//
//                usrntv.findViewById(R.id.loin_username);
//                pwdtv.findViewById(R.id.login_password);
//                usrn = (String) usrntv.getText();
//                pwd = (String) pwdtv.getText();
//              Toast.makeText(getActivity(),unet.getText()+" | "+pwet.getText(),Toast.LENGTH_SHORT).show();
//
//            }
//        });


    }


}