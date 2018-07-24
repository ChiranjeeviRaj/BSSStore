package uk.bss.store.service;

import uk.bss.store.service.model.Basket;
import uk.bss.store.model.Order;

import java.util.List;
import java.util.Map;

public interface BSSStoreService {

    Basket prepareBasket(Map<String, Order> orders);
    Map<String, Order> prepareOrders(List<String> orders);

}
