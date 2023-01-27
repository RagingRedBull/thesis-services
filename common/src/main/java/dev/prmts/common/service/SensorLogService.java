package dev.prmts.common.service;

import dev.prmts.common.mapper.SensorLogMapper;
import dev.prmts.common.model.dto.SensorLogDto;
import dev.prmts.common.model.entity.DetectorUnitLog;
import dev.prmts.common.model.entity.SensorLog;
import dev.prmts.common.repository.SensorLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class SensorLogService {
    private final SensorLogRepository sensorLogRepository;
    private final SensorLogMapper sensorLogMapper;

    public List<SensorLog> findAllByDetectorUnitLog(Long detectorUnitLogId) {
        return sensorLogRepository.findAllByDetectorUnitLogId(detectorUnitLogId);
    }

    public List<SensorLog> saveAll(Set<SensorLogDto> sensorLogCollection) {
        return sensorLogRepository.saveAll(sensorLogMapper.toEntity(sensorLogCollection));
    }

}
