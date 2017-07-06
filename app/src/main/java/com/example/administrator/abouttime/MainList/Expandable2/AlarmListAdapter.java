package com.example.administrator.abouttime.MainList.Expandable2;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.abouttime.R;
import com.example.administrator.abouttime.domain.Alarm;

import java.util.List;

/**
 * Created by Administrator on 2017-07-07.
 */

public class AlarmListAdapter extends RecyclerView.Adapter<AlarmListAdapter.AlarmHolder> {

    List<Alarm> data;

    public AlarmListAdapter(List<Alarm> data) {

        this.data = data;
    }

    @Override
    public AlarmHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_alarm_list, parent, false);
        return new AlarmHolder(view);
    }

    @Override
    public void onBindViewHolder(AlarmHolder holder, int position) {

        Alarm alarm = data.get(position);
        holder.content.setText(alarm.content);
        holder.time.setText(alarm.hour+"'0 clock");

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class AlarmHolder extends RecyclerView.ViewHolder {

        TextView time, content;

        public AlarmHolder(View itemView) {
            super(itemView);
            time = (TextView) itemView.findViewById(R.id.alarmTime);
            content = (TextView) itemView.findViewById(R.id.alarmContent);
        }
    }
}
