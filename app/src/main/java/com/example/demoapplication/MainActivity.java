package com.example.demoapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.ui.AppBarConfiguration;

import com.example.demoapplication.Interface.LoginCallback;
import com.example.demoapplication.ui.RealTime.RealtimeFragment;
import com.example.demoapplication.ui.WebService.WebServiceFragment;
import com.example.demoapplication.ui.login.LoginFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import static com.example.demoapplication.ui.Other.AllType.KEY_ISLOGIN;
import static com.example.demoapplication.ui.Other.AllType.KEY_SP_NAME;
import static com.example.demoapplication.ui.Other.AllType.KEY_USERNAME;

//import com.example.demoapplication.ui.WebService.TestActivity;

//import com.example.demoapplication.ui.WebService.TestActivity;

public class MainActivity extends AppCompatActivity implements LoginCallback {
    private PopupMenu p1;
    private Button btn_p1;

    private AppBarConfiguration mAppBarConfiguration;
    private FragmentManager mManage;

    Fragment mloginf = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mManage = getSupportFragmentManager();//此类是用来切换fragment的

        mTips = findViewById(R.id.tips);
        mUserID = findViewById(R.id.home_userid);
        mHome = findViewById(R.id.tv_home);
        mRealtime = findViewById(R.id.tv_Realtime);
        mHomeUser = findViewById(R.id.tv_mHome);
        mUserName = findViewById(R.id.home_username);
        final DrawerLayout drawer = findViewById(R.id.drawer_layout);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawer.openDrawer(Gravity.LEFT);
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        mloginf = new LoginFragment(this);//新建一个登录fragment  md  第一次见这种登录方式
        final Fragment mWS = new WebServiceFragment();
        final Fragment mRT = new RealtimeFragment();





        //LinearLayout tv_home = findViewById(R.id.tv_home);
        ImageView iv_home = findViewById(R.id.iv_login);

        iv_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getSP().getBoolean(KEY_ISLOGIN, false)) {
                    drawer.closeDrawer(Gravity.LEFT);
                    return;//解决方法二:登陆成功后就不再去replace了
                }
                //创建碎片实例
                //之前用的是add方法，由于这个login实例已经被add了，再次add会error.
                //用replace可；
                mManage.beginTransaction().replace(R.id.mContent, mloginf).commit();
                drawer.closeDrawer(Gravity.LEFT);//关闭侧滑栏 手动切换必须主动关闭侧滑栏
            }
        });


        //Webservice

        LinearLayout tv_ws = findViewById(R.id.tv_ws_menu);
        tv_ws.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getSP().getBoolean(KEY_ISLOGIN, false)) {

                    mManage.beginTransaction().replace(R.id.mContent,mWS).commit();
                    drawer.closeDrawer(Gravity.LEFT);//关闭侧滑栏 手动切换必须主动关闭侧滑栏
                }
            }
        });

        //Realtime
        LinearLayout tv_rt = findViewById(R.id.tv_Realtime);
        tv_rt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getSP().getBoolean(KEY_ISLOGIN, false)) {
                    mManage.beginTransaction().replace(R.id.mContent,mRT).commit();
                    drawer.closeDrawer(Gravity.LEFT);//关闭侧滑栏 手动切换必须主动关闭侧滑栏
                }

            }
        });



        //进入界面时,开始从本地读取数据
        initializationUI();
        return;
//        NavigationView navigationView = findViewById(R.id.nav_view);
//
//
//
//        // Passing each menu ID as a set of Ids because each
//        // menu should be considered as top level destinations.
//        mAppBarConfiguration = new AppBarConfiguration.Builder(
//                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,
//                R.id.nav_tools, R.id.nav_share, R.id.nav_send)
//                .setDrawerLayout(drawer)
//                .build();
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
//        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
//        NavigationUI.setupWithNavController(navigationView, navController);
    }

    private TextView mUserID;
    private LinearLayout mHome;
    private TextView mUserName;
    private TextView mHomeUser;
    private TextView mTips;
    private LinearLayout mRealtime;


    /**
     * 接口方法实现了来自fragment碎片的接口回调 这种回调方法会引起内存泄露
     *
     * @param isSucc
     * @param errStr
     */



    @Override
    public void loginResult(Boolean isSucc, String errStr) {
        //登陆成功 开始设置数据
        initializationUI();
    }

    SharedPreferences getSP() {
        return getSharedPreferences(KEY_SP_NAME, Context.MODE_PRIVATE);
    }

    /**
     * 当活动被启动时 开始加载初始化数据来在页面上显示
     */
    void initializationUI() {
        //检查是否用户已经登录
        boolean isLogin = getSP().getBoolean(KEY_ISLOGIN, false);
        if (isLogin) {//如果用户登录标记为true则开始读取用户名等数据
            String username = getSP().getString(KEY_USERNAME, "");
            //String pass = getSP().getString(KEY_PASSWORD, "");
            //数据读取完毕 开始设置UI
            //解决登陆成功后登录窗口依旧留存在界面的问题
            mManage.beginTransaction().remove(mloginf).commit();
            mUserName.setText("Hello " + username + "!");
            mUserID.setText("UID:00001");
            mHomeUser.setText("Home ^ " + username);
            mTips.setText("Current Login User :" + username);
        }
    }


}
