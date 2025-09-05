package com.forjadoescritor.api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.forjadoescritor.api.model.Obra;
import com.forjadoescritor.api.service.ObraService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/obras")
public class ObraController {

    private final ObraService obraService;

    // Injeção de Dependência via construtor
    public ObraController(ObraService obraService) {
        this.obraService = obraService;
    }

    @GetMapping
    public List<Obra> listar() {
        return obraService.listarTodas();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Obra criar(@Valid @RequestBody Obra obra) {
        return obraService.criar(obra);
    }
}