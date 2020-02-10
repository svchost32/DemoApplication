package com.example.demoapplication.ui.RealTime;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.demoapplication.R;

public class RealtimeFragment extends Fragment {

    private WebView realtimeWebView;
    private Button mBtnT1,mBtnT2,mBtnT3,mBtnT4;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState){
        View root = inflater.inflate(R.layout.fragment_realtime, container, false);

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        realtimeWebView = getActivity().findViewById(R.id.rt_wv);
        realtimeWebView.getSettings().setJavaScriptEnabled(true);
        realtimeWebView.setWebViewClient(new myWebViewClien());
        realtimeWebView.loadUrl("file:///android_asset/html/index2.html");

        super.onViewCreated(view, savedInstanceState);
        mBtnT1 = getActivity().findViewById(R.id.topic1);
        mBtnT2 = getActivity().findViewById(R.id.topic2);
        mBtnT3 = getActivity().findViewById(R.id.topic3);
        mBtnT4 = getActivity().findViewById(R.id.topic4);
        mBtnT1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realtimeWebView.loadUrl("file:///android_asset/html/area-rainfall.html");
            }
        });
        mBtnT2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realtimeWebView.loadUrl("file:///android_asset/html/transparent-bar3d.html");
            }
        });
        mBtnT3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realtimeWebView.loadUrl("file:///android_asset/html/test/tree-polyline.html");
            }
        });
        mBtnT4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realtimeWebView.loadUrl("file:///android_asset/html/index.html");
                Toast.makeText(getActivity(),"Not ready",Toast.LENGTH_SHORT).show();
            }
        });


    }

    class myWebViewClien extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            view.loadUrl(request.getUrl().toString());
            return true;
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            Log.d("WebView", "onPageStarted: ");
        }


        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            Log.d("WebView", "onPageFinished: ");
//            mWvmain.loadUrl("javascript:alert('Hello')",null);
            realtimeWebView.evaluateJavascript("javascript:alert('Hello')",null);
        }


    }


//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        if (keyCode == KeyEvent.KEYCODE_BACK&&realtimeWebView.canGoBack()){
//            realtimeWebView.goBack();
//            return true;
//        }
//        return super.onKeyDown(keyCode, event);
//    }


}
