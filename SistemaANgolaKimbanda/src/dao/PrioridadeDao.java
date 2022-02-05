/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import model.Prioridade;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author wanzambi
 */
public class PrioridadeDao extends GenericDAO<Prioridade> {

    //METODO PARA CONSULTAR E PESQUISAR
    public List<Prioridade> consultar(String descricao) {
        List<Prioridade> lista = new ArrayList<>();
        Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
        sessao.beginTransaction();
        //
        if (descricao.length() == 0) {
            lista = sessao.createQuery(" from Prioridade").list();
        } else {
            lista = sessao.createQuery(" from Prioridade c where c.nome like " + "'" + descricao + "%'").list();
        }
        //sessao.getTransaction().commit();
        //sessao.close();
        return lista;
    }
//
}
