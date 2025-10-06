package sistemaAutogestion;

//Agregar aquí nombres y números de estudiante de los integrantes del equipo
import dominio.Alquiler;
import dominio.Barrio;
import dominio.Bicicleta;
import dominio.Deposito;
import dominio.Estacion;
import dominio.Mantenimiento;
import dominio.Usuario;
import tads.Lista.Nodo;
import tads.Lista.Lista;
import tads.ListaSEO.ListaSEO;

public class Sistema implements IObligatorio {

    private Lista<Alquiler> listaAlquiler;
    private Lista<Barrio> listaBarrio;
    private Lista<Bicicleta> listaBicicleta;
    private final Deposito deposito;
    private Lista<Estacion> listaEstacion;
    private Lista<Mantenimiento> listaMantenimiento;
    private ListaSEO<Usuario> listaUsuario;
    private Lista<Alquiler> listaUltimosAlquileres;

    public Sistema() {
        listaAlquiler = new Lista<Alquiler>();
        listaBarrio = new Lista<Barrio>();
        listaBicicleta = new Lista<Bicicleta>();
        deposito = new Deposito();
        deposito.setNombre("Centro");
        listaEstacion = new Lista<Estacion>();
        listaMantenimiento = new Lista<Mantenimiento>();
        listaUsuario = new ListaSEO<Usuario>();
        listaUltimosAlquileres = new Lista<Alquiler>();
    }

    @Override
    public Retorno crearSistemaDeGestion() {
        listaAlquiler = new Lista<Alquiler>();
        listaBarrio = new Lista<Barrio>();
        listaBicicleta = new Lista<Bicicleta>();
        deposito.setNombre("Centro");
        listaEstacion = new Lista<Estacion>();
        listaMantenimiento = new Lista<Mantenimiento>();
        listaUsuario = new ListaSEO<Usuario>();
        listaUltimosAlquileres = new Lista<Alquiler>();
        return Retorno.ok();
    }

    @Override
    public Retorno registrarEstacion(String nombre, String barrio, int capacidad) {
        if (nombre == null || nombre.trim().isEmpty()
                || barrio == null || barrio.trim().isEmpty()) {
            return Retorno.error1();
        }

        if (capacidad <= 0) {
            return Retorno.error2();
        }

        Estacion estacion = new Estacion(nombre, barrio, capacidad);
        if (!listaEstacion.existeElemento(estacion)) {
            listaEstacion.agregarInicio(estacion);
            return Retorno.ok();
        } else {
            return Retorno.error3();
        }
    }

    @Override
    public Retorno registrarUsuario(String cedula, String nombre) {
        if (cedula == null || cedula.trim().isEmpty()
                || nombre == null || nombre.trim().isEmpty()) {
            return Retorno.error1();
        }

        if (cedula.length() != 8) {
            return Retorno.error2();
        }

        Usuario usuario = new Usuario(cedula, nombre);

        if (!listaUsuario.existeElemento(usuario)) {
            listaUsuario.agregarOrdenado(usuario);
            return Retorno.ok();
        } else {
            return Retorno.error3();
        }
    }

    @Override
    public Retorno registrarBicicleta(String codigo, String tipo) {
        if (codigo == null || codigo.trim().isEmpty()
                || tipo == null || tipo.trim().isEmpty()) {
            return Retorno.error1();
        }

        codigo = codigo.trim();
        tipo = tipo.trim().toUpperCase();

        if (codigo.length() != 6) {
            return Retorno.error2();
        }

        if (!(tipo.equals("URBANA") || tipo.equals("MOUNTAIN") || tipo.equals("ELECTRICA"))) {
            return Retorno.error3();
        }

        Bicicleta bicicleta = new Bicicleta();
        bicicleta.setCodigo(codigo);
        if (tipo.equals("URBANA")) {
            bicicleta.setTipo(Bicicleta.Tipo.URBANA);
        } else if (tipo.equals("MOUNTAIN")) {
            bicicleta.setTipo(Bicicleta.Tipo.MOUNTAIN);
        } else {
            bicicleta.setTipo(Bicicleta.Tipo.ELECTRICA);
        }

        if (!listaBicicleta.existeElemento(bicicleta)) {
            listaBicicleta.agregarInicio(bicicleta);
            deposito.setBicicletasEnMantenimiento(bicicleta);
            return Retorno.ok();
        } else {
            return Retorno.error4();
        }
    }

    @Override
    public Retorno marcarEnMantenimiento(String codigo, String motivo) {
        if (codigo == null || codigo.trim().isEmpty()
                || motivo == null || motivo.trim().isEmpty()) {
            return Retorno.error1();
        }

        codigo = codigo.trim();

        Bicicleta key = new Bicicleta();
        key.setCodigo(codigo);

        if (!listaBicicleta.existeElemento(key)) {
            return Retorno.error2(); // no existe la bici
        }

        Bicicleta bicicleta = (Bicicleta) listaBicicleta.obtenerElemento(key);
        if (bicicleta == null) {
            return Retorno.error2();
        }

        if (bicicleta.isEstaAlquilada()) {
            return Retorno.error3();
        }
        if (bicicleta.isEnMantenimiento()) {
            return Retorno.error4();
        }

        Mantenimiento mant = new Mantenimiento(codigo, motivo);

        bicicleta.setEnMantenimiento(true);
        deposito.setBicicletasEnMantenimiento(bicicleta);

        return Retorno.ok();
    }

