/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.util.Objects;
import sistemaAutogestion.Retorno;

/**
 *
 * @author USUARIO
 */
public class Usuario implements Comparable<Usuario> {

    private String cedula;
    private String nombre;
    private boolean enEspera;

    public Usuario(String Cedula, String Nombre) {
        cedula = Cedula;
        nombre = Nombre;
        enEspera = false;
    }

    public Usuario() {
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isEnEspera() {
        return enEspera;
    }

    public void setEnEspera(boolean enEspera) {
        this.enEspera = enEspera;
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
        final Usuario other = (Usuario) obj;
        return Objects.equals(this.cedula, other.cedula);
    }

    @Override
    public String toString() {
        return nombre + "#" + cedula;
    }

    @Override
    public int compareTo(Usuario o) {
        return this.nombre.compareTo(o.nombre);
    }

}
