import Store.CapacityUnit;
import Store.Computer;
import Store.GraphicCard;
import Store.GraphicCardsCompanies;
import Store.StorageType;
import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        Computer comp1 = new Computer(699.99, "AlienWare 70F", 876787, true, "i9 14889H", 32, 4);

        System.out.println(comp1);

        StorageType ssd1 = new StorageType(70.99, "Samsung EVO 990", 21347239, true, "SSD", "PCI 5", 2, CapacityUnit.GB,
                "NVME M2");
        // System.out.println(ssd1);
        JOptionPane.showMessageDialog(null, ssd1);

        GraphicCard c1 = new GraphicCard(853.88, "GeForce", 234234, false, "GTX", "1070 Ti", 8,
                GraphicCardsCompanies.NVIDIA, "High Performance");

        System.out.println(c1);
        System.exit(0);
    }
}
