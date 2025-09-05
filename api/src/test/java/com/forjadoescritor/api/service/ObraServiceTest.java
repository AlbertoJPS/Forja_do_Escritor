package com.forjadoescritor.api.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.forjadoescritor.api.Obra;

public class ObraServiceTest {

    @Test
    @DisplayName("Deve criar obra com sucesso quando dados são válidos")
    void criar_ComObraValida_DeveRetornarObraComId() {
        // Arrange (Preparação)
        ObraService obraService = new ObraService();
        Obra obraParaSalvar = new Obra();
        obraParaSalvar.setTitulo("Título de Teste");
        obraParaSalvar.setAutor("Autor de Teste");

        // Act (Ação)
        Obra obraSalva = obraService.criar(obraParaSalvar);

        // Assert (Verificação)
        assertNotNull(obraSalva);
        assertNotNull(obraSalva.getId(), "O ID não deveria ser nulo após a criação");
        assertEquals("Título de Teste", obraSalva.getTitulo(), "O título deveria ser o mesmo que foi enviado");
    }
}