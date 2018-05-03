package com.demon.graphicunlock;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.demon.graphicunlock.widget.GraphicLockView;

public class UnlockActivity extends AppCompatActivity {
    private GraphicLockView graphicLockView;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        text = findViewById(R.id.tv_text);
        text.setText("请输入手势密码");
        graphicLockView = findViewById(R.id.lock_view);
        graphicLockView.setOnGraphicLockListener(new GraphicLockView.OnGraphicLockListener() {

            @Override
            public void LockSuccess(int what, String password) {
                text.setText("解锁成功");
            }

            @Override
            public void LockFailure() {
                text.setText("密码错误");
            }

            @Override
            public void LockShort() {
                text.setText("最少连接4个点");
            }
        });
    }
}