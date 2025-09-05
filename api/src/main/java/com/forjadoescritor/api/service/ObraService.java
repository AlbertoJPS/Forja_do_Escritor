package com.forjadoescritor.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import com.forjadoescritor.api.Obra;

@Service
public class ObraService {

    // Nosso "banco de dados" em memória. Usamos ConcurrentHashMap por ser thread-safe.
    private final Map<UUID, Obra> obras = new ConcurrentHashMap<>();

    /**
     * Lista todas as obras cadastradas.
     * @return uma lista de todas as obras.
     */
    public List<Obra> listarTodas() {
        return new ArrayList<>(obras.values());
    }

    /**
     * Cria uma nova obra, gera seu ID e a salva.
     * @param obra O objeto da obra a ser criada, vindo da requisição.
     * @return A obra com seu novo ID.
     */
    public Obra criar(Obra obra) {
        // TODO: Implementar a validação das regras de negócio aqui.

        obra.setId(UUID.randomUUID());
        obras.put(obra.getId(), obra);
        return obra;
    }
}