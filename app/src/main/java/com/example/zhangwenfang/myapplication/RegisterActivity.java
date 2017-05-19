package com.example.zhangwenfang.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by zhangwenfang on 2017/5/7.
 */

public class RegisterActivity extends AppCompatActivity {
    private Button registerButoon;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        registerButoon=(Button)findViewById(R.id.button_register);
        registerButoon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                EventBus.getDefault().post(new LoginSuccessdEvent("mxyang"));
            }
        });
    }
}
