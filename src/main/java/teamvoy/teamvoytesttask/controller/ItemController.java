package teamvoy.teamvoytesttask.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import teamvoy.teamvoytesttask.dto.ItemResponseDto;
import teamvoy.teamvoytesttask.model.Item;
import teamvoy.teamvoytesttask.model.Order;
import teamvoy.teamvoytesttask.service.ItemService;
import teamvoy.teamvoytesttask.service.OrderService;
import teamvoy.teamvoytesttask.service.mapper.ItemMapper;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/items")
public class ItemController {
    private final OrderService orderService;
    private final ItemService itemService;
    private final ItemMapper itemMapper;

    @GetMapping
    public List<ItemResponseDto> getAvailableCheapestItems(@RequestParam String itemType) {
        Order order = orderService.getCheapestOrderByItemName(itemType);
        List<ItemResponseDto> items = new ArrayList<>();
        for (int i = 0; i < order.getQuantity(); i++) {
            Item item = itemService.getByType(itemType);
            if (item != null) {
                items.add(itemMapper.mapToDto(item));
                itemService.delete(item.getId());
            }
        }
        return items;
    }
}
