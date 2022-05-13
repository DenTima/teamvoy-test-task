package teamvoy.teamvoytesttask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import teamvoy.teamvoytesttask.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    @Query(value = "select * from items where type = :type limit 1", nativeQuery = true)
    Item getByType(String type);
}
