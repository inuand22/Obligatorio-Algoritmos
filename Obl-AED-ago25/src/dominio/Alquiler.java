/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author USUARIO
 */
public class Alquiler implements IValidable {

    private String cedula;
    private String nombreEstacion;

    public Alquiler(String Cedula, String NombreEstacion) {
        cedula = Cedula;
        nombreEstacion = NombreEstacion;
        Validar();
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    @Override
    public String toString() {
        return "Alquiler{" + "cedula=" + cedula + '}';
    }

    @Override
    public void Validar() {
        if (cedula == null || cedula.trim().isEmpty()) {
            throw new IllegalArgumentException("La cédula no puede ser nula o vacía.");
        }
        if (nombreEstacion == null || nombreEstacion.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre de la estación no puede ser nulo o vacío.");
        }
        /*
        // Verificar existencia de usuario y estación en el sistema
        // (acá dependerá de cómo hayas implementado el acceso al Sistema)
        if (!Sistema.getInstancia().existeUsuario(cedula)) {
            throw new IllegalArgumentException("El usuario con cédula " + cedula + " no existe.");
        }
        if (!Sistema.getInstancia().existeEstacion(nombreEstacion)) {
            throw new IllegalArgumentException("La estación " + nombreEstacion + " no existe.");
        }
         */
    }

}
