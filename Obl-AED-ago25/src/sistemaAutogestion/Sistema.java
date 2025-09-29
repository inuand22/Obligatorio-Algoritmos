package sistemaAutogestion;

//Agregar aquí nombres y números de estudiante de los integrantes del equipo
import dominio.Alquiler;
import dominio.Barrio;
import dominio.Bicicleta;
import dominio.Deposito;
import dominio.Estacion;
import dominio.Mantenimiento;
import dominio.Usuario;
import tads.Nodo;
import tads.Lista;

public class Sistema implements IObligatorio {

    private Lista<Alquiler> listaAlquiler;
    private Lista<Barrio> listaBarrio;
    private Lista<Bicicleta> listaBicicleta;
    private final Deposito deposito;
    private Lista<Estacion> listaEstacion;
    private Lista<Mantenimiento> listaMantenimiento;
    private Lista<Usuario> listaUsuario;
    private Lista<Bicicleta> listaBicicletasEnMantenimiento;
    private Lista<Bicicleta> listaBicicletasEnDeposito;

    public Sistema() {
        listaAlquiler = new Lista<Alquiler>();
        listaBarrio = new Lista<Barrio>();
        listaBicicleta = new Lista<Bicicleta>();
        deposito = new Deposito();
        deposito.setNombre("Centro");
        deposito.setBicicletasEnMantenimiento(listaBicicletasEnMantenimiento);
        listaEstacion = new Lista<Estacion>();
        listaMantenimiento = new Lista<Mantenimiento>();
        listaUsuario = new Lista<Usuario>();
        listaBicicletasEnDeposito = new Lista<Bicicleta>();
    }

    @Override
    public Retorno crearSistemaDeGestion() {
        listaAlquiler = new Lista<Alquiler>();
        listaBarrio = new Lista<Barrio>();
        listaBicicleta = new Lista<Bicicleta>();
        deposito.setNombre("Centro");
        deposito.setBicicletasEnMantenimiento(listaBicicletasEnMantenimiento);
        listaEstacion = new Lista<Estacion>();
        listaMantenimiento = new Lista<Mantenimiento>();
        listaUsuario = new Lista<Usuario>();
        listaBicicletasEnDeposito = new Lista<Bicicleta>();
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
        Bicicleta.Tipo t = Bicicleta.Tipo.valueOf(tipo.trim().toUpperCase());
        Bicicleta bicicleta = new Bicicleta(codigo, t);
        if (!listaBicicleta.existeElemento(codigo)) {
            listaBicicleta.agregarInicio(codigo);
            return Retorno.ok();
        } else {
            return Retorno.error4();
        }

    }

    @Override
    public Retorno marcarEnMantenimiento(String codigo, String motivo) {
        if (listaBicicleta.existeElemento(codigo)) {
            Bicicleta bicicleta = (Bicicleta) listaBicicleta.obtenerElemento(codigo);
            if (bicicleta.isEstaAlquilada()) {
                return Retorno.error3(); //bicicleta actualmente alquilada
            }
            if (bicicleta.isEnMantenimiento()) {
                return Retorno.error4(); //bicicleta en mantenimiento
            }
            Mantenimiento mantenimiento = new Mantenimiento(codigo, motivo);
            bicicleta.setEnMantenimiento(true);
            listaBicicletasEnMantenimiento.agregarInicio(bicicleta);
            return Retorno.ok();
        }
        return Retorno.error2();
    }

    @Override
    public Retorno repararBicicleta(String codigo) {
        if (codigo == null || codigo.trim().isEmpty()) {
            return Retorno.error1();//Parametros null o vacío
        }
        if (listaBicicleta.existeElemento(codigo)) {
            Bicicleta bicicleta = (Bicicleta) listaBicicletasEnMantenimiento.obtenerElemento(codigo);
            if (bicicleta == null) {
                return Retorno.error3(); //No se encontró bicicleta en mantenimiento
            }
            bicicleta.setEnMantenimiento(false);
            return Retorno.ok();
        }
        return Retorno.error2();//No existe bicicleta
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
        if (cedula == null || cedula.trim().isEmpty()) {
            return Retorno.error1();//Parametros null o vacío
        }
        if (cedula.length() != 8) {
            return Retorno.error2();
        }
        Usuario usuario = (Usuario) listaUsuario.obtenerElemento(cedula);
        if (usuario == null) {
            return Retorno.error3(); //No se encontró bicicleta en mantenimiento
        } else {
            return Retorno.ok();
        }
    }

    @Override
    public Retorno listarUsuarios() {
        String res = "";
        String sep = "";

        //Nodo aux = listaUsuario.getInicio();   SACAR?
        
        while (aux != null) {
            Usuario u = (Usuario) aux.getDato();
            res += sep + u.toString();   // nombre#cedula
            sep = "|";
            aux = aux.getSiguiente();
        }
        return Retorno.ok(res);
    }

    @Override
    public Retorno listarBicisEnDeposito() {
        Lista<Bicicleta> retornoListaUsuarios = listaBicicletasEnDeposito;
        return Retorno.noImplementada();
    }

    @Override
    public Retorno informaciónMapa(String[][] mapa) {
        String mensaje = "";
        int maxPorFila = 0;
        for (int fila = 0; fila < mapa.length; fila++) {
            int contador = 0;
            for (int col = 0; col < mapa[fila].length; col++) {
                if (mapa[fila][col].equals("0")) {
                    contador++;
                }
            }
            if (contador > maxPorFila) {
                maxPorFila = contador;
            }
        }
        int maxPorCol = 0;
        boolean existe = false;
        int contadorColumnasAscendentes = 0;
        for (int col = 0; col < mapa[0].length; col++) {
            int contadorCol = 0;
            for (int fila = 0; fila < mapa.length; fila++) {
                if (mapa[fila][col].equals("0")) {
                    contadorCol++;
                }
            }
            if (contadorCol > maxPorCol) {
                maxPorCol = contadorCol;
                contadorColumnasAscendentes++;
            } else {
                contadorColumnasAscendentes = 0;
            }
            if (contadorColumnasAscendentes >= 3) {
                existe = true;
            }
        }
        String tipo = "";
        if (maxPorFila == maxPorCol) {
            tipo = "ambas";
        } else if (maxPorFila > maxPorCol) {
            tipo = "fila";
        } else {
            tipo = "columna";
        }

        return Retorno.ok(mensaje);
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
