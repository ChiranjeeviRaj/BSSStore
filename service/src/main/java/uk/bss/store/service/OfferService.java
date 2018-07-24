package uk.bss.store.service;

import uk.bss.store.service.model.Basket;
import uk.bss.store.model.Order;

import java.util.Map;

public interface OfferService {

    void applyOffer(Order order, Basket basket, Map<String, Order> ordersMap);
}
