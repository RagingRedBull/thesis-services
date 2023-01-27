package dev.prmts.ui.backend.controller;

import dev.prmts.common.model.dto.DetectorUnitLogDto;
import dev.prmts.common.service.DetectorUnitLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/detector-unit-logs")
@RequiredArgsConstructor
public class DetectorUnitLogController {
    private final DetectorUnitLogService detectorUnitLogService;

    @GetMapping
    public List<DetectorUnitLogDto> findAll() {
        return detectorUnitLogService.findAll();
    }

    @GetMapping(path = "/{detectorUnitLogId}")
    public DetectorUnitLogDto findById(@PathVariable(name = "detectorUnitLogId") Long id) {
        return detectorUnitLogService.findById(id);
    }

    @GetMapping(params = "macAddress")
    public List<DetectorUnitLogDto> findByMacAddress(@RequestParam String macAddress) {
        return detectorUnitLogService.findByMacAddress(macAddress);
    }
}
