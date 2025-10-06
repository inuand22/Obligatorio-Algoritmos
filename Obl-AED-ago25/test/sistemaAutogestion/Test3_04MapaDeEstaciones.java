package sistemaAutogestion;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class Test3_04MapaDeEstaciones {

    private Retorno retorno;
    private final IObligatorio s = new Sistema();

    @Before
    public void setUp() {
        s.crearSistemaDeGestion();
    }

    @Test
    public void informacionMapa_Ejemplo1() {
        String[][] mapa = new String[][]{
            {"E1", "0", "E4", "0", "0"},
            {"0", "E2", "0", "0", "0"},
            {"0", "0", "E5", "0", "0"},
            {"0", "E3", "0", "0", "0"},
            {"0", "0", "E6", "0", "0"}
        };

        retorno = s.informaciónMapa(mapa);
        assertEquals(Retorno.Resultado.OK, retorno.getResultado());
        assertEquals("3#columna|existe", retorno.getValorString());
    }

    @Test
    public void informacionMapa_Ejemplo2() {
        String[][] mapa = new String[][]{
            {"0", "0", "E1", "E2"},
            {"0", "0", "E3", "0"},
            {"0", "E4", "0", "0"},
            {"0", "0", "0", "0"}
        };

        retorno = s.informaciónMapa(mapa);
        assertEquals(Retorno.Resultado.OK, retorno.getResultado());
        assertEquals("2#ambas|existe", retorno.getValorString());
    }

    @Test
    public void informacionMapa_Ejemplo3() {
        String[][] mapa = new String[][]{
            {"E1", "0", "0", "E2"},
            {"E3", "0", "0", "0"},
            {"0", "E4", "0", "E5"},
            {"0", "E6", "0", "0"}
        };

        retorno = s.informaciónMapa(mapa);
        assertEquals(Retorno.Resultado.OK, retorno.getResultado());
        assertEquals("2#ambas|no existe", retorno.getValorString());
    }

    @Test
    public void informacionMapa_Vacio() {
        String[][] mapa = new String[][]{
            {"0", "0", "0"},
            {"0", "0", "0"},
            {"0", "0", "0"}
        };

        retorno = s.informaciónMapa(mapa);
        assertEquals(Retorno.Resultado.OK, retorno.getResultado());
        assertEquals("0#ambas|no existe", retorno.getValorString());
    }
}
