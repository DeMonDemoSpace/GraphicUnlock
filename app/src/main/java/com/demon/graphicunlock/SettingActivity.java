package com.demon.graphicunlock;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.demon.graphicunlock.util.SPUtil;
import com.demon.graphicunlock.widget.GraphicLockView;

public class SettingActivity extends AppCompatActivity {
    private GraphicLockView graphicLockView;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        text = findViewById(R.id.tv_text);
        text.setText("绘制解锁图案");
        graphicLockView = findViewById(R.id.lock_view);
        graphicLockView.setOnGraphicLockListener(new GraphicLockView.OnGraphicLockListener() {

            @Override
            public void LockSuccess(int what, String password) {
                if (what == 0) {
                    GraphicLockView.mPassword = password;
                    text.setText("再次绘制解锁图案");
                } else {
                    SPUtil.put(SettingActivity.this, "PASSWORD", password);
                    SettingActivity.this.finish();
                }
            }

            @Override
            public void LockFailure() {
                text.setText("与上次绘制的不一致");
            }

            @Override
            public void LockShort() {
                text.setText("最少连接4个点");
            }
        });
    }
}
