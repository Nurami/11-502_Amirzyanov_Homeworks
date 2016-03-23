package ru.itis.inform;

/**
 * Created by Nurami on 18.03.2016.
 */
public class Point {
    private int x;
    private int y;
    private boolean flag;
    public Point(int x, int y) {
        this.x = x;
        this.y= y;
        this.flag=false;
    }

    public int getX() {
        return x;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public int getY() {
        return y;
    }

    public String toString() {
        return "(" + this.x + "," + this.y + ")";
    }
}
