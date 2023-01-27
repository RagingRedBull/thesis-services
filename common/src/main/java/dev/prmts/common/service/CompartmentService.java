package dev.prmts.common.service;

import dev.prmts.common.exeception.EntityNotFoundException;
import dev.prmts.common.mapper.CompartmentMapper;
import dev.prmts.common.model.dto.CompartmentDto;
import dev.prmts.common.model.entity.Compartment;
import dev.prmts.common.repository.CompartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompartmentService {
    private final CompartmentRepository compartmentRepository;
    private final CompartmentMapper compartmentMapper;
    public List<CompartmentDto> findAllByFloorId(Integer floorId) {
        return compartmentMapper.toDtoList(compartmentRepository.findAllByFloorId(floorId));
    }

    public CompartmentDto findById(Integer id) {
        Compartment compartment = compartmentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Compartment.class, id));
        return compartmentMapper.toDto(compartment);
    }
}
