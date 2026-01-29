package com.github.luaanslv.sysb.model;

import java.time.LocalDateTime;

public class Usuario {
    private Integer idUsuario;
    private Integer idPermissao;
    private String nome;
    private String cpf;
    private String email;
    private LocalDateTime dtCadastro;
    private LocalDateTime dtUltimoAcesso;
    private String senha;
    private boolean ativa;
    private Integer tentativasLogin ;
    private Integer bloqueadoAte;

    public Usuario(Integer idPermissao, String nome, String cpf, String email, String senha, boolean ativa) {
        this.idPermissao = idPermissao;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
        this.ativa = true;
    }
    
    

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public Integer getIdPermissao() {
        return idPermissao;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public LocalDateTime getDtCadastro() {
        return dtCadastro;
    }

    public LocalDateTime getDtUltimoAcesso() {
        return dtUltimoAcesso;
    }

    public String getSenha() {
        return senha;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public Integer getTentativasLogin() {
        return tentativasLogin;
    }

    public Integer getBloqueadoAte() {
        return bloqueadoAte;
    }

    public void setIdPermissao(Integer idPermissao) {
        this.idPermissao = idPermissao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    public void setTentativasLogin(Integer tentativasLogin) {
        this.tentativasLogin = tentativasLogin;
    }

    public void setBloqueadoAte(Integer bloqueadoAte) {
        this.bloqueadoAte = bloqueadoAte;
    }
    
    
}