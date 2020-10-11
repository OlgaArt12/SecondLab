package com.company;

public class GeomObj implements Weight {

    private double p; //плотность фигур

    public  double getP(){return p;} //возвращает значение плотности

    public void setP(double p) throws  IllegalArgumentException
    {
        if( p <= 0)
        {
            throw new IllegalArgumentException("Плотность введена не верно!");
        }
        this.p = p;
    } //устаанвливаем значения плотности

    public GeomObj(double p){this.p = p;}

    public double Weight()
    {
        return getP();
    }

    public  String info()
    {
        return "плотность объемного геометрического тела = " + getP();
    }

}
