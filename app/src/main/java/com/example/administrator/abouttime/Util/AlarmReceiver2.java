package com.example.administrator.abouttime.Util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.example.administrator.abouttime.Write.ShowAlarm;

/**
 * Created by Administrator on 2017-07-07.
 */

public class AlarmReceiver2 extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

//        int hour = intent.getExtras().getInt("hour");
//        int minute = intent.getExtras().getInt("minute");
//
//        Log.e("확인", hour+"/"+minute);

        Toast.makeText(context, "확인", Toast.LENGTH_SHORT).show();

        Intent intent1 = new Intent(context, ShowAlarm.class);
        intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        WakeLock.acquireCpuWakeLock(context);
        context.startActivity(intent1);


    }
}
