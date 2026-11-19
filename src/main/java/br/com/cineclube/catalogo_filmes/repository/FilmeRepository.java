package br.com.cineclube.catalogo_filmes.repository;

import br.com.cineclube.catalogo_filmes.model.Filme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Integer> {
    @Override
    Optional<Filme> findById(Integer integer);
    boolean existsById(Integer integer);
}
