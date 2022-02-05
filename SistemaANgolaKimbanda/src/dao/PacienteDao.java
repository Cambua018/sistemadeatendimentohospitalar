/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import model.Paciente;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author wanzambi
 */
public class PacienteDao extends GenericDAO<Paciente>{
    
        //METODO PARA CONSULTAR E PESQUISAR
    public List<Paciente> consultar(String descricao) {
        List<Paciente> lista = new ArrayList<>();
        Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
        sessao.beginTransaction();
        //
        if (descricao.length() == 0) {
            lista = sessao.createQuery(" from Paciente").list();
        } else {
            lista = sessao.createQuery(" from Paciente c where c.nome like " + "'" + descricao + "%'").list();
        }
        //sessao.getTransaction().commit();
        //sessao.close();
        return lista;
    }
//
}
