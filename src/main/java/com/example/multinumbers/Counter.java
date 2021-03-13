package com.example.multinumbers;

import android.os.CountDownTimer;
import android.widget.TextView;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class Counter extends ViewModel {
    CountDownTimer clock ;
    boolean notFinish = false;
    int id;
    MutableLiveData <Integer> mutableLiveData = new MutableLiveData<>();
    MutableLiveData <Boolean> mutableLiveData2= new MutableLiveData<>();
    public  void  ONClock (int count ){
        id = count;
        if(count==10)
        {
           clock = new CountDownTimer(11000,1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    mutableLiveData.setValue(id);
                    id--;
                    mutableLiveData2.setValue(notFinish);
                }
                @Override
                public void onFinish() {
                    notFinish=true;
                    mutableLiveData2.setValue(notFinish);
                    notFinish=false;
                }
            }.start();
        }
        if(count==20)
        {
            clock = new CountDownTimer(21000,1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    mutableLiveData.setValue(id);
                    id--;
                    mutableLiveData2.setValue(notFinish);
                }
                @Override
                public void onFinish() {
                    notFinish=true;
                    mutableLiveData2.setValue(notFinish);
                    notFinish=false;
                }
            }.start();
        }
        if(count==30)
        {
            clock = new CountDownTimer(31000,1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    mutableLiveData.setValue(id);
                    id--;
                    mutableLiveData2.setValue(notFinish);
                }
                @Override
                public void onFinish() {
                    notFinish=true;
                    mutableLiveData2.setValue(notFinish);
                    notFinish=false;
                }
            }.start();
        }
    }
    public void OFFClock(int count)
    {
          if(id!=0)
             clock.cancel();
            ONClock(count);
    }
    public void mute()
    {
        if(id!=0)
            clock.cancel();
    }
}
