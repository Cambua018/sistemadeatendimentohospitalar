/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import model.Especialidade;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author wanzambi
 */
public class EspecialidadeDao extends GenericDAO<Especialidade>{
      //METODO PARA CONSULTAR E PESQUISAR
    public List<Especialidade> consultar(String descricao) {
        List<Especialidade> lista = new ArrayList<>();
        Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
        sessao.beginTransaction();
        //
        if (descricao.length() == 0) {
            lista = sessao.createQuery(" from Especialidade").list();
        } else {
            lista = sessao.createQuery(" from Especialidade c where c.nome like " + "'" + descricao + "%'").list();
        }
        //sessao.getTransaction().commit();
        //sessao.close();
        return lista;
    }
//
}
