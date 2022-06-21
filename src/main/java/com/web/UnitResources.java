package com.web;

import com.entities.dtos.ResponseDto;
import com.entities.dtos.UnitDto;
import com.entities.models.UnitModel;
import com.service.IUnitService;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("units")
public class UnitResources {

    private final IUnitService unitService;

    public UnitResources(IUnitService unitService) {
        this.unitService = unitService;
    }

    @GetMapping
    public ResponseDto getAll(Pageable page) {
        return ResponseDto.of(this.unitService.findAll(page).map(u -> UnitDto.toDto(u)), "Get all units");
    }

    @GetMapping("{id}")
    public ResponseDto getUnit(@PathVariable long id) {
        return ResponseDto.of(UnitDto.toDto(this.unitService.findById(id)), "Get unit id: " + id);
    }

    @PostMapping
    private ResponseDto createUnit(@RequestBody UnitModel model) {
        model.setUnitId(null);
        return ResponseDto.of(UnitDto.toDto(this.unitService.add(model)), "Add unit");
    }

    @PutMapping("{id}")
    public ResponseDto updateUnit(@PathVariable long id, @RequestBody UnitModel model) {
        model.setUnitId(id);
        return ResponseDto.of(UnitDto.toDto(this.unitService.update(model)), "Update unit id: " + id);
    }

    @DeleteMapping("{id}")
    public ResponseDto deleteUnit(@PathVariable long id) {
        return ResponseDto.of(this.unitService.deleteById(id), "Delete unit id: " + id);
    }

    @DeleteMapping("buck/{ids}")
    public ResponseDto deleteUnits(@PathVariable List<Long> ids) {
        return ResponseDto.of(this.unitService.deleteByIds(ids), "Delete units ids: " + ids);
    }

    @GetMapping("get-all")
    public ResponseDto getAllUnits() {
        return ResponseDto.of(this.unitService.findAll().stream().map(UnitDto::toDto), "Get all units");
    }
}
