package dev.prmts.common.model.entity;

import lombok.Data;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "sensor_log", schema = "public")
@Data
public class SensorLog {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "value")
    private Float value;
    @Column(name = "unit")
    private String unit;
    @Column(name = "type")
    private String type;

    @ManyToOne
    @JoinColumn(name = "detector_unit_log_id", nullable = false)
    private DetectorUnitLog detectorUnitLog;
}
