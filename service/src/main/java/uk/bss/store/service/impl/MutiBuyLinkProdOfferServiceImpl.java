package uk.bss.store.service.impl;

import uk.bss.store.model.Product;
import uk.bss.store.service.OfferService;
import uk.bss.store.service.model.Basket;
import uk.bss.store.model.Order;
import uk.bss.store.service.util.BSSStoreConstants;
import uk.bss.store.service.util.BSSStoreServiceUtil;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

public class MutiBuyLinkProdOfferServiceImpl implements OfferService {
    static final String PER_OFFER_FORMAT = "2 %s(s), %s 50%% off: -%sp";


    @Override
    public void applyOffer(Order order, Basket basket, Map<String, Order> orderMap) {
        calculateMultiBuyOffer(order, basket, orderMap);
    }

    private void calculateMultiBuyOffer(Order curretOrder, Basket basket, Map<String, Order> orderMap){
        BigDecimal qt = new BigDecimal(curretOrder.getQuantity());
        BigDecimal subTotal = BigDecimal.ZERO;
        BigDecimal total = BigDecimal.ZERO;

        Product linkedProd = curretOrder.getProduct().getOffer().getLinkProduct();
        Order linedOrder = orderMap.get(linkedProd.getName());

        //When the Multi Buy is not eligible don't cal offers
        if(linedOrder != null && linedOrder.getQuantity() >= curretOrder.getProduct().getOffer().getQuantity()) {

            BigDecimal reducedPrice = curretOrder.getProduct().getPrice()
                    .multiply(new BigDecimal(linedOrder.getQuantity())
                      .divide(new BigDecimal(curretOrder.getProduct().getOffer().getQuantity())))
                    .multiply(new BigDecimal(0.5));

            subTotal = subTotal.add(curretOrder.getProduct().getPrice().multiply(qt));

            total = subTotal.subtract(reducedPrice);

            String offerStr = String.format(PER_OFFER_FORMAT
                    , curretOrder.getProduct().getOffer().getLinkProduct().getName()
                    , curretOrder.getProduct().getName()
                    , reducedPrice.setScale(2, RoundingMode.FLOOR));

            basket.setSubTotal(basket.getSubTotal().add(subTotal));
            basket.setTotal(basket.getTotal().add(total));
            basket.getOfferStrings().add(offerStr);

        }else{
            //whithout calculating offers
            subTotal = subTotal.add(curretOrder.getProduct().getPrice().multiply(qt));

            basket.setSubTotal(basket.getSubTotal().add(subTotal));
            basket.setTotal(basket.getTotal().add(subTotal));
        }
    }

    public Order fetchLinkedProduct(Map<String, Order> orderMap, Order currentOrder){
        Product linkedProd = currentOrder.getProduct().getOffer().getLinkProduct();

        Order linedOrder = orderMap.get(orderMap.get(linkedProd.getName()));

        return linedOrder;
    }
}
