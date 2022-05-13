package teamvoy.teamvoytesttask.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import teamvoy.teamvoytesttask.model.Item;
import teamvoy.teamvoytesttask.model.ItemType;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class ItemRepositoryTests {
    @Autowired
    ItemRepository itemRepository;

    @Test
    public void getItemByType_Ok() {
        Item item = new Item(1l, "Iphone", "11Pro", ItemType.PHONE);
        Item item1 = new Item(2L, "Lenovo", "New Laptop", ItemType.NOTEBOOK);
        itemRepository.save(item);
        itemRepository.save(item1);

        Item resultItem = itemRepository.getByType("PHONE");
        Assertions.assertThat(resultItem.getName()).isEqualTo(item.getName());
    }
}
