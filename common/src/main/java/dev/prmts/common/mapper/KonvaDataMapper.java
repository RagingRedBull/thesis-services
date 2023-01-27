package dev.prmts.common.mapper;

import dev.prmts.common.model.dto.KonvaDataDto;
import dev.prmts.common.model.entity.embedded.KonvaData;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface KonvaDataMapper {
    KonvaData toEntity(KonvaDataDto konvaDataDto);
    KonvaDataDto toDto(KonvaData konvaData);
}
