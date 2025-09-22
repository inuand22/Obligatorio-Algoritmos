package sistemaAutogestion;

//Agregar aquí nombres y números de estudiante de los integrantes del equipo
import dominio.Alquiler;
import dominio.Barrio;
import dominio.Bicicleta;
import dominio.Deposito;
import dominio.Estacion;
import dominio.Mantenimiento;
import dominio.Usuario;
import tads.Lista;

public class Sistema implements IObligatorio {

    Lista<Alquiler> listaAlquiler;
    Lista<Barrio> listaBarrio;
    Lista<Bicicleta> listaBicicleta;
    Lista<Deposito> listaDeposito;
    Lista<Estacion> listaEstacion;
    Lista<Mantenimiento> listaMantenimiento;
    Lista<Usuario> listaUsuario;

    public Sistema() {
        listaAlquiler = new Lista<Alquiler>();
        listaBarrio = new Lista<Barrio>();
        listaBicicleta = new Lista<Bicicleta>();
        listaDeposito = new Lista<Deposito>();
        listaEstacion = new Lista<Estacion>();
        listaMantenimiento = new Lista<Mantenimiento>();
        listaUsuario = new Lista<Usuario>();
    }

    @Override
    public Retorno crearSistemaDeGestion() {
        listaAlquiler = new Lista<Alquiler>();
        listaBarrio = new Lista<Barrio>();
        listaBicicleta = new Lista<Bicicleta>();
        listaDeposito = new Lista<Deposito>();
        listaEstacion = new Lista<Estacion>();
        listaMantenimiento = new Lista<Mantenimiento>();
        listaUsuario = new Lista<Usuario>();
        return Retorno.ok();
    }

    @Override
    public Retorno registrarEstacion(String nombre, String barrio, int capacidad) {
        Estacion estacion = new Estacion(nombre, barrio, capacidad);
        if (!listaEstacion.existeElemento(estacion)) {
            listaEstacion.agregarInicio(estacion);
            return Retorno.ok();
        } else {
            return Retorno.error1();
        }
    }

    @Override
    public Retorno registrarUsuario(String cedula, String nombre) {
        //VERIFICAR EN SISTEMA QUE NO EXISTA USUARIO CON MISMA CEDULA
        Usuario usuario = new Usuario(cedula, nombre);
        if (!listaUsuario.existeElemento(usuario)) {
            listaUsuario.agregarInicio(usuario);
            return Retorno.ok();
        } else {
            return Retorno.error1();
        }
    }

    @Override
    public Retorno registrarBicicleta(String codigo, String tipo) {
        //VERIFICAR EN SISTEMA QUE NO EXISTA BICICLETA CON MISMO CODIGO
        return Retorno.noImplementada();
    }

    @Override
    public Retorno marcarEnMantenimiento(String codigo, String motivo) {
        //VERIFICAR EN SISTEMA QUE: EXISTA BICI; BICI NO ESTE ALQUILADA; BICI NO ESTE EN MANTENIMIENTO
        //NIGÚN PARÁMETRO NULO O VACIO
        return Retorno.noImplementada();
    }

    @Override
    public Retorno repararBicicleta(String codigo) {
        //VERIFICAR EN SISTEMA QUE: EXISTA BICI; BICI NO ESTE EN MANTENIMIENTO
        //NIGÚN PARÁMETRO NULO O VACIO
        return Retorno.noImplementada();
    }

    @Override
    public Retorno eliminarEstacion(String nombre) {
        //VERIFICAR EN SISTEMA QUE: EXISTE ESTACION; NO TIENE BICI ANCLADA, COLA PENDIENTE DE USUARIO PARA ALQUILER O ENTREGA
        //NIGÚN PARÁMETRO NULO O VACIO
        return Retorno.noImplementada();
    }

    @Override
    public Retorno asignarBicicletaAEstacion(String codigo, String nombreEstacion) {
        //VERIFICAR EN SISTEMA QUE: EXISTE BICI; EXISTE ESTACION; ESTACION SIN ANCLAJES LIBRES; BICI NO DISPONIBLE (NO REPARADA == ENMANTENIMIENTO)
        //NIGÚN PARÁMETRO NULO O VACIO
        return Retorno.noImplementada();
    }

    @Override
    public Retorno alquilarBicicleta(String cedula, String nombreEstacion) {
        //NIGÚN PARÁMETRO NULO O VACIO
        //VERIFICAR EN SISTEMA QUE: USUARIO EXISTE; EXISTE ESTACION
        return Retorno.noImplementada();
    }

    @Override
    public Retorno devolverBicicleta(String cedula, String nombreEstacionDestino) {
        //NIGÚN PARÁMETRO NULO O VACIO
        //VERIFICAR EN SISTEMA QUE:USUARIO EXISTE; ESTACION EXISTE; USUARIO TIENE BICI ALQUILADA EN SISTEMA
        return Retorno.noImplementada();
    }

    @Override
    public Retorno deshacerUltimosRetiros(int n) {
        return Retorno.noImplementada();
    }

    @Override
    public Retorno obtenerUsuario(String cedula) {
        return Retorno.noImplementada();
    }

    @Override
    public Retorno listarUsuarios() {
        return Retorno.noImplementada();
    }

    @Override
    public Retorno listarBicisEnDeposito() {
        return Retorno.noImplementada();
    }

    @Override
    public Retorno informaciónMapa(String[][] mapa) {
        return Retorno.noImplementada();
    }

    @Override
    public Retorno listarBicicletasDeEstacion(String nombreEstacion) {
        return Retorno.noImplementada();
    }

    @Override
    public Retorno estacionesConDisponibilidad(int n) {
        return Retorno.noImplementada();
    }

    @Override
    public Retorno ocupacionPromedioXBarrio() {
        return Retorno.noImplementada();
    }

    @Override
    public Retorno rankingTiposPorUso() {
        return Retorno.noImplementada();
    }

    @Override
    public Retorno usuariosEnEspera(String nombreEstacion) {
        return Retorno.noImplementada();
    }

    @Override
    public Retorno usuarioMayor() {
        return Retorno.noImplementada();
    }

}
