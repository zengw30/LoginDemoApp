package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.activity.ResultActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button signbtn=findViewById(R.id.btn);
        signbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = ((EditText)findViewById(R.id.username)).getText().toString();//获取用户名输入框中的信息
                String pwd = ((EditText)findViewById(R.id.password)).getText().toString();//获取密码输入框中的信息

                if(username.equals("17023144")&&pwd.equals("password17023144")){  //判断用户所输入的用户名是否为android，密码是否为2014
                    Toast.makeText(MainActivity.this,getString(R.string.welcome),Toast.LENGTH_LONG).show();//两者都正确则显示登陆成功
                    Intent intent=new Intent();
                    intent.setClass(MainActivity.this, ResultActivity.class);
                    startActivity(intent);
                }else{  //否则则显示登陆失败
                    Toast.makeText(MainActivity.this,getString(R.string.loser),Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
