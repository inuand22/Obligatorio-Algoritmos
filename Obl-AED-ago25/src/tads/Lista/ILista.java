/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tads.Lista;

/**
 *
 * @author USUARIO
 */
public interface ILista<T> {

    public boolean esVacia();

    public void agregarInicio(T n);

    public void agregarFinal(T n);

    public void borrarInicio();

    public void borrarFin();

    public void vaciar();

    public void mostrar();

    public boolean existeElemento(T n);

    public Object obtenerElemento(T elemento);

    public int getCantidadElementos();

    public Object obtenerElementoPosicion(int pos);

    /*
    public void agregarOrd(int n);

    public void borrarElemento(int n);

    public int cantElementos();

    public NodoLista obtenerElemento(int n);

    public void mostrarREC(NodoLista l);*/
}
