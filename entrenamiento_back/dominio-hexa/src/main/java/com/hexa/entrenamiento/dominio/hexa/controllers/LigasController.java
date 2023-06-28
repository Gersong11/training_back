package com.hexa.entrenamiento.dominio.hexa.controllers;

import java.util.ArrayList;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexa.entrenamiento.dominio.Ligas;
import com.hexa.entrenamiento.dominio.repositories.LigasRepository;
import com.hexa.entrenamiento.negocio.LigasDto;

@RestController
@RequestMapping("/api/ligas")
@RequiredArgsConstructor
public class LigasController {

    private final LigasRepository repository;
    private ModelMapper modelMapper = new ModelMapper();


    @GetMapping
    List<LigasDto> findAll() {
        LigasDto ligaDto = null;
        List<Ligas> ligas = repository.findAll();
        List<LigasDto> ligasResponse = new ArrayList<>();
        for(Ligas liga: ligas) {
            ligaDto = modelMapper.map(liga, LigasDto.class);
            ligasResponse.add(ligaDto);
        }
        return ligasResponse;
    }

    @GetMapping("/{id}")
    LigasDto findOne(@PathVariable Integer id) {
        return modelMapper.map(repository.findById(id).orElse(null), LigasDto.class);
    }

    @GetMapping("/codigo/{codigo}")
    LigasDto findByCode(@PathVariable String codigo) {
        return modelMapper.map(repository.findFirstByCodigo(codigo), LigasDto.class);
    }

    @PostMapping
    LigasDto create(@RequestBody Ligas o) {
        return modelMapper.map(repository.save(o), LigasDto.class);
    }


    @PutMapping
    LigasDto update(@RequestBody Ligas o) {
        return create(o);
    }

}
