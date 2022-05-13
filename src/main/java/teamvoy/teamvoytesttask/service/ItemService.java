package teamvoy.teamvoytesttask.service;

import teamvoy.teamvoytesttask.model.Item;

public interface ItemService {
    Item getByType(String type);
    void delete(Long id);
}
