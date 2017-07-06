package com.example.administrator.abouttime.domain;

/**
 * Created by Administrator on 2017-07-07.
 */

public class Alarm {

    public String time;
    public String content;
    public int hour;
    public int minute;

    public Alarm() {

    }

    public Alarm(String time, String content) {
        this.time = time;
        this.content = content;
    }


}
