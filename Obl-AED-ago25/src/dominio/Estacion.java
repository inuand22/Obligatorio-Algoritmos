/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.util.Objects;
import tads.Lista.Lista;
import tads.ListaSEO.ListaSEO;

/**
 *
 * @author USUARIO
 */
public class Estacion implements IValidable {

    private String nombre;
    private String barrio;
    private int capacidad;

    private ListaSEO<Bicicleta> bicicletasEnEstacion = new ListaSEO<Bicicleta>();
    private Lista<Usuario> usuariosEnEsperaAlquilar = new Lista<Usuario>();
    private Lista<Usuario> usuarioEnEsperaAnclar = new Lista<Usuario>();

    public Estacion(String Nombre, String Barrio, int Capacidad) {
        nombre = Nombre;
        barrio = Barrio;
        capacidad = Capacidad;
        Validar();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public ListaSEO<Bicicleta> getBicicletasEnEstacion() {
        return bicicletasEnEstacion;
    }

    public void setBicicletasEnEstacion(ListaSEO<Bicicleta> bicicletasEnEstacion) {
        this.bicicletasEnEstacion = bicicletasEnEstacion;
    }

    public Lista<Usuario> getUsuariosEnEsperaAlquilar() {
        return usuariosEnEsperaAlquilar;
    }

    public void setUsuariosEnEsperaAlquilar(Lista<Usuario> usuariosEnEsperaAlquilar) {
        this.usuariosEnEsperaAlquilar = usuariosEnEsperaAlquilar;
    }

    public Lista<Usuario> getUsuarioEnEsperaAnclar() {
        return usuarioEnEsperaAnclar;
    }

    public void setUsuarioEnEsperaAnclar(Lista<Usuario> usuarioEnEsperaAnclar) {
        this.usuarioEnEsperaAnclar = usuarioEnEsperaAnclar;
    }

    @Override
    public String toString() {
        return "Estacion{" + "nombre=" + nombre + ", barrio=" + barrio + ", capacidad=" + capacidad + '}';
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
        final Estacion other = (Estacion) obj;
        return Objects.equals(this.nombre, other.nombre);
    }

    @Override
    public void Validar() {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo ni vacío");
        }
        if (barrio == null || barrio.trim().isEmpty()) {
            throw new IllegalArgumentException("El barrio no puede ser nulo ni vacío");
        }
        if (capacidad <= 0) {
            throw new IllegalArgumentException("La capacidad debe ser mayor a cero");
        }
    }
}
