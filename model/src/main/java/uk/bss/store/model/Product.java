package uk.bss.store.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Product {

    private long id;
    private String name;
    private BigDecimal price;
    private Offer offer;
    private MeasureUnit measureUnit;
    private BigDecimal redPrice;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getRedPrice() {
        return redPrice;
    }

    public void setRedPrice(BigDecimal redPrice) {
        this.redPrice = redPrice;
    }

    public MeasureUnit getMeasureUnit() {
        return measureUnit;
    }

    public void setMeasureUnit(MeasureUnit measureUnit) {
        this.measureUnit = measureUnit;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id &&
                Objects.equals(name, product.name) &&
                Objects.equals(price, product.price) &&
                Objects.equals(offer, product.offer) &&
                measureUnit == product.measureUnit &&
                Objects.equals(redPrice, product.redPrice);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, price, offer, measureUnit, redPrice);
    }
}
