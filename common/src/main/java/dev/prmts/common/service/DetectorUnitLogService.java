package dev.prmts.common.service;

import dev.prmts.common.exeception.EntityNotFoundException;
import dev.prmts.common.mapper.DetectorUnitLogMapper;
import dev.prmts.common.model.dto.DetectorUnitLogDto;
import dev.prmts.common.model.entity.DetectorUnitLog;
import dev.prmts.common.repository.DetectorUnitLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DetectorUnitLogService {
    private final DetectorUnitLogRepository detectorUnitLogRepository;
    private final DetectorUnitLogMapper detectorUnitLogMapper;
    public List<DetectorUnitLogDto> findAll() {
        return detectorUnitLogMapper.toDto(detectorUnitLogRepository.findAllWithSensorLogs());
    }

    public DetectorUnitLogDto findById(Long id) {
        return detectorUnitLogRepository.findById(id)
                .map(detectorUnitLogMapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException(this.getClass(), id));
    }

    public List<DetectorUnitLogDto> findByMacAddress(String macAddress) {
        return detectorUnitLogMapper.toDto(detectorUnitLogRepository.findByMacAddress(macAddress));
    }

    public DetectorUnitLogDto save(DetectorUnitLogDto detectorUnitLogDto) {
        DetectorUnitLog entity = detectorUnitLogMapper.toEntity(detectorUnitLogDto);
        entity.setTimeRecorded(OffsetDateTime.now(ZoneId.systemDefault()));
        return detectorUnitLogMapper.toDto(detectorUnitLogRepository.save(entity));
    }

    public DetectorUnitLog save(DetectorUnitLog detectorUnitLog) {
        return detectorUnitLogRepository.save(detectorUnitLog);
    }
}
