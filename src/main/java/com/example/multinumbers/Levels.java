package com.example.multinumbers;

public class Levels {
    static  boolean easy = true,med = false , hard = false;
     private static  Levels levels;
     private Levels(){}
     public static Levels getInstance(){
         if(levels==null)
             levels = new Levels();
         return levels;
     }
    public boolean isEasy() {
        return easy;
    }

    public  void setEasy(boolean easy1) {
        easy = easy1;
    }

    public  boolean isMed() {
        return med;
    }

    public  void setMed(boolean med1) {
        med = med1;
    }

    public  boolean isHard() {
        return hard;
    }

    public void setHard(boolean hard1) {
        hard = hard1;
    }
}
