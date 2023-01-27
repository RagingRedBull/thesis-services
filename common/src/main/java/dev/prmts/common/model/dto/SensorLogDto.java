package dev.prmts.common.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record SensorLogDto(
        @JsonProperty("id")
        Long id,
        @JsonProperty("value")
        Float value,
        @JsonProperty("unit")
        String unit,
        @JsonProperty("type")
        String type) {
}