package uk.bss.store.service.impl;

import uk.bss.store.service.OfferService;
import uk.bss.store.service.model.Basket;
import uk.bss.store.model.Order;
import uk.bss.store.service.util.BSSStoreServiceUtil;

import java.math.BigDecimal;
import java.util.Map;

public class PercetageOfferServiceImpl implements OfferService {
    public static final int HUNDRED = 100;
    static final String PER_OFFER_FORMAT = "%s %s%% off: -%sp";


    public void applyOffer(Order order, Basket basket, Map<String, Order> orderMap) {
        calculatePerReduction(order, basket);
    }

    private void calculatePerReduction(Order order, Basket basket){
        long qt = order.getQuantity();
        BigDecimal subTotal = BigDecimal.ZERO;
        BigDecimal total = BigDecimal.ZERO;


        subTotal = order.getProduct().getPrice().multiply(new BigDecimal(qt));
        BigDecimal reducedPrice =  BSSStoreServiceUtil.getPense(subTotal)
                .multiply(order.getProduct().getOffer().getProdPerc()).divide(new BigDecimal(HUNDRED));

        total = BSSStoreServiceUtil.getPounds(BSSStoreServiceUtil.getPense(subTotal).subtract(reducedPrice));

        String offerStr= String.format(PER_OFFER_FORMAT, order.getProduct().getName()
                , order.getProduct().getOffer().getProdPerc().toString()
                , reducedPrice.toString());


        basket.setSubTotal(basket.getSubTotal().add(subTotal));
        basket.setTotal(basket.getTotal().add(total));
        basket.getOfferStrings().add(offerStr);
    }
}
