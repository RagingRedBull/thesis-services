package dev.prmts.ui.backend.controller;

import dev.prmts.common.model.dto.FloorDto;
import dev.prmts.common.service.FloorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/floors")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class FloorController {
    private final FloorService floorService;

    @GetMapping
    public List<FloorDto> findAll() {
        return floorService.findAll();
    }

    @GetMapping(path = "/{id}")
    public FloorDto findById(@PathVariable Integer id) {
        return floorService.findById(id);
    }

    @PostMapping
    public FloorDto save(@RequestBody FloorDto dto) {
        return floorService.save(dto);
    }

    @PutMapping
    public FloorDto update(@RequestBody FloorDto dto) {
        return floorService.update(dto);
    }
}
