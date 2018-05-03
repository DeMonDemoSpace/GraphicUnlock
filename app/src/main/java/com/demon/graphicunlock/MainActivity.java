package com.demon.graphicunlock;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.demon.graphicunlock.util.SPUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_setting).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password = (String) SPUtil.get(MainActivity.this, "PASSWORD", "");
                if (TextUtils.isEmpty(password)) {
                    startActivity(new Intent(MainActivity.this, SettingActivity.class));
                } else {
                    Toast.makeText(MainActivity.this, "图形密码已设置，若想重新设置，请先重置！", Toast.LENGTH_SHORT).show();
                }
            }
        });

        findViewById(R.id.btn_unlock).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password = (String) SPUtil.get(MainActivity.this, "PASSWORD", "");
                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(MainActivity.this, "请先设置图形密码！", Toast.LENGTH_SHORT).show();
                } else {
                    startActivity(new Intent(MainActivity.this, UnlockActivity.class));
                }
            }
        });

        findViewById(R.id.btn_clear).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SPUtil.clear(MainActivity.this);
                Toast.makeText(MainActivity.this, "图形密码已重置！", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
