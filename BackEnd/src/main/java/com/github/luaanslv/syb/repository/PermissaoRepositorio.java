package com.github.luaanslv.syb.repository;

import com.github.luaanslv.syb.model.entitiy.Permissao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PermissaoRepositorio extends JpaRepository<Permissao, Integer> {
    Optional<Permissao> findByNomePerfil(String nomePerfil);
}
