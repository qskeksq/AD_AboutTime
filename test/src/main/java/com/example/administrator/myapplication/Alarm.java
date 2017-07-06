package com.example.administrator.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.administrator.myapplication.Util.WakeLock;

public class Alarm extends AppCompatActivity implements TextToSpeech.OnInitListener{

    TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON
                | WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD
                | WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON
                | WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED);

        int count = getIntent().getIntExtra("msg", 0);
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(count+"");

        WakeLock.releaseCpuLock();

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MainActivity.class);
                v.getContext().startActivity(intent);
            }
        });

        tts = new TextToSpeech(this, this);


    }

    @Override
    public void onInit(int status) {
        tts.speak("이이이이이이이이이이이이이이이이이이이이이야아아아아아아아아   기기기기기기기기기기부부부부부부부분이이이이이이이이이이이 좋오오오오오오오오오오오오오오오오오오오오아", TextToSpeech.QUEUE_FLUSH, null);
        tts.speak("", TextToSpeech.QUEUE_ADD, null);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        tts.shutdown();
    }
}
