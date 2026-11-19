package br.com.cineclube.catalogo_filmes.controller;

import br.com.cineclube.catalogo_filmes.model.Filme;
import br.com.cineclube.catalogo_filmes.record.FilmeRecord;
import br.com.cineclube.catalogo_filmes.service.FilmeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    private final FilmeService service;

    public FilmeController(FilmeService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Filme cadastrar(@Valid @RequestBody FilmeRecord record) {
        return service.cadastrar(record);
    }

    @GetMapping
    public List<Filme> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Filme buscarPorId(@PathVariable Integer id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Filme atualizar(@PathVariable Integer id,
                           @Valid @RequestBody FilmeRecord record) {
        return service.atualizar(id, record);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Integer id) {
        service.deletar(id);
    }
}

