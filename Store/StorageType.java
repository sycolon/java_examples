package Store;

public class StorageType extends Components {

    private int capacity; // GB, TB
    private String sType; // SSD, HDD, SSHD, NVME
    private CapacityUnit capacityUnit; // Use enum

    public StorageType(double price, String name, int articleNr, boolean inStock, String type, String specs,
            int capacity, CapacityUnit capacityUnit, String sType) {
        super(price, name, articleNr, inStock, type, specs);
        this.capacity = capacity;
        this.sType = sType;
        this.capacityUnit = capacityUnit;
    }

    // Getters and Setters

    public int getCapacity() {
        return capacity;
    }

    public CapacityUnit getCapacityUnit() {
        return capacityUnit;
    }

    public String getSType() {
        return sType;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setCapacity(CapacityUnit capacityUnit) {
        this.capacityUnit = capacityUnit;
    }

    public void setSType(String sType) {
        this.sType = sType;
    }

    @Override
    public String toString() {
        return super.toString() + " StorageType { Storage Type: '" + sType + "', Capacity: '" + capacity + " "
                + capacityUnit + "'}";
    }
}
