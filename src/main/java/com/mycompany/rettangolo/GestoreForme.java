package com.mycompany.rettangolo;

public interface GestoreForme {
    public static void main(String args[])
    {
        Punto p1=new Punto(0,3),p2 = new Punto(-1,2),p3 = new Punto(1,2);
        Triangolo triangolo = new Triangolo(p1,p2,p3, "longa");
        System.out.println(triangolo.toString());
    }
}
