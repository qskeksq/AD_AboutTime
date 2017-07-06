package com.example.administrator.abouttime.MainList;

import android.app.AlarmManager;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.administrator.abouttime.AlarmList.AlarmListAdapter;
import com.example.administrator.abouttime.MainList.Expandable2.AlarmListAdapter2;
import com.example.administrator.abouttime.MainList.expandable.ListAdapter;
import com.example.administrator.abouttime.R;
import com.example.administrator.abouttime.Write.ShowAlarm;
import com.example.administrator.abouttime.domain.Alarm;
import com.example.administrator.abouttime.domain.HowIsYourDay;
import com.example.administrator.abouttime.domain.IFeelGood;
import com.example.administrator.abouttime.domain.Lab;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ListActivity extends AppCompatActivity {

    RecyclerView recyclerView, recyclerView2;
    List<HowIsYourDay> list;
    ListAdapter adapter;
    AlarmListAdapter2 alarmListAdapter2;
    Button alarm;

    Switch aSwitch;

    AlertDialog.Builder dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aSwitch = (Switch) findViewById(R.id.switch1);

        // 1.
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView2 = (RecyclerView) findViewById(R.id.recyclerViewHour);
        // 2.
        setData();

        // 3.
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(!isChecked){
                    recyclerView.setVisibility(View.VISIBLE);
                    recyclerView2.setVisibility(View.GONE);
                    adapter = new ListAdapter(list, ListActivity.this);
                    recyclerView.setAdapter(adapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(ListActivity.this));
                } else {
                    recyclerView.setVisibility(View.GONE);
                    recyclerView2.setVisibility(View.VISIBLE);
                    alarmListAdapter2 = new AlarmListAdapter2(Lab.alarmList);
                    recyclerView2.setAdapter(alarmListAdapter2);
                    recyclerView2.setLayoutManager(new LinearLayoutManager(ListActivity.this));
                }
            }
        });


        alarm = (Button) findViewById(R.id.clock);
        alarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alarmDialog();
            }
        });



    }

    private void setData() {
        list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            List<IFeelGood> temp = new ArrayList<>();
            temp.add(new IFeelGood("1"));
            temp.add(new IFeelGood("2"));
            temp.add(new IFeelGood("3"));
            list.add(new HowIsYourDay(UUID.randomUUID()+"", temp));
        }

    }


    public void alarmDialog(){

//        View view = LayoutInflater.from(this).inflate(R.layout.alarm_dialog, this , false);
//        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        final Dialog dialog1 = new Dialog(this);
        dialog1.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        dialog1.setContentView(R.layout.alarm_dialog);
        dialog1.show();
        dialog1.getWindow().setLayout(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);

//        List<Alarm> data = new ArrayList<>();
//        data.add(new Alarm("9'o clock", "Morning Coffee"));
//        data.add(new Alarm("1'0 clock", "Lunch Meal"));
//        data.add(new Alarm("6'0 clock", "Way back home"));
        List<Alarm> data = Lab.alarmList;


        RecyclerView recyclerView = (RecyclerView) dialog1.findViewById(R.id.alarmList);
        final AlarmListAdapter alarmListAdapter= new AlarmListAdapter(data);
        recyclerView.setAdapter(alarmListAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        Button add = (Button) dialog1.findViewById(R.id.btnAdd);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Dialog dialog2 = new Dialog(getApplicationContext());
//                dialog2.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
//                dialog2.setContentView(R.layout.add_alarm);
//                dialog2.show();
//                dialog2.getWindow().setLayout(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);

                View view = LayoutInflater.from(ListActivity.this).inflate(R.layout.add_alarm, null);
                final TimePicker timePicker = (TimePicker) view.findViewById(R.id.timePicker);
                final EditText editText = (EditText) view.findViewById(R.id.addContent);
                dialog = new AlertDialog.Builder(ListActivity.this);
                dialog.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dialog.setPositiveButton("CONFIRM", new DialogInterface.OnClickListener() {
                    @RequiresApi(api = Build.VERSION_CODES.M)
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Alarm alarm = new Alarm();
                        int hour = timePicker.getHour();
                        int minute = timePicker.getMinute();
                        String title = editText.getText().toString();
                        alarm.hour = hour;
                        alarm.minute = minute;
                        alarm.content = title;
                        Toast.makeText(getApplicationContext(), hour+"/"+minute+"/"+title, Toast.LENGTH_SHORT).show();
                        Lab.alarmList.add(alarm);

                        AlarmManager manager3 = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

                        Intent intent3 = new Intent(getApplicationContext(), ShowAlarm.class);
                        intent3.putExtra("hour", hour);
                        intent3.putExtra("minute", minute);

                        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, intent3, 0);

                        manager3.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+5000 ,pendingIntent);

                        alarmListAdapter.notifyDataSetChanged();
                    }
                });
                dialog.setView(view);
                dialog.show();




            }
        });


//        dialog.setView(view);
//        dialog.show();

//        View view = getLayoutInflater().
//                inflate(R.layout.alarm_dialog, null);
//
//        // Inflate된 View에서 Resource(ViewGroup) 얻어 오기~!
//        RelativeLayout bg = (RelativeLayout) view.findViewById(R.id.relative);
//        bg.setBackgroundColor(Color.GREEN);
//
//        // Inflate된 View에서 Child인 TextView를 얻어 오기
//        CardView tv = (CardView) view.findViewById(R.id.cardVIew);
//
//        tv.setGravity(Gravity.CENTER);
//
//        // Child View인 TextView 속성 재정의 하기 (부모의 속성을 얻어옴)
//        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams)
//                tv.getLayoutParams();
//
//        params.width = RelativeLayout.LayoutParams.MATCH_PARENT;
//        params.height = RelativeLayout.LayoutParams.WRAP_CONTENT;
//
//        tv.setLayoutParams(params);

//        Intent intent = new Intent(this, AlarmListActivity.class);
//        startActivity(intent);

    }




}
