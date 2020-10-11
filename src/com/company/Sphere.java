package com.company;

public class Sphere extends GeomObj{

    private static int k = 0;

    public  static int getK() {return k;}

    private int R;

    public int getR(){return R;}

    public void setR(int R) throws  IllegalArgumentException
    {
        if( R <= 0)
        {
            throw new IllegalArgumentException("Радиус введен не верно!");
        }
        this.R = R;
    }

    public  double Weight()
    {
        return  getVolume() * getP();
    }

    private double getVolume(){return (double)((4 / 3) * Math.PI * this.getR() * this.getR() * this.getR());}

    public Sphere(double p, int R) throws IllegalArgumentException
    {
        super(p);
        this.setR(R);
        k++;
    }

    @Override
    public String info()
    {
        return  "Фигура шар; " + super.info() + "; радиус = " + getR();
    }
}
