import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import uk.bss.store.model.Order;
import uk.bss.store.service.BSSStoreService;
import uk.bss.store.service.model.Basket;
import uk.bss.store.service.util.BSSStoreServiceUtil;

public class Main {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/service-beans.xml");

		BSSStoreService bssStoreService = (BSSStoreService) context.getBean("bssStoreService");
		
    	List<String> items = Arrays.asList(args);
		Map<String, Order> orders = bssStoreService.prepareOrders(BSSStoreServiceUtil.arrayConverter(args));
		Basket basket = bssStoreService.prepareBasket(orders);

		System.out.println(basket);
	}

}
