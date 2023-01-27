package dev.prmts.common.service;

import dev.prmts.common.exeception.EntityNotFoundException;
import dev.prmts.common.mapper.FloorMapper;
import dev.prmts.common.model.dto.FloorDto;
import dev.prmts.common.model.entity.Floor;
import dev.prmts.common.repository.FloorRepository;
import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FloorService {
    private final FloorMapper floorMapper;
    private final FloorRepository floorRepository;

    public List<FloorDto> findAll() {
        return floorMapper.toDto(floorRepository.findAll());
    }

    public FloorDto findById(Integer id) {
        return floorMapper.toDto(findEntityById(id));
    }
    private Floor findEntityById(Integer id) {
        return floorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Floor.class, id));
    }
    public FloorDto save(FloorDto floorDto) {
        Floor floor = floorMapper.toEntity(floorDto);
        return floorMapper.toDto(saveEntity(floor));
    }

    private Floor saveEntity(Floor floor) {
        return floorRepository.save(floor);
    }
    public FloorDto updateFileName(Integer id, String fileName) {
        Floor floor = findEntityById(id);
        floor.setFileName(fileName);
        floor = saveEntity(floor);
        return floorMapper.toDto(floor);
    }

    public FloorDto update(FloorDto dto) {
        Floor entity = floorRepository.getReferenceById(dto.id());
        entity = saveEntity(updateData(dto, entity));
        return floorMapper.toDto(entity);
    }

    private Floor updateData(FloorDto dto, Floor floor) {
        floor.setFileName(dto.fileName());
        floor.setName(dto.name());
        floor.setSequence(dto.sequence());
        return floor;
    }
}
