package com.mycompany.rettangolo;

public class Lato {
    
    private double lunghezza, coefficenteAngolare, intercetta;
    private Punto A,B;
    
    private double distanzaTraDuePunti()
    {
        return Math.sqrt(Math.pow((A.getAscissa() - B.getAscissa( )), 2) + Math.pow((A.getOrdinata() - B.getOrdinata()), 2));
    }
    
    public Lato(Punto a, Punto b)
    {
        this.A = a;
        this.B = b;
        this.lunghezza = distanzaTraDuePunti();
        this.coefficenteAngolare = calcolaCoefficenteAngolare();
        this.intercetta = calcolaIntercetta();
    }
    
    public double get(String args)
    {
        if(args == "lunghezza")
            return lunghezza;
        else if(args == "coefficente angolare" || args == "CA")
            return coefficenteAngolare;
        else if(args == "intercetta")
            return intercetta;
        else
            return lunghezza;
    }
    
    private double calcolaCoefficenteAngolare()
    {
        return (B.getOrdinata() - A.getOrdinata())/(B.getAscissa() - A.getAscissa());
    }
    
    private double calcolaIntercetta()
    {
        return ((B.getAscissa()*A.getOrdinata()) - (A.getAscissa()*B.getOrdinata()))/(B.getAscissa()- A.getAscissa());
    }
    
}
