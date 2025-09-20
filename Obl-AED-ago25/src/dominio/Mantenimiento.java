/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author USUARIO
 */
public class Mantenimiento implements IValidable {

    private String codigo;
    private String motivo;

    public Mantenimiento(String codigo, String motivo) {
        this.codigo = codigo;
        this.motivo = motivo;
        Validar();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    @Override
    public String toString() {
        return "Mantenimiento{" + "codigo=" + codigo + ", motivo=" + motivo + '}';
    }

    @Override
    public void Validar() {
        if (codigo == null || codigo.trim().isEmpty()) {
            throw new IllegalArgumentException("El código de bicicleta no puede ser nulo ni vacío");
        }
        if (motivo == null || motivo.trim().isEmpty()) {
            throw new IllegalArgumentException("El motivo no puede ser nulo ni vacío");
        }
    }
}
