package com.forjadoescritor.api.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.forjadoescritor.api.model.Obra;

@SpringBootTest
@AutoConfigureMockMvc
public class ObraControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("Deve retornar status 201 Created ao criar obra válida")
    void quandoPostarObraValida_deveRetornarStatus201() throws Exception {
        // Arrange
        Obra obraValida = new Obra();
        obraValida.setTitulo("Uma Obra Com Título Válido");
        obraValida.setAutor("Um Autor Válido");

        String obraJson = objectMapper.writeValueAsString(obraValida);

        // Act & Assert
        mvc.perform(post("/obras")
                .contentType(MediaType.APPLICATION_JSON)
                .content(obraJson))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.titulo").value("Uma Obra Com Título Válido"));
    }

    @Test
    @DisplayName("Deve retornar status 400 Bad Request ao criar obra com título inválido")
    void quandoPostarObraComTituloInvalido_deveRetornarStatus400() throws Exception {
        // Arrange
        Obra obraInvalida = new Obra();
        obraInvalida.setTitulo(""); // Título inválido (em branco)
        obraInvalida.setAutor("Autor Válido");

        String obraJson = objectMapper.writeValueAsString(obraInvalida);

        // Act & Assert
        mvc.perform(post("/obras")
                .contentType(MediaType.APPLICATION_JSON)
                .content(obraJson))
                .andExpect(status().isBadRequest());
    }
}