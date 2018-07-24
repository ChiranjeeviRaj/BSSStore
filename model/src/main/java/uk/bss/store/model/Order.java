package uk.bss.store.model;

import uk.bss.store.model.Product;

public class Order {
    private Product product;
    private long quantity;

    public Order(Product product, long quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public long getQuantity() {
        return quantity;
    }

    public void incrementQuantity(){
        this.quantity++;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }
}
