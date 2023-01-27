package dev.prmts.common.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record DetectorUnitDto(
        String macAddress
) {
}
