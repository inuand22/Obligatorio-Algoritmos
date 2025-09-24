/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.util.Objects;
import tads.Lista;

/**
 *
 * @author USUARIO
 */
public class Barrio {

    private String nombre;
    private Lista<Estacion> estacionesPorBarrio = new Lista<Estacion>();
    private Deposito deposito;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Lista<Estacion> getEstacionesPorBarrio() {
        return estacionesPorBarrio;
    }

    public void setEstacionesPorBarrio(Lista<Estacion> estacionesPorBarrio) {
        this.estacionesPorBarrio = estacionesPorBarrio;
    }

    public Deposito getDeposito() {
        return deposito;
    }

    public void setDeposito(Deposito deposito) {
        this.deposito = deposito;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Barrio other = (Barrio) obj;
        return Objects.equals(this.nombre, other.nombre);
    }

    @Override
    public String toString() {
        return "Barrio{" + "nombre=" + nombre + '}';
    }

}
