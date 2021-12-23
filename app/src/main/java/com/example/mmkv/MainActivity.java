package com.example.mmkv;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.tencent.mmkv.MMKV;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView=findViewById(R.id.tv);TextView textView2=findViewById(R.id.tv2);
        EditText editText=findViewById(R.id.et);
        Button button1=findViewById(R.id.btn1);
        Button button2=findViewById(R.id.btn2);
        String rootDir = MMKV.initialize(this);
        System.out.println("mmkv root1: " + rootDir);
        System.out.println("yyg: " + rootDir);
        // 获取默认的全局实例
        MMKV kv = MMKV.defaultMMKV();
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(editText.getText().toString());
                kv.encode("1",editText.getText().toString());
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView2.setText(kv.decodeString("1"));
            }
        });






//// 根据业务区别存储, 附带一个自己的 ID
//        MMKV kv = MMKV.mmkvWithID("MyID");
//
//// 多进程同步支持
//        MMKV kv = MMKV.mmkvWithID("MyID", MMKV.MULTI_PROCESS_MODE);


    }
}