package dev.prmts.common.mapper;

import dev.prmts.common.model.dto.CompartmentDto;
import dev.prmts.common.model.entity.Compartment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {KonvaDataMapper.class})
public interface CompartmentMapper {
    @Mapping(target = "konvaDataDto", source = "konvaData")
    CompartmentDto toDto(Compartment compartment);
    Compartment toEntity(CompartmentDto compartmentDto);
    List<CompartmentDto> toDtoList(List<Compartment> compartmentList);
}
