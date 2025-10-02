/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.util.Objects;
import tads.Lista.Lista;

/**
 *
 * @author USUARIO
 */
public class Deposito {
    
    private String nombre;
    private Lista<Bicicleta> bicicletasEnDeposito = new Lista<Bicicleta>();
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public Lista<Bicicleta> getBicicletasEnMantenimiento() {
        return bicicletasEnDeposito;
    }
    
    public void setBicicletasEnMantenimiento(Bicicleta bicicleta) {
        this.bicicletasEnDeposito.agregarInicio(bicicleta);
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
        final Deposito other = (Deposito) obj;
        return Objects.equals(this.nombre, other.nombre);
    }
    
    @Override
    public String toString() {
        return "Deposito{" + "nombre=" + nombre + '}';
    }
    
}
