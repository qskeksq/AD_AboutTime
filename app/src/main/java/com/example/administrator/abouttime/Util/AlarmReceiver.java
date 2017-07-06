package com.example.administrator.abouttime.Util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.example.administrator.abouttime.domain.Alarm;

/**
 * Created by Administrator on 2017-07-07.
 */

public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Intent intent1 = new Intent(context, Alarm.class);
        intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        WakeLock.acquireCpuWakeLock(context);
        context.startActivity(intent1);


    }
}
