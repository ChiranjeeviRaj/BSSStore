package uk.bss.store.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.bss.store.entity.manager.ProductManager;
import uk.bss.store.model.OfferType;
import uk.bss.store.model.Product;
import uk.bss.store.service.BSSStoreService;
import uk.bss.store.service.OfferService;
import uk.bss.store.service.exception.InvalidArgumentExcpetion;
import uk.bss.store.service.exception.ProductsNotFoundExcpetion;
import uk.bss.store.service.factory.OfferFactory;
import uk.bss.store.service.model.Basket;
import uk.bss.store.model.Order;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class BSSStoreServiceImpl implements BSSStoreService {

    @Autowired
    private ProductManager productManager;

    /**
     * This below method accepts orders and prepare basket.
     * The map contain Product name as key and values orders. Each Order has Product and Quantity.
     * @param orders
     * @return the @Basket
     */
    @Override
    public Basket prepareBasket(Map<String, Order> orders) {
        Basket basket = new Basket();
        //basket.setSubTotal(calculateSubTotal());

        // Apply Percentage Offers
        for (Order order: orders.values()) {
                    calculateOffer(order, basket, orders);
        }

        basket.setTotal(basket.getTotal().setScale(2, BigDecimal.ROUND_FLOOR));
        basket.setSubTotal(basket.getSubTotal().setScale(2, BigDecimal.ROUND_FLOOR));

        return basket;
    }

    /**
     * The below method accepts List of Product Names and also validates the inputs
     * @param orders
     * @return Map of order Name and Order.
     */
    @Override
    public Map<String, Order> prepareOrders(List<String> orders) {
        if(orders.isEmpty()){
            throw new InvalidArgumentExcpetion();
        }

        Map<String, Order> allProducts = productManager.fetchOrderMapByProductNames(orders);

        if(allProducts.isEmpty()){
            throw new ProductsNotFoundExcpetion();
        }

        return allProducts;
    }

    /**
     * The below method calculate each offer and prepare the basket by suming each
     * @param order current order
     * @param basket same as above
     * @param ordersMap same as above
     */
    private void calculateOffer(Order order, Basket basket, Map<String, Order> ordersMap){
        OfferType offerType = null;

        if(order.getProduct().getOffer() != null) {
            offerType = order.getProduct().getOffer().getOfferType();
        }

        OfferService offerService = OfferFactory.getOfferService(offerType);
        offerService.applyOffer(order, basket, ordersMap);

    }

    public ProductManager getProductManager() {
        return productManager;
    }

    public void setProductManager(ProductManager productManager) {
        this.productManager = productManager;
    }
}
