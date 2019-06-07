/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilitarios;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author MARTIN
 */
public class HibernateUtil {
 private static final SessionFactory sessionFactory;
    static {
        try {
            //
            //
         sessionFactory =new AnnotationConfiguration().configure().buildSessionFactory();
         
        } catch (Exception e) {
               System.err.println("Initial sessionFactory creation faild." +e);
               throw new ExceptionInInitializerError(e);
               
        }
    }
    public static  SessionFactory geSessionFactory(){
        return  sessionFactory;
    }

    public static Object getSessionFactory() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
