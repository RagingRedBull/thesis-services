package dev.prmts.common.repository;

import dev.prmts.common.model.entity.SensorLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SensorLogRepository extends JpaRepository<SensorLog, Long> {
    @Query("SELECT a FROM SensorLog a WHERE a.detectorUnitLog.id = ?1")
    List<SensorLog> findAllByDetectorUnitLogId(Long id);
}
