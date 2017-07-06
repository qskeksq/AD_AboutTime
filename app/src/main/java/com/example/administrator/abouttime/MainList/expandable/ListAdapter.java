package com.example.administrator.abouttime.MainList.expandable;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.abouttime.R;
import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

/**
 * Created by Administrator on 2017-07-06.
 */

public class ListAdapter extends ExpandableRecyclerViewAdapter<HowIsYourDayHolder, IFeelGoodHolder> {

    Activity activity;
    int parentPosition;

    public ListAdapter(List<? extends ExpandableGroup> groups, Activity activity) {

        super(groups);

        this.activity = activity;
    }

    @Override
    public HowIsYourDayHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        View view =  LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_howisyourday, parent, false);
        return new HowIsYourDayHolder(view);
    }

    @Override
    public IFeelGoodHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
        View view =  LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_ifeelgood, parent, false);
        return new IFeelGoodHolder(view, activity);
    }

    @Override
    public void onBindChildViewHolder(IFeelGoodHolder holder, int flatPosition, ExpandableGroup group, int childIndex) {

        holder.setParentPosition(group.getTitle());
        holder.setChildPosition(childIndex);
    }

    @Override
    public void onBindGroupViewHolder(HowIsYourDayHolder holder, int flatPosition, ExpandableGroup group) {


    }
}
