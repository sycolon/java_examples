package Store;

public class Computer extends Article {
    
    private String cpu;
    private int ram; // in GB
    private int storage; // in GB

    public Computer(double price, String name, int articleNr, boolean inStock, String cpu, int ram, int storage){
        super(price, name, articleNr, inStock);
        this.cpu = cpu;
        this.ram = ram;
        this.storage = storage;

    }

    //Getters and  Setters
    public String getCpu(){
        return cpu;
    }
    public int getRam(){
        return ram;
    }
    public int getStorage(){
        return storage;
    }

    public void setCpu(String cpu){
        this.cpu= cpu;
    }
    public void setRam(int ram){
        this.ram= ram;
    }
    public void setCpu(int storage){
        this.storage= storage;
    }

    @Override
    public String toString(){

        return super.toString() +" Computer { CPU= '" + cpu + "' , RAM= '" + ram+ " GB' , Storage= '" + storage+" TB'";
    }
}
