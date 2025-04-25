package Store;

public abstract class Article implements Sellable {

    private double price;
    private String name;
    private int articleNr;
    private boolean inStock;

    public Article(double price, String name, int articleNr, boolean inStock) {
        this.price = price;
        this.name = name;
        this.articleNr = articleNr;
        this.inStock = inStock;
    }

    // Getters und setters
    @Override
    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public int getArticleNr() {
        return articleNr;
    }

    @Override
    public boolean isInStock() {
        return inStock;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setArticleNr(int articleNr) {
        this.articleNr = articleNr;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    @Override
    public String toString() {
        return "Article {Name='" + name + "', Price= '" + price + "', artikel number= '" + articleNr + "', in stock= '"
                + inStock + "'}";
    }
}
