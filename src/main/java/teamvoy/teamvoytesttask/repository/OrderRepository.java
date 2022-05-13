package teamvoy.teamvoytesttask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import teamvoy.teamvoytesttask.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query(value = "select * " +
            "from orders where item = :item " +
            "order by price asc limit 1", nativeQuery = true)
    Order getCheapestOrderByItemName(String item);
}
