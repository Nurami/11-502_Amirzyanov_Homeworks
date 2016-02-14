package ru.itis.inform;

/**
 * Created by Nurami on 14.02.2016.
 */
public class RationalNumber {
    private int a;
    private int b;

    public RationalNumber(int a, int b) {
        if (b==0) {
            throw new IllegalArgumentException()
        }
        else {
            this.b = b;
        }
        this.a = a;
    }
    public int getA(){
        return this.a
    }
    public int getB(){
        return this.b
    }
}
