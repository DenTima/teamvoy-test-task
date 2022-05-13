package teamvoy.teamvoytesttask.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import teamvoy.teamvoytesttask.dto.OrderRequestDto;
import teamvoy.teamvoytesttask.dto.OrderResponseDto;
import teamvoy.teamvoytesttask.service.OrderService;
import teamvoy.teamvoytesttask.service.mapper.OrderMapper;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@RequiredArgsConstructor
@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;
    private final OrderMapper orderMapper;

    @PostMapping
    public OrderResponseDto create(@RequestBody OrderRequestDto requestDto) {
        return orderMapper.mapToDto(orderService.save(orderMapper.mapToModel(requestDto)));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        LocalDateTime dateTime = LocalDateTime.now();
        long lifeTimeOrder = ChronoUnit.MINUTES.between(orderService.getOrderById(id).getCreationTime(), dateTime);
        if (lifeTimeOrder < 10) {
            orderService.delete(id);
        } else throw new RuntimeException("This order is valid. You can't delete this order!");
    }
}
