/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import tads.Lista;

/**
 *
 * @author USUARIO
 */
public class AlquilerUsuarioBicicleta {

    private Lista<Alquiler> listaAlquiler = new Lista<Alquiler>();

    public Lista<Alquiler> getListaAlquiler() {
        return listaAlquiler;
    }

    public void setListaAlquiler(Lista<Alquiler> listaAlquiler) {
        this.listaAlquiler = listaAlquiler;
    }

}
