package com.example.administrator.abouttime.Write;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.example.administrator.abouttime.MainList.ListActivity;
import com.example.administrator.abouttime.R;
import com.example.administrator.abouttime.domain.IFeelGood;
import com.example.administrator.abouttime.domain.Lab;

public class WriteActivity extends AppCompatActivity {

    EditText title, content;
    String getTitle, getContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);

        title = (EditText) findViewById(R.id.writeTitle);
        content = (EditText) findViewById(R.id.writeContent);

        getTitle = title.getText().toString();
        getContent = title.getText().toString();

        findViewById(R.id.writeSave).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IFeelGood good = new IFeelGood();
                good.title = getTitle;
                good.content = getContent;

                Lab.iFeelGoodList.add(good);

                Intent intent = new Intent(getApplicationContext(), ListActivity.class);
                startActivity(intent);
                finish();
            }
        });

        findViewById(R.id.writeCancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ListActivity.class);
                startActivity(intent);
                finish();
            }
        });



    }
}
