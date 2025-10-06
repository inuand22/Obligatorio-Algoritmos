package sistemaAutogestion;

import dominio.Bicicleta;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class Test2_05MarcarMantenimiento {

    private Retorno retorno;
    private final IObligatorio s = new Sistema();

    @Before
    public void setUp() {
        s.crearSistemaDeGestion();
    }

    @Test
    public void MarcarMantenimientoOk() {
        retorno = s.registrarBicicleta("123456", "URBANA");
        assertEquals(Retorno.Resultado.OK, retorno.getResultado());

        retorno = s.marcarEnMantenimiento("123456", "Se repara cadena de bicicleta");
        assertEquals(Retorno.Resultado.OK, retorno.getResultado());
    }

    @Test
    public void MarcarMantenimiento01() {
        retorno = s.registrarBicicleta("123456", "URBANA");

        retorno = s.marcarEnMantenimiento("", "Se repara cadena de bicicleta");
        assertEquals(Retorno.Resultado.ERROR_1, retorno.getResultado());

        retorno = s.marcarEnMantenimiento("123456", "");
        assertEquals(Retorno.Resultado.ERROR_1, retorno.getResultado());

        retorno = s.marcarEnMantenimiento("   ", "Se repara cadena de bicicleta");
        assertEquals(Retorno.Resultado.ERROR_1, retorno.getResultado());

        retorno = s.marcarEnMantenimiento("123456", "   ");
        assertEquals(Retorno.Resultado.ERROR_1, retorno.getResultado());

        retorno = s.marcarEnMantenimiento(null, "Se repara cadena de bicicleta");
        assertEquals(Retorno.Resultado.ERROR_1, retorno.getResultado());

        retorno = s.marcarEnMantenimiento("123456", null);
        assertEquals(Retorno.Resultado.ERROR_1, retorno.getResultado());
    }

    @Test
    public void MarcarMantenimiento02() {
        retorno = s.registrarBicicleta("123456", "URBANA");

        retorno = s.marcarEnMantenimiento("123", "URBANA");
        assertEquals(Retorno.Resultado.ERROR_2, retorno.getResultado());

        retorno = s.marcarEnMantenimiento("12", "URBANA");
        assertEquals(Retorno.Resultado.ERROR_2, retorno.getResultado());
    }

    @Test
    public void MarcarMantenimiento03() {

        retorno = s.registrarBicicleta("123456", "URBANA");
        assertEquals(Retorno.Resultado.OK, retorno.getResultado());

        retorno = s.registrarUsuario("12345678", "Pedro");
        assertEquals(Retorno.Resultado.OK, retorno.getResultado());

        retorno = s.registrarEstacion("Estacion01", "Centro", 5);
        assertEquals(Retorno.Resultado.OK, retorno.getResultado());

        retorno = s.asignarBicicletaAEstacion("123456", "Estacion01");
        assertEquals(Retorno.Resultado.OK, retorno.getResultado());

        retorno = s.alquilarBicicleta("12345678", "Estacion01");
        assertEquals(Retorno.Resultado.OK, retorno.getResultado());

        retorno = s.marcarEnMantenimiento("123456", "Se repara cadena");
        assertEquals(Retorno.Resultado.ERROR_3, retorno.getResultado());
    }

    @Test
    public void MarcarMantenimiento04() {
        retorno = s.registrarBicicleta("222222", "URBANA");
        assertEquals(Retorno.Resultado.OK, retorno.getResultado());

        retorno = s.marcarEnMantenimiento("222222", "Cambio de frenos");
        assertEquals(Retorno.Resultado.OK, retorno.getResultado());

        retorno = s.marcarEnMantenimiento("222222", "Otra intervención");
        assertEquals(Retorno.Resultado.ERROR_4, retorno.getResultado());

    }

}
