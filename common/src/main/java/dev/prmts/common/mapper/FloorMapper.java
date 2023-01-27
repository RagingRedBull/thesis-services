package dev.prmts.common.mapper;

import dev.prmts.common.model.dto.FloorDto;
import dev.prmts.common.model.entity.Floor;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FloorMapper {
    Floor toEntity(FloorDto floorDto);
    FloorDto toDto(Floor floor);

    List<Floor> toEntity(List<FloorDto> floorDtoList);
    List<FloorDto> toDto(List<Floor> floorList);
}
