package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import uk.bss.store.model.Product;
import uk.bss.store.service.BSSStoreService;
import uk.bss.store.service.exception.InvalidArgumentExcpetion;
import uk.bss.store.service.exception.ProductsNotFoundExcpetion;
import uk.bss.store.service.impl.BSSStoreServiceImpl;
import uk.bss.store.model.Order;
import uk.bss.store.service.model.Basket;
import uk.bss.store.service.util.BSSStoreServiceUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class BSSStoreServiceImplTest {

    public static String APPLES_MILK_BREAD = "Apples Milk Bread";
    public static String APPLES_APPLES = "Apples Apples";
    public static String EMPTY = "";
    public static String IN_VALID = "InValid";
    public static String APPLES_2_TINS = "Apples Soup Soup";
    public static String APPLES_2_SOUP_BREAD = "Apples Soup Soup Bread";
    public static String TINS_2 = "Soup Soup";
    public static String SOUP = "Soup";






    private static final String TOTALS_NO_OFFERS =
            "Subtotal: £0.00\n" +
                    "(no offers available)\n" +
                    "Total: £0.00";
    private static final String TOTALS_APPLES_MILK_OFFER =
            "Subtotal: £3.10\n" +
                    "Apples 10% off: -10p\n" +
                    "Total: £3.00";

    private static final String TOTALS_APPLES_2_SUPS_BREAD_OFFER =
            "Subtotal: £3.10\n" +
                    "Apples 10% off: -10p\n" +
                    "2 Soup(s), Bread 50% off: -0.40p\n"+
                    "Total: £2.60";

    private static final String TOTALS_2APPLES_OFFER =
            "Subtotal: £2.00\n" +
                    "Apples 10% off: -20p\n" +
                    "Total: £1.80";
    private static final String TOTALS_APPLES_2TINS_OFFER =
            "Subtotal: £2.30\n" +
                    "Apples 10% off: -10p\n" +
                    "Total: £2.20";
    private static final String TOTALS_SOUP_BRED_OFFER =
            "Subtotal: £1.30\n" +
                   // "2 Soup(s), Bread 50% off: -0.40p\n" +
                    "(no offers available)\n"+
                    "Total: £1.30";
    private static final String TOTALS_SOUP_NO_OFFERS =
            "Subtotal: £0.65\n" +
                    "(no offers available)\n" +
                    "Total: £0.65";

    @Autowired
    private BSSStoreService bssStoreService;

    @Test
    public void testPrepareBasketWhenOrderHasOneDiscount(){
        Basket basket = bssStoreService.prepareBasket(populateOrders(APPLES_MILK_BREAD));
        Assert.assertNotNull(basket);
        Assert.assertEquals(TOTALS_APPLES_MILK_OFFER, basket.toString());
        System.out.println(basket);
    }

    @Test
    public void testPrepareBasketWhenOrderHasTwoDiscount(){
        Basket basket = bssStoreService.prepareBasket(populateOrders(APPLES_2_SOUP_BREAD));
        Assert.assertNotNull(basket);
        Assert.assertEquals(TOTALS_APPLES_2_SUPS_BREAD_OFFER, basket.toString());
        System.out.println(basket);
    }

    @Test
    public void testPrepareBasketWhenOrderHasTwoApplesDiscount(){
        Basket basket = bssStoreService.prepareBasket(populateOrders(APPLES_APPLES));
        Assert.assertNotNull(basket);
        Assert.assertEquals(TOTALS_2APPLES_OFFER, basket.toString());
        System.out.println(basket);
    }

    @Test(expected = InvalidArgumentExcpetion.class)
    public void testPrepareBasketWhenOrderHasNoItems(){
        Basket basket = bssStoreService.prepareBasket(populateOrders(EMPTY));
        Assert.assertNotNull(basket);
        Assert.assertEquals(TOTALS_NO_OFFERS, basket.toString());
        System.out.println(basket);
    }

    @Test(expected = ProductsNotFoundExcpetion.class)
    public void testPrepareBasketWhenOrderHasInValidItems(){
        Basket basket = bssStoreService.prepareBasket(populateOrders(IN_VALID));
        Assert.assertNotNull(basket);
        Assert.assertEquals(TOTALS_NO_OFFERS, basket.toString());
        System.out.println(basket);
    }

    @Test
    public void testPrepareBasketWhenOrderHasNoOfferItems(){
        Basket basket = bssStoreService.prepareBasket(populateOrders(SOUP));
        Assert.assertNotNull(basket);
        Assert.assertEquals(TOTALS_SOUP_NO_OFFERS, basket.toString());
        System.out.println(basket);
    }

    @Test
    public void testPrepareBasketWhenOrderHasTwoOffersApplesAnd2Tins(){
        Basket basket = bssStoreService.prepareBasket(populateOrders(APPLES_2_TINS));
        Assert.assertNotNull(basket);
        Assert.assertEquals(TOTALS_APPLES_2TINS_OFFER, basket.toString());
        System.out.println(basket);
    }

    @Test
    public void testPrepareBasketWhenOrderHasTwoOffers2Tins(){
        Basket basket = bssStoreService.prepareBasket(populateOrders(TINS_2));
        Assert.assertNotNull(basket);
        Assert.assertEquals(TOTALS_SOUP_BRED_OFFER, basket.toString());
        System.out.println(basket);
    }

    public Map<String, Order> populateOrders(String orderStr){
        return bssStoreService.prepareOrders(BSSStoreServiceUtil.listConverter(orderStr));
    }

    public BSSStoreService getBssStoreService() {
        return bssStoreService;
    }

    public void setBssStoreService(BSSStoreService bssStoreService) {
        this.bssStoreService = bssStoreService;
    }
}
