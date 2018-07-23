package uk.bss.store.model;

public enum OfferType {
    PER_RED("Percentage Reduced"), MULTI_BUT("Buy one and Get one Offer"), MULTI_BUY_LNK_PROD("Buy 2 and get another product");

    private String name;
    private String description;

    private OfferType(String description){
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
