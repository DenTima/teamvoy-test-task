package teamvoy.teamvoytesttask.dto;

import lombok.Data;
import teamvoy.teamvoytesttask.model.ItemType;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class OrderResponseDto {
    private Long id;
    private BigDecimal price;
    private int quantity;
    private ItemType item;
    private LocalDateTime dateTime;
}
