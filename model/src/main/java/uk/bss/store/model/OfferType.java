package uk.bss.store.model;

public enum OfferType {
    PER_RED("Percentage Reduced"), MULTI_BUY_LNK_PROD("Buy 2 and get another product");

    private String name;
    private String description;

    private OfferType(String description){
        this.description = description;
    }
}
