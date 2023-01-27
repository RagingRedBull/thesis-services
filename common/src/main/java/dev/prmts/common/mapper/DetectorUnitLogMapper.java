package dev.prmts.common.mapper;

import dev.prmts.common.model.dto.DetectorUnitLogDto;
import dev.prmts.common.model.entity.DetectorUnitLog;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Mapper(componentModel = "spring", uses = {SensorLogMapper.class}, collectionMappingStrategy = CollectionMappingStrategy.ACCESSOR_ONLY)
public interface DetectorUnitLogMapper {
    @Mapping(target = "sensorLogDtoList", source = "sensorLogList")
    DetectorUnitLogDto toDto(DetectorUnitLog entity);

    @Mapping(target = "sensorLogList", source = "sensorLogDtoList")
    @Mapping(target = "timeRecorded", ignore = true)
    DetectorUnitLog toEntity(DetectorUnitLogDto dto);

    List<DetectorUnitLogDto> toDto(List<DetectorUnitLog> detectorUnitLogList);

    List<DetectorUnitLog> toEntity(List<DetectorUnitLogDto> detectorUnitLogDtoList);

    default String mapTimeRecordedToString(OffsetDateTime zonedDateTime) {
        return zonedDateTime.withOffsetSameLocal(ZoneOffset.UTC).format(DateTimeFormatter.ISO_INSTANT);
    }

}
