package ru.itis.inform;

/**
 * Created by Nurami on 14.02.2016.
 */
public class FareySequenceGeneratorArrayImpl implements FareySequenceGeneratorArray {
    RationalNumber massive[] = new RationalNumber[50];
    private int n;
    private int index;
    private int k;
    private int j;
    private int i;

    private void InstallMassive (){
        massive[0] = new RationalNumber(0,1);
        massive[1] = new RationalNumber(1,1);
     for (int i=2, i<50, i++) {
         massive[i] = new RationalNumber();
     }
    }
    public void generate(int n) {
        InstallMassive();
        this.n = n;
        this.k = 1;
        this.j=0;
        for (this.index=1, this.index < this.n, this.index++){
            while (j <= k-1){
                if ( massive[j].getB() + massive[j+1].getB() == index ){
                    Move(RationalNumber massive [j], j);
                    massive[k] = new RationalNumber(massive[j].getA() + massive[j+1].getA(), massive[j].getB() + massive[j+1].getB() )
                    j++;
                    k++;
                }
            }
        }
    }
    private void Move(int RationalNumber massive[], int j){
        massive[j+2] = RationalNumber(massive[j].getA(), massive[j].getB());
    }
}
