package Autos;
public class Auto {

    // static Variable: zählt alle Autos
    static int anzahlAutos = 0;

    // non-static Variable: gehört zu jedem Auto
    String farbe;

    int raederanzahl;

    // Konstruktor  -- Overloading 
    public Auto(String farbe, int raederanzahl) {
        this.farbe = farbe;
        this.raederanzahl = raederanzahl;
        anzahlAutos++; // zählt jedes erstellte Auto
    }

    public Auto(String farbe) {
        this.farbe = farbe;
        anzahlAutos++; // zählt jedes erstellte Auto
    }

    // static Methode
    public static int getAnzahlAutos() {
        return anzahlAutos;
    }

    // non-static Methode
    public void zeigeFarbe() {
        System.out.println("Farbe: " + this.farbe);
    }


    public void setRaederanzahl(int zahl){
        this.raederanzahl= zahl;
    }

    public int getRaederanzahl(){
        return this.raederanzahl;
    }

    public void printAuto(){
        System.out.print("Farbe: "+ this.farbe+" Räderanzahl: "+ this.raederanzahl);
    }
}