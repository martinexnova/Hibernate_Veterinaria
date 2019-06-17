/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerBean;

import Dao.MascotaDao;
;
import entidades.Mascota;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author MARTIN
 */


@ManagedBean(name = "MascotaBean")
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

    public String guardarMascota() {

     try {

            MascotaDao mascotaDao = new MascotaDao();
            boolean respuesta= mascotaDao.guardarMascota(mascota);
            if(respuesta){
                FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("correcto", "regidtro exitoso"));
            }else{
                FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("error", "no se puedo registrar"));
            }
        } catch (HibernateException e) {
            ///transation.rollback();  -- regresa a la anterior
            System.out.println("Error::: " + e);
        }
        return "/index";
    }

    public String actualizarMascota() {

    
        try {
            MascotaDao mascotadao = new MascotaDao();
            boolean respuesta = mascotadao.actualizar(mascota);
            if(respuesta){
                FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("correcto", "regidtro exitoso"));
            }else{
                FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("error", "no se puedo registrar"));
            }
        } catch (Exception e) {
            
            System.out.println("");
        }
        return "/index";
    }

    public ArrayList<Mascota> listar() {

        ArrayList<Mascota> lista = new ArrayList<>();

        MascotaDao mascotadao = new MascotaDao();
        lista = mascotadao.listarMascota();

        return lista;

    }
    public  String limpiar(){
        return "/index";
    }
    public String eliminarMascota(){
         MascotaDao dao = new MascotaDao();
            boolean respuesta= dao.eliminar(mascota);
            if(respuesta){
                
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Correcto","Registro Borrado con exito"));
            }else{
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error","No se pudo eliminar"));
            }
            return "/index.xhtml";
        
    }

}
