/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tads.ListaSEO;

import tads.Lista.*;
import java.util.Set;

/**
 *
 * @author USUARIO
 */
public class ListaSEO<T extends Comparable> implements IListaSEO {

    private Nodo inicio;
    private int cantidadElementos;

    public ListaSEO() {
        inicio = null;
        cantidadElementos = 0;
    }

    @Override
    public boolean esVacia() {
        return inicio == null;
    }

    @Override
    public void vaciar() {
        inicio = null;
    }

    @Override
    public void agregarInicio(Comparable n) {
        Nodo nodo = new Nodo();
        nodo.setDato(n);
        nodo.setSiguiente(inicio);
        inicio = nodo;
        cantidadElementos++;
    }

    @Override
    public void agregarFinal(Comparable n) {
        Nodo nuevo = new Nodo();
        nuevo.setDato(n);
        nuevo.setSiguiente(null);

        if (inicio == null) {
            inicio = nuevo;
        } else {
            Nodo aux = inicio;
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nuevo);
        }
        cantidadElementos++;
    }

    @Override
    public void borrarInicio() {
        if (inicio == null) {
            return;
        }
        inicio = inicio.getSiguiente();
        cantidadElementos--;
    }

    @Override
    public void borrarFin() {
        if (inicio == null) {
            return;
        }
        if (inicio.getSiguiente() == null) {
            inicio = null;
        } else {
            Nodo aux = inicio;
            while (aux.getSiguiente().getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(null);
        }
        cantidadElementos--;
    }

    @Override
    public void mostrar() {
        Nodo aux = inicio;
        String texto = "";
        while (aux != null) {
            texto += (aux.getDato().toString()) + " ";
            aux = aux.getSiguiente();
        }
        System.out.println(texto);

    }

    @Override
    public int getCantidadElementos() {
        return cantidadElementos;
    }

    @Override
    public Object obtenerElementoPosicion(int pos) {
        if (pos < 1 || pos > cantidadElementos) {
            return null;
        }

        int contador = 1;
        Nodo aux = inicio;

        while (aux != null) {
            if (contador == pos) {
                return aux.getDato();
            }
            aux = aux.getSiguiente();
            contador++;
        }

        return null;
    }

    @Override
    public void agregarOrdenado(Comparable n) {

        if (esVacia()) {
            agregarInicio(n);
            return;
        }

        Nodo aux = inicio;
        while (aux != null) {
            if (aux.getDato().equals(n)) {
                return;
            }
            aux = aux.getSiguiente();
        }

        if (((Comparable) inicio.getDato()).compareTo(n) >= 0) {
            agregarInicio(n);
            return;
        }

        Nodo actual = inicio;
        while (actual.getSiguiente() != null
                && ((Comparable) actual.getSiguiente().getDato()).compareTo(n) < 0) {
            actual = actual.getSiguiente();
        }
        if (actual.getSiguiente() == null) {
            agregarFinal(n);
            return;
        }
        Nodo nuevo = new Nodo();
        nuevo.setDato(n);
        nuevo.setSiguiente(actual.getSiguiente());
        actual.setSiguiente(nuevo);
        cantidadElementos++;
    }

    @Override
    public boolean existeElemento(Comparable n) {
        boolean existe = false;
        Nodo aux = inicio;
        while ((aux != null) && (!existe)) {
            if (aux.getDato().equals(n)) {
                existe = true;
            } else {
                aux = aux.getSiguiente();
            }
        }
        return existe;
    }

    @Override
    public Object obtenerElemento(Comparable elemento) {
        Nodo aux = inicio;
        boolean esta = false;
        T retorno = null;

        while ((aux != null) && (!esta)) {
            if (aux.getDato().equals(elemento)) {
                esta = true;
                retorno = (T) aux.getDato();
            } else {
                aux = aux.getSiguiente();
            }
        }
        return retorno;
    }

}
