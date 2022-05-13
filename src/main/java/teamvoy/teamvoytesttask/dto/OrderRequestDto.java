package teamvoy.teamvoytesttask.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import teamvoy.teamvoytesttask.model.ItemType;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequestDto {
    private BigDecimal price;
    private int quantity;
    private ItemType item;
}
