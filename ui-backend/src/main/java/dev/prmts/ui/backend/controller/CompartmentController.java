package dev.prmts.ui.backend.controller;

import dev.prmts.common.model.dto.CompartmentDto;
import dev.prmts.common.service.CompartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/compartments")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class CompartmentController {
    private final CompartmentService compartmentService;

    @GetMapping(params = "floorId")
    public List<CompartmentDto> findAllByFloorId(@RequestParam(name = "floorId") Integer floorId) {
        return compartmentService.findAllByFloorId(floorId);
    }

    @GetMapping(path = "/{id}")
    public CompartmentDto findBy(@PathVariable Integer id) {
        return compartmentService.findById(id);
    }
}
