/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerBean;

import Dao.MascotaDao;
;
import entidades.Mascota;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


/**
 *
 * @author MARTIN
 */
@ManagedBean(name = "")
@ViewScoped
public class MascotaBean {

 
    Mascota mascota;

    /**
     * Creates a new instance of MascotaBean
     */
    public MascotaBean() {
        this.mascota=new Mascota();
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public void guardarMascota() {
   

        try {
            MascotaDao mascotadao = new MascotaDao();
            mascotadao.guardarMascota(mascota);
        } catch (Exception e) {
         
            System.out.println("ERROR"+e);
   
        }  
    }

    public boolean actualizarMascota(Mascota mascota) {
    
        boolean respuesta = true;
        try {
            MascotaDao mascotadao = new MascotaDao();
            mascotadao.actualizar(mascota);
        } catch (Exception e) {
            respuesta = false;
            System.out.println("");
        }
        return respuesta;
    }

    /*public ArrayList<Mascota> listarMascota() {
       /*  session = HibernateUtil.geSessionFactory().openSession();
        transaction = session.beginTransaction();
          ArrayList<Mascota> lista = new ArrayList<>();
      try{
      

        MascotaDao mascotaDao = new MascotaDao();
        lista = mascotaDao.listarMascota(session);
        
      } catch(Exception e){
          
            System.out.println("");
      }
     return lista;
    }
    }  */
    
}
