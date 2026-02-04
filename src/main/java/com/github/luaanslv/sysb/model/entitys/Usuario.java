package com.github.luaanslv.sysb.model.entitys;


import jakarta.persistence.*;
/* NotBlank para textos e NotNull para numeros */
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "TB_USUARIOS")
@Entity

public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUsuario")
    private Integer idUsuario;

    @ManyToOne
    @JoinColumn(name = "idPermissao", referencedColumnName = "idPermissao")
    @NotNull(message = "A permissão é obrigatoria")
    private Permissao permissao;

    @NotBlank(message = "Nome é obrigatorio")
    @Column(name = "nome", nullable = false)
    private String nome;

    @NotBlank(message = "Cpf é obrigatorio")
    @Column(name = "cpf", nullable = false)
    private String cpf;

    @NotBlank(message = "Email é obrigatorio")
    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "dtCadastro", nullable = false)
    private Date dtCadastro;

    @Column(name = "dtUltimoAcesso", nullable = false)
    private Date dtUltimoAcesso;

    @NotBlank(message = "A senha é obrigatoria")
    @Column(name = "senha", nullable = false)
    private String senha;

    @Column(name = "ativa", nullable = false)
    private Boolean ativa;

    @Column(name = "tentativasLogin", nullable = false)
    private Integer tentativasLogin;

    @Column(name = "bloqueadoAte")
    @ColumnDefault("3")
    private Integer bloqueadoAte;
}
