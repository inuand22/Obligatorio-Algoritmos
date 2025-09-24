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
    private String codigo;

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

    public String getNombreEstacion() {
        return nombreEstacion;
    }

    public void setNombreEstacion(String nombreEstacion) {
        this.nombreEstacion = nombreEstacion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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
    }

}
