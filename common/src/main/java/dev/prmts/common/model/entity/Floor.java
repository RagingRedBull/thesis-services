package dev.prmts.common.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "floor", schema = "public")
@Data
public class Floor {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "sequence")
    private Integer sequence;
    @Column(name = "file_name")
    private String fileName;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "floor")
    private List<Compartment> compartmentList;
}
