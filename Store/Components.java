package Store;

public abstract class Components extends Article {

    private String type; // e.g., GPU, RAM, SSD, HDD, Keyboard, CPU, Mouse..
    private String specs;

    public Components(double price, String name, int articleNr, boolean inStock, String type, String specs) {
        super(price, name, articleNr, inStock);
        this.type = type;
        this.specs = specs;
    }

    // Getters and Setters

    public String getType() {
        return type;
    }

    public String getSpecs() {
        return specs;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setSpecs(String specs) {
        this.specs = specs;
    }

    @Override
    public String toString() {
        return super.toString() + " Component{ Type: '" + type + "', Specs: '" + specs + "'}";
    }
}
