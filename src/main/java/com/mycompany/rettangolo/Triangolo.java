package com.mycompany.rettangolo;

public class Triangolo {
    
    private double altezza;                       
    private Punto[] punti ;  // vertici
    private Lato []lati;    // lati
    static private String[] metodi = {"longa - longagnani: calcolo tramite distanza fra due punti", 
                               "erone - Erone: calcolo tramite formula di Erone"};
    private Lato base;
    private String tipo;
    private String metodo;
    private double area, perimetro;
  
    public Triangolo(Punto p1, Punto p2, Punto p3, String metodo)
    {
        punti = new Punto[3];
        lati = new Lato[3]; 
        creaPunti(p1,p2,p3);               //associazione ad array
        this.metodo = metodo;
        creaLati();
        this.tipo = calcolaTipo();
        calcolaPerimetro();
        if(metodo == "longa" || metodo == "longagnani")
            calcolaAreaLonga();
        else if(metodo == "erone" || metodo == "Erone")
            calcolaArea();
            
            
            
    }

    public double getArea() {
        return area;
    }

    public double getPerimetro() {
        return perimetro;
    }
    
    
    
    private void calcolaPerimetro()
    {
        this.perimetro = lati[0].get("lunghezza")+lati[1].get("lunghezza")+lati[2].get("lunghezza");
    }
    
    private void creaLati()
    {
        lati[0] = new Lato(punti[0], punti[1]);
        lati[1] = new Lato(punti[0], punti[2]);
        lati[2] = new Lato(punti[1], punti[2]);
    }
    private String calcolaTipo()
    {
        String tipo="";
        if((lati[0].get("lunghezza") == lati[1].get("lunghezza"))&&(lati[0].get("lunghezza") == lati[2].get("lunghezza")))
        {
            return  "equilatero";
        }
        else if(((lati[0].get("lunghezza") == lati[1].get("lunghezza"))&&(lati[0].get("lunghezza") != lati[2].get("lunghezza")))||
                ((lati[2].get("lunghezza") == lati[1].get("lunghezza"))&&(lati[2].get("lunghezza") != lati[0].get("lunghezza")))||
                ((lati[0].get("lunghezza") == lati[2].get("lunghezza"))&&(lati[0].get("lunghezza") != lati[1].get("lunghezza"))))
        {
            tipo +=  "isoscele";
        }
        
        else if(((lati[0].get("lunghezza") != lati[1].get("lunghezza"))&&(lati[1].get("lunghezza") != lati[2].get("lunghezza")))&&(lati[0].get("lunghezza") != lati[2].get("lunghezza")))
        {
            tipo += "scaleno";
        }
        
        if((lati[0].get("coefficente angolare") == -1/lati[1].get("coefficente angolare"))||
           (lati[0].get("coefficente angolare") == -1/lati[2].get("coefficente angolare"))||
           (lati[1].get("coefficente angolare") == -1/lati[2].get("coefficente angolare")))
            tipo += " rettangolo";
        return tipo;
    }
    
    private void creaPunti(Punto p1, Punto p2, Punto p3)
    {
        punti[0] = p1;
        punti[1] = p2; 
        punti[2] = p3;
         
    }
    
    public String toString()
    {
        if(metodo == "longa" || metodo == "longagnani")
        return  " metodo: "+metodo+
                "\n type: "+tipo+
                "\n Altezza:"+this.altezza+
                "\n Base:"+base.get("lunghezza")+
                "\n Lato1: "+lati[0].get("lunghezza")+
                "\n Lato2: "+lati[1].get("lunghezza")+
                "\n Lato3: "+lati[2].get("lunghezza")+
                "\n Coefficente Angolare del Lato1: "+lati[0].get("coefficente angolare")+
                "\n Coefficente Angolare del Lato2: "+lati[1].get("coefficente angolare")+
                "\n Coefficente Angolare del Lato3: "+lati[2].get("coefficente angolare")+
                "\n Area: " + area +
                "\n Perimetro: " + perimetro;
        else if(metodo == "erone" || metodo == "Erone")
            return  " metodo: "+metodo+
                    "\n type: "+tipo+
                    "\n Lato1: "+lati[0].get("lunghezza")+
                    "\n Lato2: "+lati[1].get("lunghezza")+
                    "\n Lato3: "+lati[2].get("lunghezza")+
                    "\n Area: " + area +
                    "\n Perimetro: " + perimetro;
        else
            return "metodo errato, prova con:\n"+metodi();
            
    }
    
    private String metodi()
    {
        String ris="";
        for(int i = 0;i<2;i++)
            ris+=metodi[i]+"\n";
        return ris;
    }
    
    private void calcolaAreaLonga()
    {    
        base = new Lato(punti[0], punti[1]);
        
        altezza = distanzaTraUnPuntoEUnaRetta(base, punti[2]);
        
        this.area = (base.get("lunghezza")*altezza)/2;  
    }
    
    private double distanzaTraUnPuntoEUnaRetta(Lato base, Punto punto)
    {
        return Math.abs((-(base.get("coefficente angolare")) * punto.getAscissa()) + punto.getOrdinata() -(base.get("intercetta")))/
               Math.sqrt(Math.pow(base.get("coefficente angolare") , 2) + 1);
    }
    
    private void calcolaArea()
    {
        final double semiPer = perimetro/2;
        this.area = Math.sqrt(semiPer * (semiPer - lati[0].get("lunghezza"))* 
                                        (semiPer - lati[0].get("lunghezza"))* 
                                        (semiPer - lati[0].get("lunghezza")));
        
    }
    
}
