/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.util.Objects;

/**
 *
 * @author USUARIO
 */
public class Usuario implements IValidable {

    private String cedula;
    private String nombre;
    private boolean enEspera;

    public Usuario(String Cedula, String Nombre) {
        cedula = Cedula;
        nombre = Nombre;
        enEspera = false;
        Validar();
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
        return "Usuario{" + "cedula=" + cedula + ", nombre=" + nombre + '}';
    }

    @Override
    public void Validar() {
        //PREGUNTAR AL PROFE, PORQUE NO QUEREMOS QUE LA CEDULA LLEVE LETRAS, SI HAY QUE VERIFICARLO
        if (cedula == null || cedula.trim().isEmpty()) {
            throw new IllegalArgumentException("La cédula no puede ser nula ni vacía");
        }
        if (cedula.length() <= 8) {
            throw new IllegalArgumentException("La cédula debe tener más de 8 caracteres");
        }
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo ni vacío");
        }
    }
}
