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
public class Recepcao extends GenericDomin {

    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private Paciente paciente;

    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private Prioridade prioridade;

    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private Servico servico;

    @Column(nullable = false)
    private Boolean foiAtendido;

    public Recepcao() {
    }

    public Recepcao(Long codigo, Paciente paciente, Prioridade prioridade, Servico servico, Boolean foiAtendido) {
        super(codigo);
        this.paciente = paciente;
        this.prioridade = prioridade;
        this.servico = servico;
        this.foiAtendido = foiAtendido;
    }

//        @Override
//    public String toString() {
//        return getNome();
//    }
    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public Boolean getFoiAtendido() {
        return foiAtendido;
    }

    public void setFoiAtendido(Boolean foiAtendido) {
        this.foiAtendido = foiAtendido;
    }
}
