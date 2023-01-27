package dev.prmts.common.mapper;

import dev.prmts.common.model.dto.SensorLogDto;
import dev.prmts.common.model.entity.SensorLog;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public interface SensorLogMapper {
    SensorLogDto toDto(SensorLog sensorLog);
    @Mapping(target = "detectorUnitLog", ignore = true)
    SensorLog toEntity(SensorLogDto sensorLogDto);

    List<SensorLogDto> toDto(List<SensorLog> sensorLogList);
    List<SensorLog> toEntity(Collection<SensorLogDto> sensorLogDtoList);
}
