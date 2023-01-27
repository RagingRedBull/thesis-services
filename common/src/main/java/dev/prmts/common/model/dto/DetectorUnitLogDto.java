package dev.prmts.common.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record DetectorUnitLogDto(
        @JsonProperty("id")
        Long id,
        @JsonProperty("macAddress")
        String macAddress,
        @JsonProperty("timeRecorded")
        String timeRecorded,
        @JsonProperty("sensorLogDtoSet")
        List<SensorLogDto> sensorLogDtoList
) {
}