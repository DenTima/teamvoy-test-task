package teamvoy.teamvoytesttask.service.impl;

import org.springframework.stereotype.Service;
import teamvoy.teamvoytesttask.model.Item;
import teamvoy.teamvoytesttask.repository.ItemRepository;
import teamvoy.teamvoytesttask.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Item getByType(String type) {
        return itemRepository.getByType(type);
    }

    @Override
    public void delete(Long id) {
        itemRepository.deleteById(id);
    }
}
