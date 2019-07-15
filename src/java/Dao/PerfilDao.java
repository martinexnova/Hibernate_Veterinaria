/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Utilitarios.HibernateUtil;
import entidades.Perfil;

import interfaces.IPerfil;
import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author MARTIN
 */
public class PerfilDao implements IPerfil{

    @Override
    public boolean guardarPerfil(Perfil perfil) {
             boolean respuesta=true;
      Session session =HibernateUtil.getSessionFactory().openSession();
     Transaction transaction=session.beginTransaction();
        try {
            session.save(perfil);
             transaction.commit();
        } catch (Exception e) {
            respuesta=false;
            System.out.println("erroradasdsadasfdsgdsgssdssddd"+e);
        }
    
        session.close();
        return respuesta;
    }

    @Override
    public ArrayList<Perfil> listarPerfil() {
              Session session =HibernateUtil.getSessionFactory().openSession();
          ArrayList<Perfil> milista=new ArrayList<>();
        Query query=session.createQuery("FROM Perfil");
        //ejecutar la consulta y obtener la listaz
        milista=(ArrayList<Perfil>) query.list();
         session.close();
        return milista;
    }

    @Override
    public boolean actualizarPerfil(Perfil perfil) {
        Session session =HibernateUtil.getSessionFactory().openSession();
        
            boolean respuesta= true;
        
        
        Transaction transaccion = session.beginTransaction();
        try{
        session.update(perfil);
        transaccion.commit();
        } catch (Exception e) {
            System.out.println(" error"+e);
            respuesta = false;
        }
        session.close();
        return respuesta;
    }

    @Override
    public boolean eliminarPerfil(Perfil perfil) {
           boolean respuesta = true;
         Session session =HibernateUtil.getSessionFactory().openSession();
        Transaction transaccion = session.beginTransaction();
        try {
            session.delete(perfil);
            transaccion.commit();
        } catch (Exception e) {
            respuesta = false;
            System.out.println("error"+e);
        }
        session.close();
        return respuesta;

    }
    
    
}
