package ru.itis.inform;

/**
 * Created by Nurami on 18.03.2016.
 */
public class Shell {
    public Point[] getShell (Point[] points) {
        Point[] mas = points;
        Point minPoint = mas[0];
        int indexMin=0;


        for (int i=0; i<mas.length; i++) {
            if (mas[i].getX()<minPoint.getX() && mas[i].getY()<minPoint.getY()) {
                minPoint=mas[i];
                indexMin = i;
            }
        }
        mas[indexMin] = mas[0];
        mas[0]=minPoint;

        double maxCos=-1;
        Point p2 = mas[1];
        int indexP2=1;
        for (int i=1; i<mas.length; i++) {
            if (getCos1(minPoint, mas[i])>maxCos) {
                p2 = mas[i];
                indexP2 =i;
                maxCos = getCos1(minPoint, mas[i]);
            }
        }

        mas[indexP2] = mas[1];
        mas[1]=p2;
        mas[1].setFlag(true);


        int i=1;
        int index=0;

        Point[] mas1= new Point[mas.length];
        mas1[0]=mas[0];
        mas1[1]=mas[1];

        do {
            double minCos = 1;
            for (int j=0; j<mas.length; j++) {
                int a = getScalar(getVector(mas[i], mas[i-1]), getVector(mas[i], mas[j]));
                double b = getProizLength(getVector(mas[i], mas[i-1]), getVector(mas[i], mas[j]));
                if ((getCos2(a, b)<minCos) && (mas[j].isFlag()==false)) {
                    minCos=getCos2(a, b);
                    index=j;
                }
            }
            mas1[i+1]=mas[index];
            Point c =mas[i+1];
            mas[i+1]=mas[index];
            mas[index]=c;
            mas[i+1].setFlag(true);
            i++;

        }
        while (mas[i]!=mas1[0]);
        return mas1;

       /* do {
            double minCos=1;
            for (int i = 0; i < mas.length; i++) {
                int a = getScalar(getVector(mas[k], mas[k-1]), getVector(mas[k], mas[i]));
                double b = getProizLength(getVector(mas[k], mas[k-1]), getVector(mas[k], mas[i]));
                if ((getCos2(a, b) < minCos) && (mas[i].isFlag()==false)) {
                    minCos = getCos2(a, b);
                    index=i;
                }
            }
            Point c = mas[k+1];
            mas[k+1]=mas[index];
            mas[index]=c;
            pi=mas[k+1];
            mas[k+1].setFlag(true);
            k++;

        }
        while (pi!=mas[0]);

        Point[] mas1 = new Point[k];
        for (int i=0; i<mas1.length; i++) {
            mas1[i]=mas[i];
        }
        return mas1;*/
    }



    public double getCos1 (Point first, Point second) {
        int x1=first.getX();
        int x2=second.getX();
        int y1=first.getY();
        int y2=second.getY();
        return (x2-x1)/Math.sqrt(Math.pow(x2-x1, 2)+Math.pow(y2-y1, 2));
    }
    public double getCos2 (int a, double b) {
        return a/b;
    }

    public Point getVector (Point first, Point second){
        Point x=new Point(second.getX()-first.getX(), second.getY()-first.getY());
        return x;
    }
    public int getScalar (Point first, Point second) {
        int x =first.getX()*second.getX();
        int y =first.getY()*second.getY();
        return x+y;
    }
    public double getProizLength(Point first, Point second){
        double x = Math.sqrt(Math.pow(first.getX(),2)+Math.pow(first.getY(), 2));
        double y = Math.sqrt(Math.pow(second.getX(),2)+Math.pow(second.getY(), 2));
        return x*y;
    }
}
