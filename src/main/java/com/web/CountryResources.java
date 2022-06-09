package com.web;

import com.entities.dtos.CategoryDto;
import com.entities.dtos.CountryDto;
import com.entities.dtos.ResponseDto;
import com.entities.models.CountryModel;
import com.service.ICountryService;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("countries")
public class CountryResources {


        private final ICountryService countryService;

    public CountryResources(ICountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public ResponseDto getAll(Pageable page){
        return ResponseDto.of(this.countryService.findAll(page).map(c-> CountryDto.toDto(c, false)), "Get all countries");
    }

    @GetMapping("{id}")
    public ResponseDto getCountry(@PathVariable long id){
        return ResponseDto.of(CountryDto.toDto(this.countryService.findById(id), false), "Get country id: " + id);
    }
    @PostMapping
    private ResponseDto createCountry(@RequestBody CountryModel model){
        model.setCountryId(null);
        return ResponseDto.of(CountryDto.toDto(this.countryService.add(model), false), "Add country");
    }

    @PutMapping("{id}")
    public ResponseDto updateCountry(@PathVariable long id, @RequestBody CountryModel model){
        model.setCountryId(id);
        return ResponseDto.of(CountryDto.toDto(this.countryService.update(model), false), "Update country id: " + id);
    }

    @DeleteMapping("{id}")
    public ResponseDto deleteCountry(@PathVariable long id){
        return ResponseDto.of(this.countryService.deleteById(id), "Delete country id: " + id);
    }

    @DeleteMapping("buck/{ids}")
    public ResponseDto deleteCountries(@PathVariable List<Long> ids){
        return ResponseDto.of(this.countryService.deleteByIds(ids), "Delete countries ids: " + ids);
    }
}
