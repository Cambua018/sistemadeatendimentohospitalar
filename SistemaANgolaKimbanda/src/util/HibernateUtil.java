/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.SQLException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.jdbc.ReturningWork;
import org.hibernate.service.ServiceRegistry;
/**
 *
 * @author wanzambi
 */
public class HibernateUtil {
   private static final SessionFactory fabricaDeSessoes = criarFabricaDeSessoes();

    public static SessionFactory getFabricaDeSessoes() {
        return fabricaDeSessoes;
    }

    public static Connection getConexao() {
        Session sessao = fabricaDeSessoes.openSession();
        Connection conexao = sessao.doReturningWork(new ReturningWork<Connection>() {
            @Override
            public Connection execute(Connection conn) throws SQLException {
                return conn;
            }
        });
        return conexao;
    }

    private static SessionFactory criarFabricaDeSessoes() {
        try {
            Configuration configuracao = new Configuration().configure();
            ServiceRegistry registro = new StandardServiceRegistryBuilder().applySettings(configuracao.getProperties()).build();
            SessionFactory fabrica = configuracao.buildSessionFactory(registro);
            System.out.println("Base de dados conectado");
            return fabrica;
        } catch (Throwable ex) {
            System.err.println("A fábrica de conexão não pode ser criada." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

}
