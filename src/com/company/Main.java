package com.company;

import java.util.Scanner;

public class Main {

    private static double readLineDb()
    {
        Scanner scn = new Scanner(System.in);
        while (!scn.hasNextDouble()) {
            System.out.println("That not a number! Please enter an plotnost!");
            scn.next();
        }
        return scn.nextDouble();
    }

    private static int readLineInt(){
        Scanner scn = new Scanner(System.in);
        while (!scn.hasNextInt()) {
            System.out.println("That not a number! Please enter an !");
            scn.next();
        }
        return scn.nextInt();
    }

    private static GeomObj[] objs = new GeomObj[4];

    public static void addSph()
    {
        boolean da;
        int radius;
        double plotn;
            for(int i = 0; i < 2; i++)
            {
                do
                {
                    da = true;
                    System.out.print("Плотность " + (i + 1) + "-ого шара = ");
                    plotn = readLineDb();
                    System.out.print("Радиус " + (i + 1) + "-ого шара = ");
                    radius =readLineInt();
                    try {
                        objs[i] = new Sphere(plotn, radius);
                    } catch (IllegalArgumentException e) {
                        da = false;
                        System.out.println(e.getMessage());
                    } catch (Exception e) {
                        da = false;
                        System.out.println("Введие заново!");
                    }
                }while (!da);
            }
    }
    public static void addPar()
    {
        int length,width,height;
        double plotn1;
        boolean da;
        for(int i = 2, j = 1; i < 4; i++, j++)
        {
            do {
                da = true;
                System.out.print("Плотность " + (j) + "-го параллелепипеда = ");
                plotn1 = readLineDb();
                System.out.print("Длина " + (j) + "-го параллелепипедп = ");
                length = readLineInt();
                System.out.print("Ширина " + (j) + "-го паралеллепипеда = ");
                width =readLineInt();
                System.out.print("Высота " + (j) + "-го параллелепипеда = ");
                height =readLineInt();
                try {
                    objs[i] = new Par(plotn1, length, width, height);
                } catch (IllegalArgumentException e) {
                    da = false;
                    System.out.println(e.getMessage());
                } catch (Exception e){
                    da = false;
                    System.out.println("Введие заново!");
                }
            } while (!da);


        }
    }

    public static void addObj()
    {
        if(Sphere.getK() == 0)
        {
            addSph();
            addPar();
        }
        else
        {
            boolean Menu;
            do{
                Menu = false;
                System.out.println("Хотите перезаписать объекты?");
                System.out.println("------1 -- Да------");
                System.out.println("------2 -- Нет------");
                System.out.print("Введите цифру: ");
                switch (readLineInt()){
                    case 1:
                        addSph();
                        addPar();
                        break;
                    case 2:
                        return;
                    default:
                        System.out.println("Вы ввели неверное число! введите еще раз, пожалуйста!");
                        Menu = true;
                }
            }while (Menu);
        }

    }

