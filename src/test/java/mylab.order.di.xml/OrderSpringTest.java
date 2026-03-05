package mylab.order.di.xml;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig
@ContextConfiguration(locations = "classpath:mylab-order-di.xml")
public class OrderSpringTest {

        @Autowired
        private ShoppingCart cart;

        @Autowired
        private OrderService service;

        @Test
        void testShoppingCart() {
                assertNotNull(cart);
                assertNotNull(cart.getProducts());
                assertEquals(2, cart.getProducts().size());
                assertEquals("노트북", cart.getProducts().get(0).getName());
                assertEquals("스마트폰", cart.getProducts().get(1).getName());
        }

        @Test
        void testOrderService() {
                assertNotNull(service);
                assertNotNull(service.getShoppingCart());
                assertEquals(950000.0, service.calculateOrderTotal(), 0.0001);
        }
}