package data;

public class Product {
    private String nameProduct, sku, price, qty;

    public String getNameProduct() {
        return nameProduct;
    }

    public String getSku() {
        return sku;
    }

    public String getPrice() {
        return price;
    }

    public String getQty() {
        return qty;
    }

    @Override
    public String toString() {
        return "Product{" +
                "nameProduct='" + nameProduct + '\'' +
                ", sku='" + sku + '\'' +
                ", price='" + price + '\'' +
                ", qty='" + qty + '\'' +
                '}';
    }
}
