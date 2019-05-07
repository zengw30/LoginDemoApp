package com.example.myapplication.Model;

import com.example.myapplication.Bean.Person;

public class PersonModelImpl implements PersonModle{

    public void Login(Person person, OnPersonListener onPersonListener) {
         //判断用户所输入的用户名是否为17023144，密码是否为password17023144
        if(person.getUsername().equals("17023144")&&person.getPassword().equals("password17023144")){
            onPersonListener.onSuccess(person);//登陆成功则进行登录成功所进行的操作
        }else {
            onPersonListener.onFailure();//登陆失败则进行登录失败所进行的操作
        }

    }
}
