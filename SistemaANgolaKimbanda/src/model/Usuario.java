/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 *
 * @author wanzambi
 */
@SuppressWarnings("serial")
@Entity
public class Usuario extends GenericDomin {

    @Column(length = 30, nullable = false)
    private String nomeUsuario;
    @Column(length = 30, nullable = false)
    private String senha;

    public Usuario() {

    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }


    public Usuario(String nomeUsuario, String senha) {
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
    }

}