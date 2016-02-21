package ru.itis.inform;

/**
 * Created by Nurami on 16.02.2016.
 */
public class RationalNumber {
    private int a;
    private int b;

    public void RationalNumber(int a, int b) {
        this.a=a;
        if (b!=0) {
            this.b=b;
        }
        else {
            throw new IllegalArgumentException();
        }
    }
    public int getA(){
        return this.a;
    }
    public int getB(){
        return this.b;
    }
}

