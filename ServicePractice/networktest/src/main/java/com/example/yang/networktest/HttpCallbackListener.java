package com.example.yang.networktest;

/**
 * Created by Yang on 2015/6/9.
 */
public interface HttpCallbackListener {
    void onFinish(String response);

    void onError(Exception e);
}
