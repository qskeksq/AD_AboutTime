package com.example.administrator.abouttime.Write;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.administrator.abouttime.R;
import com.example.administrator.abouttime.Util.WakeLock;

public class ShowAlarm extends AppCompatActivity {

    TextView cancel, write, time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_alarm);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON
                | WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD
                | WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON
                | WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED);

        Vibrator vi = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        vi.vibrate(3000);

//        time = (TextView) findViewById(R.id.showTime);
//
//        String hour = getIntent().getStringExtra("hour");
//        String minute = getIntent().getStringExtra("minute");
//        time.setText(hour+":"+minute);

        cancel = (TextView) findViewById(R.id.showCancel);
        write = (TextView) findViewById(R.id.showWrite);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WakeLock.releaseCpuLock();
                Intent intent = new Intent(ShowAlarm.this, WriteActivity.class);
                startActivity(intent);
                finish();
            }
        });

        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WakeLock.releaseCpuLock();
                Intent intent = new Intent(ShowAlarm.this, WriteActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }
}
