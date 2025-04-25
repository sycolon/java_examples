package Autos;
public class AudiA3 extends Auto {

    String motorType;
    boolean isQuattro;

    public AudiA3(String farbe, int raederanzahl, String motorType, boolean isQuattro) {
        super(farbe, raederanzahl);
        this.motorType = motorType;
        this.isQuattro = isQuattro;
    }

    public String getMotorType() {
        return this.motorType;
    }

    public boolean  gethasQuattroAntrieb() {
        return this.isQuattro;
    }

    @Override public void printAuto(){
        super.printAuto();
        System.out.print(" Motor type: " + this.motorType+ " is Quattro: "+ this.isQuattro+"\n");
    }
}
