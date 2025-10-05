package sistemaAutogestion;

import org.junit.Test;
import static org.junit.Assert.*;

public class Test2_01CrearSistemaDeGestion {

    private Retorno retorno;
    private final IObligatorio s = new Sistema();

    public enum TipoBicicleta {
        URBANA,
        MOUNTAIN,
        ELECTRICA
    }

    @Test
    public void testCrearSistemaDeGestion() {
        retorno = s.crearSistemaDeGestion();
        assertEquals(Retorno.Resultado.OK, retorno.getResultado());
    }

}
