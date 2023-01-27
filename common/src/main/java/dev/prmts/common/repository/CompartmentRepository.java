package dev.prmts.common.repository;

import dev.prmts.common.model.entity.Compartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompartmentRepository extends JpaRepository<Compartment, Integer> {
    @Query("SELECT c FROM Compartment c WHERE c.floor.id=?1")
    List<Compartment> findAllByFloorId(Integer floorId);
}
