package dev.prmts.image.service.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record FileInfoDto(
        Integer floorId,
        String message
) {
}
