package com.example.multinumbers;

import android.provider.ContactsContract;
import android.widget.ImageView;

public class creatImage {
    String img;
    boolean f;
    public creatImage() {
    }
    public creatImage(String img,boolean f) {
        this.img = img;this.f=f;
    }
    public String getImg() {
        return img;
    }
    public  boolean getF(){return  f;}
}
