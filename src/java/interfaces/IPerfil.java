/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entidades.Perfil;
import java.util.ArrayList;
/**
 *
 * @author MARTIN
 */
public interface IPerfil {
    public abstract boolean guardarPerfil(Perfil perfil);

    public abstract ArrayList<Perfil> listarPerfil();

    public abstract boolean actualizarPerfil(Perfil perfil);

    public abstract boolean eliminarPerfil(Perfil perfil);
}
