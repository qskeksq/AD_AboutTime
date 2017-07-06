package com.example.administrator.myapplication;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.administrator.myapplication.Util.AlarmReceiver;

public class MainActivity extends AppCompatActivity {

    Button one, cycle, stop;

    AlarmManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        one = (Button) findViewById(R.id.one);
        cycle = (Button) findViewById(R.id.cycle);
        stop = (Button) findViewById(R.id.stop);

        one.setOnClickListener(listener);
        cycle.setOnClickListener(listener);
        stop.setOnClickListener(listener);

//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON
//                | WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD
//                | WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON
//                | WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED);

//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON
//                | WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED
//                | WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);


//        registerReceiver(new AlarmReceiver(), new IntentFilter(ALARM_SERVICE))


    }

    public void oneAlarm(){

        manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        Intent intent = new Intent(this, AlarmReceiver.class);
        intent.putExtra("msg", "일어나세요");

        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, intent, 0);

        manager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+5000, pendingIntent);
//        Toast.makeText(this, "확인", Toast.LENGTH_SHORT).show();
    }

    int count;
    public void cycleAlarm(){

        manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        Intent intent = new Intent(this, Alarm.class);
        intent.putExtra("msg", count);

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        manager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+5000, 1000, pendingIntent);


        count++;
    }

    public void cancelAlarm(){
        Intent intent = new Intent(this, MainActivity.class);

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        manager.cancel(pendingIntent);
    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.one:
                    oneAlarm();
                    break;
                case R.id.cycle:
                    cycleAlarm();
                    break;
                case R.id.stop:
                    cancelAlarm();
                    break;
            }
        }
    };


}
