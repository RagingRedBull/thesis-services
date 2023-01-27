package dev.prmts.common.mapper;

import dev.prmts.common.model.dto.ContactPersonDto;
import dev.prmts.common.model.entity.ContactPerson;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface ContactPersonMapper {
    @Mapping(target = "deleted", ignore = true)
    ContactPerson toEntity(ContactPersonDto contactPersonDto);
    ContactPersonDto toDto(ContactPerson contactPerson);

    List<ContactPerson> toEntity(List<ContactPersonDto> contactPersonDtoList);
    List<ContactPersonDto> toDto(List<ContactPerson> contactPersonList);
}
