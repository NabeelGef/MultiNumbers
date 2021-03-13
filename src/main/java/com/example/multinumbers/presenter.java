package com.example.multinumbers;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;

import androidx.annotation.RawRes;

public class presenter  {
    public presenter() {
    }
    boolean proccess(int one, int two, int val)
    {
        if((one*two)==val)
           return  true;
        return false;
    }
    int counter(int val)
    {
        val+=10;
        return val ;
    }
}
