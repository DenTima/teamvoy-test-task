package teamvoy.teamvoytesttask.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import teamvoy.teamvoytesttask.model.ItemType;
import teamvoy.teamvoytesttask.model.Order;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class OrderRepositoryTests {
    @Autowired
    private OrderRepository orderRepository;

    @Test
    public void saveOrder_Ok() {
        Order order = new Order();
        order.setPrice(new BigDecimal(23));
        order.setQuantity(4);
        order.setItem(ItemType.PHONE);
        orderRepository.save(order);
        Assertions.assertThat(order.getId()).isGreaterThan(0);
    }

    @Test
    public void getOrderById_Ok() {
        Order order = new Order(1L, new BigDecimal(24), 4, ItemType.PHONE, LocalDateTime.now());
        orderRepository.save(order);
        Order expectedOrder = orderRepository.findById(1L).get();
        Assertions.assertThat(expectedOrder.getId()).isEqualTo(order.getId());
    }

    @Test
    public void getCheapestOrderByItemName_Ok() {
        Order order = new Order(1L, new BigDecimal(24), 4, ItemType.PHONE, LocalDateTime.now());
        Order order1 = new Order(2L, new BigDecimal(21), 4, ItemType.PHONE, LocalDateTime.now());
        Order order2 = new Order(3L, new BigDecimal(19), 4, ItemType.PC, LocalDateTime.now());
        orderRepository.save(order);
        orderRepository.save(order1);
        orderRepository.save(order2);

        Order resultOrder = orderRepository.getCheapestOrderByItemName("PHONE");
        Assertions.assertThat(resultOrder.getPrice()).isEqualTo(order1.getPrice());
    }

    @Test
    public void deleteOrder_Ok() {
        Order order = new Order(1L, new BigDecimal(24), 4, ItemType.PHONE, LocalDateTime.now());
        orderRepository.save(order);
        orderRepository.delete(order);
        Order order1 = null;
        Optional<Order> optionalOrder = orderRepository.findById(1L);
        if (optionalOrder.isPresent()) {
            order1 = optionalOrder.get();
        }
        Assertions.assertThat(order1).isNull();
    }
}
