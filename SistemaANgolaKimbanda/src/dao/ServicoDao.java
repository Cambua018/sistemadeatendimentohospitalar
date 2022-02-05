/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import model.Servico;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author wanzambi
 */
public class ServicoDao extends GenericDAO<Servico> {

    //METODO PARA CONSULTAR E PESQUISAR
    public List<Servico> consultar(String descricao) {
        List<Servico> lista = new ArrayList<>();
        Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
        sessao.beginTransaction();
        //
        if (descricao.length() == 0) {
            lista = sessao.createQuery(" from Servico").list();
        } else {
            lista = sessao.createQuery(" from Servico c where c.nome like " + "'" + descricao + "%'").list();
        }
        //sessao.getTransaction().commit();
        //sessao.close();
        return lista;
    }
//
}
