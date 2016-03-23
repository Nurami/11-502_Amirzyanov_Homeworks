package ru.itis.inform;

/**
 * Created by Nurami on 18.03.2016.
 */
public class Main {
    public static void main(String[] args) {
        Point[] massive = new Point[8];
        massive[0]= new Point(5,1);
        massive[2]= new Point(3,6);
        massive[1]= new Point(2,0);

        massive[3]= new Point(6,4);
        massive[4]= new Point(2,3);
        massive[5]= new Point(0,3);
        massive[6]= new Point(3,1);
        massive[7]= new Point(4,3);
        Shell qq = new Shell();
        Point[] mass = qq.getShell(massive);

        for (int i=0; i<mass.length; i++) {
            if (mass[i]!=null) {
                System.out.println(mass[i]);
            }
        }

    }
}

