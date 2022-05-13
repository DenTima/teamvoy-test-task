package teamvoy.teamvoytesttask.service.impl;

import org.springframework.stereotype.Service;
import teamvoy.teamvoytesttask.model.Order;
import teamvoy.teamvoytesttask.repository.OrderRepository;
import teamvoy.teamvoytesttask.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order getOrderById(Long id) {
        return orderRepository.getById(id);
    }

    @Override
    public void delete(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public Order getCheapestOrderByItemName(String item) {
        return orderRepository.getCheapestOrderByItemName(item);
    }
}
