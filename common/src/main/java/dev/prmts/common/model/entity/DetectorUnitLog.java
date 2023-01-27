package dev.prmts.common.model.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;

import jakarta.persistence.*;
import org.hibernate.annotations.TimeZoneStorage;
import org.hibernate.annotations.TimeZoneStorageType;

import java.time.OffsetDateTime;
import java.util.List;

@Entity
@Table(name = "detector_unit_log", schema = "public")
@Data
public class DetectorUnitLog {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "macAddress")
    private String macAddress;

    @Column(name = "time_recorded")
    @TimeZoneStorage(TimeZoneStorageType.NORMALIZE_UTC)
    private OffsetDateTime timeRecorded;

    @OneToMany(mappedBy = "detectorUnitLog", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Setter(AccessLevel.NONE)
    @EqualsAndHashCode.Exclude
    private List<SensorLog> sensorLogList;

    public void setSensorLogList(List<SensorLog> sensorLogList) {
        sensorLogList.forEach(sensorLog -> sensorLog.setDetectorUnitLog(this));
        this.sensorLogList = sensorLogList;
    }
}
