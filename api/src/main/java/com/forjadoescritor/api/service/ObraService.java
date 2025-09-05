package com.forjadoescritor.api.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.forjadoescritor.api.model.Obra;
import com.forjadoescritor.api.repository.ObraRepository;

@Service
public class ObraService {

    private final ObraRepository obraRepository;

    // Injetando o repositório em vez do mapa
    public ObraService(ObraRepository obraRepository) {
        this.obraRepository = obraRepository;
    }

    public List<Obra> listarTodas() {
        // Usando o método findAll() do repositório
        return obraRepository.findAll();
    }

    public Obra criar(Obra obra) {
        // Usando o método save() do repositório.
        // Não precisamos mais gerar o ID, o banco de dados faz isso agora.
        return obraRepository.save(obra);
    }
}