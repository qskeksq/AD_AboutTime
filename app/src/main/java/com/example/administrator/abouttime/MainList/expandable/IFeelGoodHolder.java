package com.example.administrator.abouttime.MainList.expandable;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

import com.example.administrator.abouttime.Detail.DetailActivity;
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;

/**
 * Created by Administrator on 2017-07-06.
 */

public class IFeelGoodHolder extends ChildViewHolder {

    public static final String PARENT_POSITION = "PARENT";
    public static final String CHILD_POSITION = "CHILD";

    int parentPosition, childPosition;

    public IFeelGoodHolder(View itemView, final Activity activity) {
        super(itemView);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goDetail(activity);
            }
        });

    }

    private void goDetail(Activity activity) {
        Intent intent = new Intent(activity, DetailActivity.class);
        intent.putExtra(PARENT_POSITION, parentPosition);
        intent.putExtra(CHILD_POSITION, childPosition);
        activity.startActivity(intent);
    }

    public void setParentPosition(int parentPosition) {
        this.parentPosition = parentPosition;
    }

    public void setChildPosition(int childPosition) {
        this.childPosition = childPosition;
    }
}
