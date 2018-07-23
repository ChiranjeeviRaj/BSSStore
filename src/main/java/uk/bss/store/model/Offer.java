package uk.bss.store.model;

import java.math.BigDecimal;

/**
 * This class loads offers for each product.
 */
public class Offer {

    private OfferType offerType;

    //This attribute optional when Muti Buy.
    //Mandatory when offer type Product Percentage.
    private BigDecimal prodPerc;

    //This attribute optional when offer type Product Percentage.
    //Mandatory when offer type Multi Buy and Link Product.
    private Long quantity;
    private Product linkProduct;


    public OfferType getOfferType() {
        return offerType;
    }

    public void setOfferType(OfferType offerType) {
        this.offerType = offerType;
    }

    public BigDecimal getProdPerc() {
        return prodPerc;
    }

    public void setProdPerc(BigDecimal prodPerc) {
        this.prodPerc = prodPerc;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Product getLinkProduct() {
        return linkProduct;
    }

    public void setLinkProduct(Product linkProduct) {
        this.linkProduct = linkProduct;
    }
}
