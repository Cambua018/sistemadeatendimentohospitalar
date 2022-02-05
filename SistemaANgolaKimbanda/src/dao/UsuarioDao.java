/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Usuario;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

/**
 *
 * @author wanzambi
 */
public class UsuarioDao extends GenericDAO<Usuario>{
    
 @SuppressWarnings("unchecked")
    public Usuario buscaPorUsuários(String nomeUsuario, String senha) {
        Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
        try {
            Criteria consulta = sessao.createCriteria(Usuario.class);
            consulta.add(Restrictions.eq("nomeUsuario", nomeUsuario));
            consulta.add(Restrictions.eq("senha", senha));
            Usuario resultado = (Usuario) consulta.uniqueResult();
            return resultado;
        } catch (RuntimeException erro) {
            throw erro;
        } finally {
            sessao.close();
        }
    }
}

