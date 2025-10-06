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
public class Bicicleta implements Comparable<Bicicleta> {

    private String codigo;
    private Tipo tipo;
    private boolean enMantenimiento;
    private boolean estaAlquilada;

    public Bicicleta() {
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
    }

    public Bicicleta(String codigo, Tipo tipo, boolean enMantenimiento, boolean estaAlquilada) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.enMantenimiento = enMantenimiento;
        this.estaAlquilada = estaAlquilada;
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
        String estado = "";
        if (enMantenimiento) {
            estado = "Mantenimiento";
        } else {
            estado = "Disponible";
        }
        return codigo + "#" + tipo + "#" + estado;
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
    public int compareTo(Bicicleta o) {
        return this.codigo.compareTo(o.codigo);
    }
}
