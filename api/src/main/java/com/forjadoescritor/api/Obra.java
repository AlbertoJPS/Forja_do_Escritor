package com.forjadoescritor.api;

import java.util.UUID;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Obra {

    private UUID id;

    @NotBlank(message = "O título não pode ser nulo ou vazio.")
    @Size(min = 3, max = 200, message = "O título deve ter entre 3 e 200 caracteres.")
    private String titulo;

    @NotBlank(message = "O autor não pode ser nulo ou vazio.")
    @Size(min = 3, max = 150, message = "O nome do autor deve ter entre 3 e 150 caracteres.")
    private String autor;

    @Size(max = 150, message = "O pseudônimo não pode exceder 150 caracteres.")
    private String pseudonimo;

    @Size(max = 1000, message = "A descrição não pode exceder 1000 caracteres.")
    private String descricao;
}