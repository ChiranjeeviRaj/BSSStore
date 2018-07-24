package uk.bss.store.entity.manager;

import java.util.List;
import java.util.Map;

import uk.bss.store.model.*;

public interface ProductManager {

    List<Product> fetchProdcuts();

    Map<String, Order> fetchOrderMapByProductNames(List<String> orders);
}
