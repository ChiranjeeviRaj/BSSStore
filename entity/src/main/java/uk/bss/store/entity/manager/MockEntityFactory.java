package uk.bss.store.entity.manager;

import org.springframework.stereotype.Repository;
import uk.bss.store.model.*;

import java.math.BigDecimal;
import java.util.*;

@Repository
public class MockEntityFactory {

    public static List<Product> fetchProducts(){
        return new ArrayList<Product>(fetchProductsMap().values());
    }

    public static Map<String, Product> fetchProductsMap(){
        Map<String, Product> map = new HashMap<String, Product>();

        Offer perOffer = new Offer();
        peparePerOffer(perOffer);
        Product apple = prepreProduct(100l,"Apples", MeasureUnit.BAG, new BigDecimal(1.00), perOffer);
        map.put("Apples", apple);

        Product soup = prepreProduct(102l,"Soup", MeasureUnit.TIN, new BigDecimal(0.65), null);
        map.put("Soup", soup);

        Offer multiBuyOffer = new Offer();
        pepareMultyBuyOffer(multiBuyOffer, soup);
        Product bread = prepreProduct(101l,"Bread", MeasureUnit.LOAF, new BigDecimal(0.80), multiBuyOffer);
        map.put("Bread", bread);

        Product milk = prepreProduct(103l,"Milk", MeasureUnit.BOTTLE, new BigDecimal(1.30), null);
        map.put("Milk", milk);

        return map;
    }

    public static Map<String, Order> fetchOrderMapByProductNames(List<String> names){
        List<Product> products  = fetchProducts();
        Map<String, Product> map = fetchProductsMap();

        final Map<String, Order> prodcutOrderMap = new HashMap<String, Order>();
        products.forEach(
                product ->
                    names.stream().forEach(
                            name ->
                            {
                                if(name.equals(product.getName())){
                                    if(prodcutOrderMap.containsKey(product.getName())){
                                        prodcutOrderMap.get(product.getName())
                                                .incrementQuantity();
                                    }else{
                                        prodcutOrderMap.put(name, new Order(map.get(name), 1l));
                                    }

                                }
                            }

                    )

        );

        return prodcutOrderMap;
    }

    private static void peparePerOffer(Offer perOffer) {
        perOffer.setOfferType(OfferType.PER_RED);
        perOffer.setProdPerc(new BigDecimal(10));
    }

    private static void pepareMultyBuyOffer(Offer perOffer, Product linkProd) {
        perOffer.setOfferType(OfferType.MULTI_BUY_LNK_PROD);
        perOffer.setLinkProduct(linkProd);
        perOffer.setQuantity(2l);
    }

    private static Product prepreProduct(long id, String name,MeasureUnit unit, BigDecimal price, Offer perOffer) {
        Product product = new Product();
        product.setId(id);
        product.setOffer(perOffer);
        product.setName(name);
        product.setMeasureUnit(unit);
        product.setPrice(price);
        return product;
    }
}
