package com.example.administrator.abouttime.Detail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.administrator.abouttime.R;

import static com.example.administrator.abouttime.MainList.expandable.IFeelGoodHolder.CHILD_POSITION;
import static com.example.administrator.abouttime.MainList.expandable.IFeelGoodHolder.PARENT_POSITION;

public class DetailActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        int child = getIntent().getIntExtra(CHILD_POSITION, 0);
        String parent = getIntent().getStringExtra(PARENT_POSITION);

        textView = (TextView) findViewById(R.id.textView2);

        textView.setText(child+"/"+parent);
    }



}
