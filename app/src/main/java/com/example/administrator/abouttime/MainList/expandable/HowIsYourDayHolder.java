package com.example.administrator.abouttime.MainList.expandable;

import android.view.View;
import android.widget.TextView;

import com.example.administrator.abouttime.R;
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

/**
 * Created by Administrator on 2017-07-06.
 */

public class HowIsYourDayHolder extends GroupViewHolder{

    private TextView day, date, title;

    public HowIsYourDayHolder(View itemView) {
        super(itemView);
        day = (TextView) itemView.findViewById(R.id.listDay);
        date = (TextView) itemView.findViewById(R.id.listDate);
        title = (TextView) itemView.findViewById(R.id.listTitle);
    }

    public void setDay(String day) {
        this.day.setText(day);
    }

    public void setDate(String date) {
        this.date.setText(date);
    }

    public void setTitle(String title) {
        this.title.setText(title);
    }
}
