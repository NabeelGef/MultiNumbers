package com.example.multinumbers;

public class Translate {
   static boolean tr = true  ;
    private static Translate trr;
    public static Translate getTrr() {
        if(trr == null)
            return new Translate();
        return trr;
    }
    public boolean isTr() {
        return tr;
    }

    public void setTr() {
         tr=true;
    }
    public void offTr(){
        tr=false;
    }
    public void print_Tr()
    {
        System.out.println("tr = " + tr);
    }
}
