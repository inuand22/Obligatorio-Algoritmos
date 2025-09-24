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
public class Bicicleta implements IValidable, Identificable {

    private String codigo;
    private Tipo tipo;
    private boolean enMantenimiento;
    private boolean estaAlquilada;

    @Override
    public String getPK() {
        return codigo;
    }

    public enum Tipo {
        URBANA,
        MOUNTAIN,
        ELECTRICA
    }

    public Bicicleta(String codigo, Tipo tipo) {
        this.codigo = codigo;
        this.tipo = tipo;
        enMantenimiento = false;
        estaAlquilada = false;
        Validar();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public boolean isEnMantenimiento() {
        return enMantenimiento;
    }

    public void setEnMantenimiento(boolean enMantenimiento) {
        this.enMantenimiento = enMantenimiento;
    }

    public boolean isEstaAlquilada() {
        return estaAlquilada;
    }

    public void setEstaAlquilada(boolean estaAlquilada) {
        this.estaAlquilada = estaAlquilada;
    }

    @Override
    public String toString() {
        return "Bicicleta{" + "codigo=" + codigo + ", tipo=" + tipo + '}';
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
        final Bicicleta other = (Bicicleta) obj;
        return Objects.equals(this.codigo, other.codigo);
    }

    @Override
    public void Validar() {
        if (codigo == null || codigo.trim().isEmpty()) {
            throw new IllegalArgumentException("El código no puede ser nulo ni vacío");
        }
        if (codigo.length() != 6) {
            throw new IllegalArgumentException("El código debe tener exactamente 6 caracteres");
        }
        if (tipo == null) {
            throw new IllegalArgumentException("El tipo de bicicleta no puede ser nulo");
        }
    }

}
