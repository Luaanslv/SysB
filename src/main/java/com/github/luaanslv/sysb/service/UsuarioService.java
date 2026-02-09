package com.github.luaanslv.sysb.service;

import com.github.luaanslv.sysb.model.entities.Usuario;
import com.github.luaanslv.sysb.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UsuarioService {

    private UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public void salvarDtCadastro(String email, Date dtCadastro){
        Usuario usuario = repository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Registro de cadastro não encontrado para o email: " + email));

        usuario.setDtCadastro(dtCadastro);
        repository.save(usuario);

    }

    public void salvarUltimoAcesso(String email, Date dtUltimoAcesso){
        Usuario usuario = repository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Registro de ultimo acesso não encontrado para o email: " + email));

        usuario.setDtUltimoAcesso(dtUltimoAcesso);
        repository.save(usuario);
    }


}
