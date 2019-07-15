/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import Dao.PerfilDao;
import Dao.PersonalDao;
import Dao.UsuarioDao;
import entidades.Perfil;
import entidades.Personal;
import entidades.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.hibernate.HibernateException;

/**
 *
 * @author Computer
 */
@ManagedBean
//@RequestScoped
@ViewScoped
public class UsuarioBean implements Serializable {

    /**
     * SE COMUNICA CON EL DAO
     */

    private Usuario usuario;
    private Perfil perfil;
    private Personal personal;
      private ArrayList listarPerfil;
      private ArrayList listarPersonal;
 
    private int idPersonal;
    private int IdPerfil;
  
    private boolean  banderSelect=false;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public  UsuarioBean(){
        perfil=new Perfil();
        personal=new Personal();
        this.usuario = new Usuario();
       listarPersonal =new ArrayList();
         listarPerfil = new ArrayList();
         listarCombos();
    }
        public void listarCombos() {
        PersonalDao personalDao=new PersonalDao();
        PerfilDao perfilDao = new PerfilDao();
        listarPerfil = perfilDao.listarPerfil();
        listarPersonal=personalDao.listarPersonal();
 

    }


    public String guardarUsuario() {
        try {

            UsuarioDao usuarioDao = new UsuarioDao();
            perfil.setIdPerfil(IdPerfil);
            personal.setIdPersonal(idPersonal);
            usuario.setPerfil(perfil);
            usuario.setPersonal(personal);
            boolean respuesta = usuarioDao.guardarUsuario(usuario);
            if (respuesta) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se regidtro correctamente"));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se puedo registrar"));
            }
        } catch (HibernateException e) {
            ///transation.rollback();  -- regresa a la anterior
            System.out.println("Errorrrrrwewewe::: " + e);
        }
        return "/RegistrarUsuario";
    }

    public String actualizarUsuario() {
        try {
            UsuarioDao usuarioDao = new UsuarioDao();
            boolean respuesta = usuarioDao.actualizarUsuario(usuario);
            if (respuesta){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se actualizo correctamente"));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se puedo actualizar"));
            }
        } catch (HibernateException e) {
            ///transation.rollback();  -- regresa a la anterior
            System.out.println("Error::: " + e);
        }
        return "/RegistrarUsuario";

    }

    public ArrayList<Usuario> listarUsuarios() {
        ArrayList<Usuario> lista = new ArrayList<>();
        UsuarioDao usuarioDao = new UsuarioDao();
        lista = usuarioDao.listarUsuario();
        return lista;
    }

    public String eliminar() {
        UsuarioDao usuarioDao = new UsuarioDao();
        
        boolean respuesta = usuarioDao.eliminarUsuario(usuario);
        if (respuesta) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se elimino correctamente"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se puedo eliminar"));
        }
        return "/RegistrarUsuario";
    }

    public String limpiar() {
        return "/RegistrarUsuario";
    }
    public  void selectBandera(){
        banderSelect=true;
    }

    public boolean isBanderSelect() {
        return banderSelect;
    }

    public void setBanderSelect(boolean banderSelect) {
        this.banderSelect = banderSelect;
    }



    public ArrayList getListarPerfil() {
        return listarPerfil;
    }

    public void setListarPerfil(ArrayList listarPerfil) {
        this.listarPerfil = listarPerfil;
    }

  

    public int getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(int idPersonal) {
        this.idPersonal = idPersonal;
    }

    public ArrayList getListarPersonal() {
        return listarPersonal;
    }

    public void setListarPersonal(ArrayList listarPersonal) {
        this.listarPersonal = listarPersonal;
    }

    public int getIdPerfil() {
        return IdPerfil;
    }

    public void setIdPerfil(int IdPerfil) {
        this.IdPerfil = IdPerfil;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }



}
