package uk.bss.store.service.impl;

import uk.bss.store.model.Order;
import uk.bss.store.service.OfferService;
import uk.bss.store.service.model.Basket;
import uk.bss.store.service.util.BSSStoreConstants;
import uk.bss.store.service.util.BSSStoreServiceUtil;

import java.math.BigDecimal;
import java.util.Map;

public class NoOfferServiceImpl implements OfferService {


    @Override
    public void applyOffer(Order order, Basket basket, Map<String, Order> orderMap) {
        calculateNoOfffer(order, basket);
    }

    private void calculateNoOfffer(Order order, Basket basket){
        long qt = order.getQuantity();
        BigDecimal subTotal = BigDecimal.ZERO;

        subTotal = subTotal.add(order.getProduct().getPrice().multiply(new BigDecimal(qt)));


        basket.setSubTotal(basket.getSubTotal().add(subTotal));
        basket.setTotal(basket.getTotal().add(subTotal));
    }
}
