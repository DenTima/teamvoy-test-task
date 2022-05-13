package teamvoy.teamvoytesttask.service;

import teamvoy.teamvoytesttask.model.Order;

public interface OrderService {
    Order save(Order order);
    Order getOrderById(Long id);
    void delete(Long id);
    Order getCheapestOrderByItemName(String item);
}
