package com.web;

import com.entities.Warehouse;
import com.entities.dtos.ResponseDto;
import com.entities.dtos.UserDto;
import com.entities.dtos.WarehouseDTO;
import com.entities.models.WarehouseModel;
import com.service.IWarehouseService;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("warehouse")
public class WarehouseResources {

    private final IWarehouseService warehouseService;

    public WarehouseResources(IWarehouseService warehouseService) {
        this.warehouseService = warehouseService;
    }

    @GetMapping
    public ResponseDto list(Pageable page){
        return ResponseDto.of(this.warehouseService.findAll(page).map(w -> WarehouseDTO.toDto(w)),"list warehouse");
    }
    @PostMapping
    public ResponseDto addWarehouse(@RequestBody @Valid WarehouseModel model){
        model.setId(null);
        return ResponseDto.of(WarehouseDTO.toDto(this.warehouseService.add(model)), "Add new Warehouse");
    }
    @PutMapping("{id}")
    public ResponseDto updateWarehouse(@PathVariable Long id, @RequestBody @Valid WarehouseModel model){
        model.setId(id);
        return ResponseDto.of(WarehouseDTO.toDto(this.warehouseService.update(model)), "update Warehouse");
    }
    @DeleteMapping("{id}")
    public ResponseDto deleteWarehouse(@PathVariable Long id){
        return ResponseDto.of(this.warehouseService.deleteById(id)?true:null, "Delete id");
    }
    @GetMapping("{id}")
    public ResponseDto findWarehouseById(@PathVariable Long id){
        return ResponseDto.of(WarehouseDTO.toDto(this.warehouseService.findById(id)), "Find by id warehouse");
    }


}
