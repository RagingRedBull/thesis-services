package dev.prmts.common.repository;

import dev.prmts.common.model.entity.Floor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FloorRepository extends JpaRepository<Floor, Integer> {
    @Modifying
    @Query("UPDATE Floor a SET a.fileName = :fileName")
    void updateFileName(@Param("fileName") String fileName);
}
