package com.example.myapplication;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class services extends Service {

    private static final String TAG = "MyBackgroundService";
    private Handler handler;
    private Runnable runnable;

    @Override
    public void onCreate() {
        super.onCreate();
        handler = new Handler();
        startBackgroundTask();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private void startBackgroundTask() {
        runnable = new Runnable() {
            @Override
            public void run() {
                SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
                String currenttime=sdf.format(new Date());
                Log.d(TAG, "Current time:" + currenttime);
                handler.postDelayed(this, 50000);
            }
        };
        handler.post(runnable);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(runnable);
        Log.d(TAG, "Background service destroyed.");
    }
}