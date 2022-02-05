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
public class Triagem extends GenericDomin {

    @Column(nullable = false, precision = 7, scale = 2)
    private Double peso;

    @Column(nullable = false, precision = 7, scale = 2)
    private Double temperatura;

    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private Paciente paciente;

    public Triagem() {
    }

    public Triagem(Long codigo, Double peso, Double temperatura, Paciente paciente) {
        super(codigo);
        this.peso = peso;
        this.temperatura = temperatura;
        this.paciente = paciente;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Double temperatura) {
        this.temperatura = temperatura;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

//    @Override
//    public String toString() {
//        return getPeso();
//    }

}
