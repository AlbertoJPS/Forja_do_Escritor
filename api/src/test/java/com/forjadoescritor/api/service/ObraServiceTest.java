package com.forjadoescritor.api.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.UUID;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.forjadoescritor.api.model.Obra;
import com.forjadoescritor.api.repository.ObraRepository;

@ExtendWith(MockitoExtension.class)
public class ObraServiceTest {

    @Mock
    private ObraRepository obraRepositoryMock; // 1. Criamos o "dublê" do repositório

    @InjectMocks
    private ObraService obraService; // 2. Injetamos o dublê no nosso serviço real

    @Test
    @DisplayName("Deve criar obra com sucesso quando dados são válidos")
    void criar_ComObraValida_DeveRetornarObraSalva() {
        // Arrange (Preparação)
        Obra obraParaSalvar = new Obra();
        obraParaSalvar.setTitulo("Título de Teste");
        obraParaSalvar.setAutor("Autor de Teste");

        Obra obraRetornadaPeloRepo = new Obra();
        obraRetornadaPeloRepo.setId(UUID.randomUUID());
        obraRetornadaPeloRepo.setTitulo(obraParaSalvar.getTitulo());
        obraRetornadaPeloRepo.setAutor(obraParaSalvar.getAutor());

        // "Treinando" o dublê: Quando o método save for chamado com QUALQUER Obra...
        when(obraRepositoryMock.save(any(Obra.class))).thenReturn(obraRetornadaPeloRepo);

        // Act (Ação)
        Obra obraSalva = obraService.criar(obraParaSalvar);

        // Assert (Verificação)
        assertNotNull(obraSalva);
        assertNotNull(obraSalva.getId());
        assertEquals("Título de Teste", obraSalva.getTitulo());
    }
}