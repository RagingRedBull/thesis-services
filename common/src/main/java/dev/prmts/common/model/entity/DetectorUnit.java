package dev.prmts.common.model.entity;

import lombok.Data;

import jakarta.persistence.*;


@Entity
@Table(name = "detector_unit", schema = "public")
@Data
public class DetectorUnit {
    @Id
    @Column(name = "mac_address", length = 16)
    private String macAddress;
    @Column(name = "ip_address")
    private String ipAddress;
//    @ManyToOne
//    @JoinColumn(name = "compartment_id", nullable = false)
//    private Compartment compartment;
}
