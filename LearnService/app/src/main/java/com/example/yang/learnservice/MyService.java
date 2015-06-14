package com.example.yang.learnservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return new Binder();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        new Thread(){
            @Override
            public void run() {
                super.run();

                    while (true){
                    Log.d("service running", "service running");

                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();


        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println("service create");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        System.out.println("service destory");
    }
}
