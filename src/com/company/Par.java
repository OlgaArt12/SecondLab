package com.company;

public class Par extends GeomObj{

    private int a, b, c;

    public int getA(){return a;}

    public  void setA(int a)
    {
        if(a <= 0)
        {
            throw new IllegalArgumentException("Ошибка! Введите заново!");
        }
        this.a = a;
    }

    public int getB(){return b;}

    public  void setB(int b)
    {
        if(b <= 0)
        {
            throw new IllegalArgumentException("Ошибка! Введите заново!");
        }
        this.b = b;
    }

    public int getC(){return c;}

    public  void setC(int c)
    {
        if(c <= 0)
        {
            throw new IllegalArgumentException("Ошибка! Введите заново!");
        }
        this.c = c;
    }

    public double Weight()
    {
        return getVolume() * getP();
    }

    private double getVolume(){return this.getA() * this.getB() * this.getC();}

    public Par(double p, int a, int b, int c) throws IllegalArgumentException
    {
        super(p);
        this.setA(a);
        this.setB(b);
        this.setC(c);
    }

    @Override
    public String info()
    {
        return  "Фигура параллелепипед; " + super.info() + "; длина = " + getA() + "; ширина = " + getB() + "; высота = " + getC();
    }
}
