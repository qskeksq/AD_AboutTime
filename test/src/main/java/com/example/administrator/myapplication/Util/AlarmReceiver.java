package com.example.administrator.myapplication.Util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.example.administrator.myapplication.Alarm;

public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Toast.makeText(context, "확인", Toast.LENGTH_SHORT).show();
        Intent intent1 = new Intent(context, Alarm.class);
        intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        WakeLock.acquireCpuWakeLock(context);
        context.startActivity(intent1);


    }
}