    public static void changeSp(int k)
    {
        System.out.println(objs[k].info());
        boolean Menu;
        do
        {
            Menu = false;
            System.out.println("Что хотите изменить? 1 - плотность шара; 2 - радус шара?");
            System.out.println("Введите цифру от 1 до 2: ");
            switch (readLineInt())
            {
                case 1:
                    System.out.println("Введите плотность!");
                    boolean da;
                    do {
                        da =true;
                        System.out.print("p = ");
                        GeomObj p = (GeomObj)objs[k];
                        try {
                            p.setP(readLineDb());
                            System.out.println("Плотность изменина!");
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage() + "Введите заново!");
                            da = false;
                        } catch (Exception e) {
                            System.out.println("Ошибка, введите заново!");
                            da = false;
                        }
                    } while (!da);
                    break;
                case 2:
                    System.out.println("Введите радиус!");
                    boolean d;
                    do {
                        d =true;
                        System.out.print("R = ");
                        Sphere s = (Sphere)objs[k];
                        try {
                            s.setR(readLineInt());
                            System.out.println("Радиус изменен!");
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage() + "Введите заново!");
                            d = false;
                        } catch (Exception e) {
                            System.out.println("Ошибка, введите заново!");
                            d = false;
                        }
                    } while (!d);
                    break;
                default:
                    System.out.println("Такой команды нет! Выберите команду 1 или 2");
                    Menu = true;
            }
        }while (Menu);
    }

    public static void changePar(int k)
    {
        System.out.println(objs[k].info());
        boolean Menu;
        do
        {
            Menu = false;
            System.out.println("Что хотите изменить? 1 - плотность параллелепипеда; 2 - длину; 3 - ширину; 4 - высоту?");
            System.out.println("Введите цифру от 1 до 4: ");
            switch (readLineInt())
            {
                case 1:
                    System.out.println("Введите плотность!");
                    boolean da;
                    do {
                        da =true;
                        System.out.print("p = ");
                        GeomObj p = (GeomObj)objs[k];
                        try {
                            p.setP(readLineDb());
                            System.out.println("Плотность изменина!");
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage() + "Введите заново!");
                            da = false;
                        } catch (Exception e) {
                            System.out.println("Ошибка, введите заново!");
                            da = false;
                        }
                    } while (!da);
                    break;
                case 2:
                    System.out.println("Введите длину!");
                    do {
                        da =true;
                        System.out.print("а = ");
                        Par parl = (Par)objs[k];
                        try {
                            parl.setA(readLineInt());
                            System.out.println("Длина изменена!");
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage() + "Введите заново!");
                            da = false;
                        } catch (Exception e) {
                            System.out.println("Ошибка, введите заново!");
                            da = false;
                        }
                    } while (!da);
                    break;
                case 3:
                    System.out.println("Введите ширину!");
                    do {
                        da =true;
                        System.out.print("b = ");
                        Par p1 = (Par)objs[k];
                        try {
                            p1.setB(readLineInt());
                            System.out.println("Ширина изменена!");
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage() + "Введите заново!");
                            da = false;
                        } catch (Exception e) {
                            System.out.println("Ошибка, введите заново!");
                            da = false;
                        }
                    } while (!da);
                    break;
                case 4:
                    System.out.println("Введите высоту!");
                    do {
                        da =true;
                        System.out.print("с = ");
                        Par p2 = (Par)objs[k];
                        try {
                            p2.setC(readLineInt());
                            System.out.println("Высота изменена!");
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage() + "Введите заново!");
                            da = false;
                        } catch (Exception e) {
                            System.out.println("Ошибка, введите заново!");
                            da = false;
                        }
                    } while (!da);
                    break;
                default:
                    System.out.println("Такой команды нет! Выберите команду от 1 до 4");
                    Menu = true;
            }
        }while (Menu);
    }

    public static void changeObg()
    {
        if(Sphere.getK() == 0)
        {
            System.out.println("Объеткы не существуют!");
        }
        else
        {
            System.out.println("Введите № объекта, который хотете изментиь!");
            System.out.print("№ объекта: ");
            printObg();
            boolean da;
            int k;
            do {
                da = true;
                k = readLineInt();
                if(da && k > 0 && k < 5)
                {
                        if(objs[k - 1] instanceof Sphere) changeSp(k-1);
                        if(objs[k -1] instanceof Par) changePar(k - 1);
                }
                else
                    {
                        System.out.println("Номер этого объетка не найден!");
                        da = false;
                    }


            }while (!da);
        }
    }


    public static void printObg()
    {
        for (int i = 0; i < objs.length; i++) {
            System.out.println((i + 1) + ". " + objs[i].info());
        }
    }

    public static void Weight()
    {
        if (Sphere.getK() == 0)
        {
            System.out.println("Объекты еще не созданы!");
        } else
            {
                printObg();
                    for (int i = 0; i < 4; i++)
                    {
                        Weight m = objs[i];
                        System.out.println("фигура № " + (i + 1) + " масса тела m =  " + m.Weight());
                    }
            }
    }

    public static void main(String[] args) {

        boolean Menu;
        do{

            System.out.println("--Добро пожаловать! Выберите действие!--");
            System.out.println("------ 1 -- Создать объекты!------");
            System.out.println("------ 2 -- Изменить объекты!------");
            System.out.println("------ 3 -- Вывести список объектов на экран!------");
            System.out.println("------ 4 -- Посчитать массу геом.тела!------");
            System.out.println("------ 5 -- Выход!------");
            System.out.print("Ввдедите пункт меню: ");
            switch (readLineInt()){
                case 1:
                    addObj();
                    Menu = true;
                    break;
                case 2:
                    changeObg();
                    Menu = true;
                    break;
                case 3:
                    if(Sphere.getK() == 0){
                        System.out.println("Объекты еще не созданы!");
                    }else printObg();
                    Menu = true;
                    break;
                case 4:
                    Weight();
                    Menu = true;
                    break;
                case 5:
                    System.out.println("Вы завершили выполнение программы!");
                    System.exit(0);
                default:
                    System.out.println("Такого пункта нет в меню! Введите существуюущю цийру (от 1 до 5)!");
                    Menu = true;
            }
        }while (Menu);
    }
}
