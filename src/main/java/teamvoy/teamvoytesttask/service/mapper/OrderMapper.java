package teamvoy.teamvoytesttask.service.mapper;

import org.springframework.stereotype.Component;
import teamvoy.teamvoytesttask.dto.OrderRequestDto;
import teamvoy.teamvoytesttask.dto.OrderResponseDto;
import teamvoy.teamvoytesttask.model.Order;

@Component
public class OrderMapper implements RequestDtoMapper<OrderRequestDto, Order>, ResponseDtoMapper<OrderResponseDto, Order> {
    @Override
    public Order mapToModel(OrderRequestDto dto) {
        Order order = new Order();
        order.setPrice(dto.getPrice());
        order.setQuantity(dto.getQuantity());
        order.setItem(dto.getItem());
        return order;
    }

    @Override
    public OrderResponseDto mapToDto(Order order) {
        OrderResponseDto responseDto = new OrderResponseDto();
        responseDto.setId(order.getId());
        responseDto.setPrice(order.getPrice());
        responseDto.setQuantity(order.getQuantity());
        responseDto.setItem(order.getItem());
        responseDto.setDateTime(order.getCreationTime());
        return responseDto;
    }
}
