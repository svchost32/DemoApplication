package com.example.demoapplication.ui.login;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.demoapplication.Bean.LoginData;

public class LoginViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public LoginViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("You are already login.");
    }

    public LiveData<String> getText() {
        return mText;
    }


    private MutableLiveData<LoginData> mLoginData = new MutableLiveData<>();

    public LiveData<LoginData> mLoginD = mLoginData;

    public void loginUser(LoginData login) {
        //处理网络请求开始

        //假设登录成功
        mLoginData.setValue(login);//保存用户账号密码
    }
}