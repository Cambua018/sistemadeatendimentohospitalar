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
public class Prioridade extends GenericDomin {

    @Column(length = 30, nullable = false)
    private String nome;

    public Prioridade() {
    }

    public Prioridade(Long codigo, String nome) {
        super(codigo);
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    
    @Override
    public String toString() {
        return getNome();
    }
}