    @Override
    public Retorno repararBicicleta(String codigo) {
        if (codigo == null || codigo.trim().isEmpty()) {
            return Retorno.error1();
        }

        Bicicleta key = new Bicicleta();
        key.setCodigo(codigo);

        if (!listaBicicleta.existeElemento(key)) {
            return Retorno.error2();
        }

        Bicicleta bicicleta = (Bicicleta) listaBicicleta.obtenerElemento(key);

        if (!bicicleta.isEnMantenimiento()) {
            return Retorno.error3();
        }

        bicicleta.setEnMantenimiento(false);
        return Retorno.ok();
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
        if (codigo == null || codigo.trim().isEmpty()
                || nombreEstacion == null || nombreEstacion.trim().isEmpty()) {
            return Retorno.error1();
        }

        Bicicleta key = new Bicicleta();
        key.setCodigo(codigo);

        if (!listaBicicleta.existeElemento(key)) {
            return Retorno.error2();
        }
        Bicicleta bici = (Bicicleta) listaBicicleta.obtenerElemento(key);

        Estacion eKey = new Estacion();
        eKey.setNombre(nombreEstacion);
        if (!listaEstacion.existeElemento(eKey)) {
            return Retorno.error2();
        }
        Estacion est = (Estacion) listaEstacion.obtenerElemento(eKey);

        est.setBicicletasEnEstacion(bici);
        return Retorno.ok();
    }

    @Override
    public Retorno alquilarBicicleta(String cedula, String nombreEstacion) {
        if (cedula == null || cedula.trim().isEmpty()
                || nombreEstacion == null || nombreEstacion.trim().isEmpty()) {
            return Retorno.error1();
        }
        cedula = cedula.trim();
        nombreEstacion = nombreEstacion.trim();

        Usuario uKey = new Usuario(cedula, "");
        if (!listaUsuario.existeElemento(uKey)) {
            return Retorno.error2();
        }
        Usuario usuario = (Usuario) listaUsuario.obtenerElemento(uKey);

        Estacion eKey = new Estacion();
        eKey.setNombre(nombreEstacion);
        if (!listaEstacion.existeElemento(eKey)) {
            return Retorno.error2();
        }
        Estacion estacion = (Estacion) listaEstacion.obtenerElemento(eKey);

        ListaSEO<Bicicleta> bicis = estacion.getBicicletasEnEstacion();
        if (bicis == null || bicis.getCantidadElementos() == 0) {
            return Retorno.error3();
        }

        Bicicleta seleccionada = null;
        for (int i = 1; i <= bicis.getCantidadElementos(); i++) {
            Bicicleta b = (Bicicleta) bicis.obtenerElementoPosicion(i);
            if (b != null && !b.isEstaAlquilada() && !b.isEnMantenimiento()) {
                if (seleccionada == null) {
                    seleccionada = b;
                }
            }
        }

        if (seleccionada == null) {
            return Retorno.error3();
        }

        seleccionada.setEstaAlquilada(true);
        return Retorno.ok();
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
            return Retorno.error1(); // Parametros null o vacío
        }
        if (cedula.length() != 8) {
            return Retorno.error2(); // Formato de cedula invalido
        }

        Usuario usuario = new Usuario();
        usuario.setCedula(cedula);   // <- acá seteás la PK

        usuario = (Usuario) listaUsuario.obtenerElemento(usuario);

        if (usuario == null) {
            return Retorno.error3(); // Usuario inexistente
        } else {
            return Retorno.ok();
        }
    }

    @Override
    public Retorno listarUsuarios() {
        String res = "";
        String sep = "";
        int contador = 1;

        while (contador <= listaUsuario.getCantidadElementos()) {
            Usuario u = (Usuario) listaUsuario.obtenerElementoPosicion(contador);
            res += sep + u.toString();
            sep = "|";
            contador++;
        }

        return Retorno.ok(res);
    }

    @Override
    public Retorno listarBicisEnDeposito() {
        String res = "";
        String sep = "";
        int contador = 1;
        Lista<Bicicleta> retornoListaBicis = deposito.getBicicletasEnMantenimiento();
        while (contador <= retornoListaBicis.getCantidadElementos()) {
            Bicicleta b = (Bicicleta) listaBicicleta.obtenerElementoPosicion(contador);
            res += sep + b.toString();
            sep = "|";
            contador++;
        }

        return Retorno.ok(res);
    }

    @Override
    public Retorno informaciónMapa(String[][] mapa) {
        String mensaje = "";
        int maxPorFila = 0;

        for (int fila = 0; fila < mapa.length; fila++) {
            int contador = 0;
            for (int col = 0; col < mapa[fila].length; col++) {
                if (!mapa[fila][col].equals("0")) {
                    contador++;
                }
            }
            if (contador > maxPorFila) {
                maxPorFila = contador;
            }
        }

        int maxPorCol = 0;
        boolean existe = false;
        int contadorColumnasAscendentes = 1;
        int ultimoConteo = -1;

        for (int col = 0; col < mapa[0].length; col++) {
            int contadorCol = 0;
            for (int fila = 0; fila < mapa.length; fila++) {
                if (!mapa[fila][col].equals("0")) {
                    contadorCol++;
                }
            }
            if (contadorCol > maxPorCol) {
                maxPorCol = contadorCol;
            }

            if (ultimoConteo != -1 && contadorCol > ultimoConteo) {
                contadorColumnasAscendentes++;
            } else {
                contadorColumnasAscendentes = 1;
            }
            if (contadorColumnasAscendentes >= 3) {
                existe = true;
            }
            ultimoConteo = contadorCol;
        }

        String tipo;
        if (maxPorFila == maxPorCol) {
            tipo = "ambas";
        } else if (maxPorFila > maxPorCol) {
            tipo = "fila";
        } else {
            tipo = "columna";
        }

        int maxGlobal = Math.max(maxPorFila, maxPorCol);
        mensaje = maxGlobal + "#" + tipo + "|" + (existe ? "existe" : "no existe");

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
