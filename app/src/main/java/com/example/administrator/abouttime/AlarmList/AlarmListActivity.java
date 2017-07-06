package com.example.administrator.abouttime.AlarmList;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.example.administrator.abouttime.R;
import com.example.administrator.abouttime.domain.Alarm;

import java.util.List;

public class AlarmListActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Alarm> data;
    AlarmListAdapter alarmListAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_list);

        // 1.
        recyclerView = (RecyclerView) findViewById(R.id.alarmList);

        // 2.


        // 3.
//        alarmListAdapter = new AlarmListAdapter2();

        // 4.
//        recyclerView.setAdapter(alarmListAdapter);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }
}
