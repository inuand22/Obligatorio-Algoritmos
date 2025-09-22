/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tads;

import java.util.Set;

/**
 *
 * @author USUARIO
 */
public class Lista<T> implements ILista {

    private Nodo inicio;
    private int cantidadElementos;

    public Lista() {
        inicio = null;
        cantidadElementos = 0;
    }

    @Override
    public boolean esVacia() {
        return inicio == null;
    }

    @Override
    public void agregarInicio(Object n) {
        Nodo nodo = new Nodo();
        nodo.setDato(n);
        nodo.setSiguiente(inicio);
        inicio = nodo;
        cantidadElementos++;
    }

    @Override
    public void vaciar() {
        inicio = null;
    }

    @Override
    public boolean existeElemento(Object elemento) {
        boolean existe = false;
        Nodo aux = inicio;
        while ((aux != null) && (!existe)) {
            if (aux.getDato().equals(elemento)) {
                existe = true;
            } else {
                aux = aux.getSiguiente();
            }
        }
        return existe;
    }

    @Override
    public void agregarFinal(Object n) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void borrarInicio() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void borrarFin() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mostrar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
