package com.example.multinumbers;

import android.app.Application;
import android.content.Context;
import android.media.MediaPlayer;
public class Media {
    MediaPlayer media;
    boolean accept = false;
    private Media(){}
    private static Media ins;
    public static Media getIns() {
        if(ins==null)
            ins=new Media();
        return ins;
    }
    public void setMedia(int R,Context context) {
         accept = true;
        media = MediaPlayer.create(context,R);
        on();
    }
    public boolean isAccept()
    {
        return accept;
    }
    public void on()
    {
        if(!media.isPlaying())
            media.start();
        else
        {
            media.seekTo(media.getCurrentPosition());
            media.start();
        }
    }
    public void off()
    {
        if(media.isPlaying())
            media.pause();
    }
}
