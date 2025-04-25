package Autos;
import company.*;
public class Main {
    public static void main(String[] args) {
        // Auto auto1 = new Auto("Rot");
        // Auto auto2 = new Auto("Blau");

        // Auto auto3 = new Auto("black", 4);

        // Auto auto4 = new AudiA3("selber", 4, "benzin");

        // System.out.println(auto4.getRaederanzahl());

        // AudiA3 auto5= new AudiA3("selber", 4, "benzin");
        // String motorType = auto5.getMotorType();
        // System.out.println(motorType);

        // auto1.zeigeFarbe(); // -> Farbe: Rot
        // auto2.zeigeFarbe(); // -> Farbe: Blau
        // auto3.zeigeFarbe();
        // System.out.println(auto3.getRaederanzahl());
        // auto3.setRaederanzahl(3);
        // System.out.println(auto3.getRaederanzahl());

        // Auto s3 = new Auto("black", 4);

        // Auto r4 = new Auto("Lila");
        // r4.setRaederanzahl(3);

        // Auto z = new Auto("", 4);

        // s3.printAuto();
        // r4.printAuto();

        // z.printAuto();

        Audi test1 = new Audi();
        test1.printAvailable();

        AudiA3 nA3 = new AudiA3("Selber", 4, "Benzin 1.6", false) ;

        Auto u4 = new AudiA3("Rot", 3, "Diesel", true);

        

        nA3.printAuto();

        System.out.println("Anzahl Autos: " + Auto.getAnzahlAutos()); 
    }
}