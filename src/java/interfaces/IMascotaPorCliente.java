/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;


import entidades.Mascotaporcliente;
import java.util.ArrayList;



/**
 *
 * @author MARTIN
 */
public interface IMascotaPorCliente{

    public abstract boolean guardarMascotaPorCliente(Mascotaporcliente mascotaporcliente);

    public abstract ArrayList<Mascotaporcliente> listarMascotaPorCliente();

    public abstract boolean actualizar(Mascotaporcliente mascotaporcliente);
    public abstract boolean eliminar(Mascotaporcliente mascotaporcliente);
}

