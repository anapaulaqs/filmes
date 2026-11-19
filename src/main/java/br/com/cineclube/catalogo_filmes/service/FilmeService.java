package br.com.cineclube.catalogo_filmes.service;



import br.com.cineclube.catalogo_filmes.model.Filme;
import br.com.cineclube.catalogo_filmes.record.FilmeRecord;
import br.com.cineclube.catalogo_filmes.repository.FilmeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class FilmeService {

    private final FilmeRepository repository;


    public Filme cadastrar(FilmeRecord record) {

        Filme filme = Filme.builder()
                .titulo(record.titulo())
                .diretor(record.diretor())
                .genero(record.genero())
                .duracao(record.duracao())
                .build();

        return repository.save(filme);
    }

    public List<Filme> listarTodos() {
        return repository.findAll();
    }
    public Filme buscarPorId(Integer id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new NoSuchElementException("Filme não encontrado com id: " + id));
    }
    public Filme atualizar(Integer id, FilmeRecord record) {

        Filme filme = repository.findById(id)
                .orElseThrow(() ->
                        new NoSuchElementException("Filme não encontrado com id: " + id));

        filme.setTitulo(record.titulo());
        filme.setDiretor(record.diretor());
        filme.setGenero(record.genero());
        filme.setDuracao(record.duracao());

        return repository.save(filme);
    }
    public void deletar(Integer id) {

        if (!repository.existsById(id)) {
            throw new NoSuchElementException("Filme não encontrado com id: " + id);
        }

        repository.deleteById(id);
    }
}