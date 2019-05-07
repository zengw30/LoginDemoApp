package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.myapplication.Bean.Person;
import com.example.myapplication.Model.OnPersonListener;
import com.example.myapplication.Model.PersonModelImpl;
import com.example.myapplication.activity.ResultActivity;

public class MainActivity extends AppCompatActivity implements OnPersonListener,View.OnClickListener{

    private EditText et_username;
    private EditText et_password;
    private PersonModelImpl personModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        personModel = new PersonModelImpl();
    }

    //控件初始化
    private void init() {
        et_username = (EditText) findViewById(R.id.username);
        et_password = (EditText) findViewById(R.id.password);
        Button btn_login = (Button) findViewById(R.id.btn);
        btn_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String username = et_username.getText().toString();//获取用户名中的信息
        String password = et_password.getText().toString();//获取密码框中的信息
        Person person = new Person();
        person.setUsername(username);
        person.setPassword(password);
        personModel.Login(person, this);
    }

    @Override
    public void onSuccess(Person person) {
        Toast.makeText(this, getString(R.string.xinxi), Toast.LENGTH_SHORT).show();//成功登录显示登陆成功信息
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, ResultActivity.class);
        startActivity(intent);//成功登录则跳转到下一个页面
    }

    @Override
    public void onFailure() {
        Toast.makeText(this, getString(R.string.loser), Toast.LENGTH_SHORT).show();//登录失败显示登陆失败信息
    }
}
