package com.forjadoescritor.api;

import java.util.UUID;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Obra {

    private UUID id;
    private String titulo;
    private String autor;
    private String pseudonimo;
    private String descricao;
}