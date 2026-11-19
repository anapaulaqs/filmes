package br.com.cineclube.catalogo_filmes.record;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record FilmeRecord(
        @NotBlank(message = "O título é obrigatório")
        String titulo,
        @NotBlank(message = "Diretor é obrigatorio")
        String diretor,
        @NotBlank(message = "Gênero Obrigatório")
        String genero,
        @NotBlank(message = "Duração")
        @Min(value = 1, message = "A duração maior que Zero")
        Integer duracao

) {}
