package com.github.luaanslv.syb.repository;

import com.github.luaanslv.syb.model.entitiy.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> findByEmail(String email);
    Optional<Usuario> findByCpf(String cpf);
}
