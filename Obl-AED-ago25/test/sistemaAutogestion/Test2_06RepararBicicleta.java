package sistemaAutogestion;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class Test2_06RepararBicicleta {

    private Retorno retorno;
    private final IObligatorio s = new Sistema();

    @Before
    public void setUp() {
        s.crearSistemaDeGestion();
    }

    @Test
    public void repararBicicletaOk() {
        retorno = s.registrarBicicleta("456789", "URBANA");
        assertEquals(Retorno.Resultado.OK, retorno.getResultado());

        retorno = s.marcarEnMantenimiento("456789", "Necesita ajustar el manillar");
        assertEquals(Retorno.Resultado.OK, retorno.getResultado());

        retorno = s.repararBicicleta("456789");
        assertEquals(Retorno.Resultado.OK, retorno.getResultado());
    }

    @Test
    public void repararBicicleta01() {
        retorno = s.repararBicicleta("");
        assertEquals(Retorno.Resultado.ERROR_1, retorno.getResultado());

        retorno = s.repararBicicleta("   ");
        assertEquals(Retorno.Resultado.ERROR_1, retorno.getResultado());

        retorno = s.repararBicicleta(null);
        assertEquals(Retorno.Resultado.ERROR_1, retorno.getResultado());
    }

    @Test
    public void repararBicicleta02() {
        retorno = s.repararBicicleta("123");
        assertEquals(Retorno.Resultado.ERROR_2, retorno.getResultado());

        retorno = s.repararBicicleta("12");
        assertEquals(Retorno.Resultado.ERROR_2, retorno.getResultado());
    }

    @Test
    public void repararBicicleta03() {
        retorno = s.registrarBicicleta("123456", "URBANA");
        assertEquals(Retorno.Resultado.OK, retorno.getResultado());

        retorno = s.repararBicicleta("123456");
        assertEquals(Retorno.Resultado.ERROR_3, retorno.getResultado());
    }

}
