package br.com.cineclube.catalogo_filmes.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Filme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "Titúlo", nullable = false, length = 150)
    private String titulo;
    @Column(name = "Diretor", nullable = false, length = 100)
    private String diretor;
    @Column(name = "gênero", nullable = false, length = 20)
    private String genero;
    @Column(name = "duração", nullable = false)
    private Integer duracao;

}
//Crie uma API RESTful para gerenciar o catálogo de filmes de um cineclube.
//•    Campos obrigatórios - Título, diretor, gênero e duração em minutos.
//•    Validação - A duração deve ser um número inteiro maior que zero.
//•    Rota base - /filmes