/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDate;
import java.time.LocalTime;
import javax.persistence.Column;
import javax.persistence.Entity;

/**
 *
 * @author wanzambi
 */
@SuppressWarnings("serial")
@Entity
public class Paciente extends GenericDomin {

    @Column(length = 30, nullable = false)
    private String nome;

    private LocalDate dateNascimento;

    @Column(length = 30, nullable = false)
    private String estadoCivil;

    @Column(length = 30, nullable = false)
    private String sexo;

    @Column(length = 30, nullable = false)
    private String endereco;

    @Column(length = 30, nullable = false)
    private String telefone;

    public Paciente() {
    }

    public Paciente(Long codigo, String nome, LocalDate dateNascimento, String estadoCivil, String sexo, String endereco, String telefone) {
        super(codigo);
        this.nome = nome;
        this.dateNascimento = dateNascimento;
        this.estadoCivil = estadoCivil;
        this.sexo = sexo;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDateNascimento() {
        return dateNascimento;
    }

    public void setDateNascimento(LocalDate dateNascimento) {
        this.dateNascimento = dateNascimento;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return getNome();
    }

}
