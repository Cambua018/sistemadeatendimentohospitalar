/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author wanzambi
 */
@SuppressWarnings("serial")
@Entity
public class Medico extends GenericDomin {

    @Column(length = 30, nullable = false)
    private String nome;

    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private Especialidade especialidade;

    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private Triagem triagem;

    public Medico() {
    }

    public Medico(Long codigo, String nome, Especialidade especialidade, Triagem triagem) {
        super(codigo);
        this.nome = nome;
        this.especialidade = especialidade;
        this.triagem = triagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    public Triagem getTriagem() {
        return triagem;
    }

    public void setTriagem(Triagem triagem) {
        this.triagem = triagem;
    }

    @Override
    public String toString() {
        return getNome();
    }

}
