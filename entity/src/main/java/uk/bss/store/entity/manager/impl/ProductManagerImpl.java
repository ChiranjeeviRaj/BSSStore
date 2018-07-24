package uk.bss.store.entity.manager.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.bss.store.entity.manager.MockEntityFactory;
import uk.bss.store.entity.manager.ProductManager;
import uk.bss.store.model.Order;
import uk.bss.store.model.Product;

import java.util.List;
import java.util.Map;

@Service
public class ProductManagerImpl implements ProductManager {

    //This is Mock factory which shoud be repalce once the persistence api confirmed.
    @Autowired
    private MockEntityFactory entityFactory;

    public List<Product> fetchProdcuts() {
        return entityFactory.fetchProducts();
    }

    public Map<String, Order> fetchOrderMapByProductNames(List<String> orders){
       return entityFactory.fetchOrderMapByProductNames(orders);
    }
    public MockEntityFactory getEntityFactory() {
        return entityFactory;
    }

    public void setEntityFactory(MockEntityFactory entityFactory) {
        this.entityFactory = entityFactory;
    }


}
