package teamvoy.teamvoytesttask.dto;

import lombok.Data;
import teamvoy.teamvoytesttask.model.ItemType;

@Data
public class ItemResponseDto {
    private Long id;
    private String name;
    private String description;
    private ItemType type;
}
