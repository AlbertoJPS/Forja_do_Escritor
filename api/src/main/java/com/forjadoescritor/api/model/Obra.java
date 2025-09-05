package com.forjadoescritor.api.model;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "obras")
@Data
public class Obra {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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