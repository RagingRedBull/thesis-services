package dev.prmts.common.repository;

import dev.prmts.common.model.entity.DetectorUnitLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetectorUnitLogRepository extends JpaRepository<DetectorUnitLog, Long> {
    @Query("SELECT DISTINCT a FROM DetectorUnitLog a JOIN FETCH a.sensorLogList b WHERE a.macAddress=?1 ORDER BY a.timeRecorded ASC")
    List<DetectorUnitLog> findByMacAddress(String macAddress);

    @Query("SELECT DISTINCT a FROM DetectorUnitLog a JOIN FETCH a.sensorLogList b ORDER BY a.timeRecorded ASC")
    List<DetectorUnitLog> findAllWithSensorLogs();
}
