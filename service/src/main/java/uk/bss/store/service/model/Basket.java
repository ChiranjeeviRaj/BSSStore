package uk.bss.store.service.model;

import uk.bss.store.model.Order;
import uk.bss.store.service.util.BSSStoreConstants;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Basket {
    private BigDecimal subTotal = BigDecimal.ZERO;
    private List<String> offerStrings = new ArrayList<String>();
    private BigDecimal total = BigDecimal.ZERO;

    @Override
    public String toString() {
        return "Subtotal: £" + subTotal +
                "\n" + printOfferString() +
                "\nTotal: £" + total;
    }

    public void addOfferStringForPerRed(Order order){
    }

    private String printOfferString(){
        if(offerStrings.isEmpty()){
            return BSSStoreConstants.NO_OFFERS;
        }
        return String.join("\n", offerStrings
        );
    }

    private void addOfferStringForPerRed(){
        StringBuilder builder = new StringBuilder();
    }

    public BigDecimal getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }

    public List<String> getOfferStrings() {
        return offerStrings;
    }

    public void setOfferStrings(List<String> offerStrings) {
        this.offerStrings = offerStrings;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
