package Store;

public class GraphicCard extends Components {

    private int vram; // in GB
    private String chipset; // NVIDIA RTX 4080
    private GraphicCardsCompanies graphicCardCom;

    public GraphicCard(double price, String name, int articleNr, boolean inStock, String type, String specs, int vram,
            GraphicCardsCompanies graphicCardCom,
            String chipset) {
        super(price, name, articleNr, inStock, type, specs);
        this.vram = vram;
        this.chipset = chipset;
        this.graphicCardCom = graphicCardCom;
    }

    // Getters and Setters

    public int getVram() {
        return vram;
    }

    public String getChipset() {
        return chipset;
    }

    public GraphicCardsCompanies getGraphicCardCom() {
        return graphicCardCom;
    }

    public void setVram(int vram) {
        this.vram = vram;
    }

    public void setChipset(String chipset) {
        this.chipset = chipset;
    }

    public void setGraphicCardCom(GraphicCardsCompanies graphicCardCom) {
        this.graphicCardCom = graphicCardCom;
    }

    @Override
    public String toString() {
        return super.toString() + " Graphic Card { VRAM: '" + vram + "' Graphic Card Company: '" + graphicCardCom
                + "', Chipset: '" + chipset + "'}";
    }

}
