package teamvoy.teamvoytesttask.service.mapper;

import org.springframework.stereotype.Component;
import teamvoy.teamvoytesttask.dto.ItemResponseDto;
import teamvoy.teamvoytesttask.model.Item;

@Component
public class ItemMapper implements ResponseDtoMapper<ItemResponseDto, Item> {
    @Override
    public ItemResponseDto mapToDto(Item item) {
        ItemResponseDto responseDto = new ItemResponseDto();
        responseDto.setId(item.getId());
        responseDto.setName(item.getName());
        responseDto.setDescription(item.getDescription());
        responseDto.setType(item.getType());
        return responseDto;
    }
}
