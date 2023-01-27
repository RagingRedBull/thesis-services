package dev.prmts.common.model.entity;

import dev.prmts.common.model.entity.embedded.KonvaData;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "compartment")
@Getter
@Setter
public class Compartment {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name", length = 30)
    private String name;
    @Embedded
    private KonvaData konvaData;
//    @OneToMany(mappedBy = "compartment")
//    private List<DetectorUnit> detectorUnitList;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "floor_id", nullable = false)
    private Floor floor;
}
