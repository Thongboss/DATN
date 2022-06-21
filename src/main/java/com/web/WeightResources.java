package com.web;

import com.entities.dtos.ResponseDto;
import com.entities.dtos.WeightDto;
import com.entities.models.WeightModel;
import com.service.IWeightService;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("weights")
public class WeightResources {
    private final IWeightService weightService;

    public WeightResources(IWeightService weightService) {
        this.weightService = weightService;
    }


    @GetMapping
    public ResponseDto getAll(Pageable page) {
        return ResponseDto.of(this.weightService.findAll(page).map(w -> WeightDto.toDto(w)), "Get all weights");
    }

    @GetMapping("{id}")
    public ResponseDto getWeight(@PathVariable long id) {
        return ResponseDto.of(WeightDto.toDto(this.weightService.findById(id)), "Get weight id: " + id);
    }

    @PostMapping
    private ResponseDto createWeight(@RequestBody WeightModel model) {
        model.setWeightId(null);
        return ResponseDto.of(WeightDto.toDto(this.weightService.add(model)), "Add weight");
    }

    @PutMapping("{id}")
    public ResponseDto updateWeight(@PathVariable long id, @RequestBody WeightModel model) {
        model.setWeightId(id);
        return ResponseDto.of(WeightDto.toDto(this.weightService.update(model)), "Update weight id: " + id);
    }

    @DeleteMapping("{id}")
    public ResponseDto deleteWeight(@PathVariable long id) {
        return ResponseDto.of(this.weightService.deleteById(id), "Delete weight id: " + id);
    }

    @DeleteMapping("buck/{ids}")
    public ResponseDto deleteWeights(@PathVariable List<Long> ids) {
        return ResponseDto.of(this.weightService.deleteByIds(ids), "Delete weights ids: " + ids);
    }

    @GetMapping("get-all")
    public ResponseDto getAllWeights() {
        return ResponseDto.of(this.weightService.findAll().stream().map(WeightDto::toDto), "Get all weights");
    }

}
