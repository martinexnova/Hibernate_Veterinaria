/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Utilitarios.HibernateUtil;
import entidades.Cliente;
import entidades.Mascota;
import interfaces.ICliente;
import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author MARTIN
 */
public class ClienteDao implements ICliente{

    @Override
    public boolean guardarCliente(Cliente cliente) {
             boolean respuesta=true;
      Session session =HibernateUtil.geSessionFactory().openSession();
     Transaction transaction=session.beginTransaction();
        try {
            session.save(cliente);
             transaction.commit();
        } catch (Exception e) {
            respuesta=false;
        }
    
        session.close();
        return respuesta;
    }

    @Override
    public ArrayList<Cliente> listarCliente() {
              Session session =HibernateUtil.geSessionFactory().openSession();
          ArrayList<Cliente> milista=new ArrayList<>();
        Query query=session.createQuery("FROM Cliente");
        //ejecutar la consulta y obtener la listaz
        milista=(ArrayList<Cliente>) query.list();
        return milista;
    }

    @Override
    public boolean actualizarCliente(Cliente cliente) {
        Session session =HibernateUtil.geSessionFactory().openSession();
        
            boolean respuesta= true;
        
        
        Transaction transaccion = session.beginTransaction();
        try{
        session.update(cliente);
        transaccion.commit();
        } catch (Exception e) {
            respuesta = false;
        }
        session.close();
        return respuesta;
    }

    @Override
    public boolean eliminarCliente(Cliente cliente) {
           boolean respuesta = true;
         Session session =HibernateUtil.geSessionFactory().openSession();
        Transaction transaccion = session.beginTransaction();
        try {
            session.delete(cliente);
            transaccion.commit();
        } catch (Exception e) {
            respuesta = false;
            System.out.println("error"+e);
        }
        session.close();
        return respuesta;

    }
    
    
}
