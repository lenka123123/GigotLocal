package dong.com.chat.ui;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import dong.com.chat.MainActivity;
import dong.com.chat.R;
import dong.com.chat.bean.User;
import dong.com.chat.bean.model.UserModel;

/**
 * 创建日期：2018/6/12 on 14:53
 * 描述:
 * 作者:yuxd Administrator
 */

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Handler handler =new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                User user = UserModel.getInstance().getCurrentUser();
                log("正在登陆");

                log("");
                if (user == null) {
                   startActivity(LoginActivity.class,null,true);
                }else{
                    startActivity(MainActivity.class,null,true);
                }
            }
        },1000);

    }
}
