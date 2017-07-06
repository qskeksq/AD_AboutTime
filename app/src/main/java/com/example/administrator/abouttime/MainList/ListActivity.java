package com.example.administrator.abouttime.MainList;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.administrator.abouttime.M.HowIsYourDay;
import com.example.administrator.abouttime.M.IFeelGood;
import com.example.administrator.abouttime.MainList.expandable.ListAdapter;
import com.example.administrator.abouttime.R;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<HowIsYourDay> list;
    ListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1.
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        // 2.
        setData();

        // 3.
        adapter = new ListAdapter(list, this);

        // 4.
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    private void setData() {
        list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            List<IFeelGood> temp = new ArrayList<>();
            temp.add(new IFeelGood("1"));
            temp.add(new IFeelGood("2"));
            temp.add(new IFeelGood("3"));
            list.add(new HowIsYourDay(i+1+"", temp));
            Log.e("몇번", i+"");
        }
    }
}
