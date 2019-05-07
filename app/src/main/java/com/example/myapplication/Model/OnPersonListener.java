package com.example.myapplication.Model;

import com.example.myapplication.Bean.Person;

public interface OnPersonListener {
    void onSuccess(Person person);//定义onSuccess，onFailure两个方法
    void onFailure();
}
