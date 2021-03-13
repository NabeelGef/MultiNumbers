package com.example.multinumbers;
import java.util.Random;
public class Randomly {
    int x;
    Randomly(){this.x=0;}
    void set(int X)
    {
        this.x=X;
    }
    int getRand()
    {
        Random random=new Random();
        return random.nextInt(x);
    }
}
