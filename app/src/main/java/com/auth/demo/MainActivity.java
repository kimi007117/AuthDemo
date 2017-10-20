package com.auth.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.kimi.login.sdk.GanJiAuth;

public class MainActivity extends AppCompatActivity {
    private TextView mTextViewUrl;
    private TextView mTextViewName;
    private Button mButtonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextViewUrl = (TextView) findViewById(R.id.tv_url);
        mTextViewName = (TextView) findViewById(R.id.tv_name);
        mButtonLogin = (Button) findViewById(R.id.btn_login);
        mButtonLogin.setOnClickListener(mOnClickListener);
    }

    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            // 登录操作
            GanJiAuth.getInstance().login("100", MainActivity.this, new GanJiAuth.OnGanJiAuthListener() {
                @Override
                public void onComplete(String url, String token, String error) {
                    Toast.makeText(MainActivity.this, error, Toast.LENGTH_SHORT).show();
                }
            });
        }
    };
}
