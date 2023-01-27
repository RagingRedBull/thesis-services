package dev.prmts.common.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ContactPersonDto(
        @JsonProperty("id")
        Integer id,
        @JsonProperty("phoneNumber")
        String phoneNumber,
        @JsonProperty("firstName")
        String firstName,
        @JsonProperty("lastName")
        String lastName,
        @JsonProperty("email")
        String email) {
}