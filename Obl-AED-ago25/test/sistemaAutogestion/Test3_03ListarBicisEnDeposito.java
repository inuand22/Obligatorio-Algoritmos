package sistemaAutogestion;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class Test3_03ListarBicisEnDeposito {

    private Retorno retorno;
    private final IObligatorio s = new Sistema();

    @Before
    public void setUp() {
        s.crearSistemaDeGestion();
    }

    @Test
    public void listarBiciEnDepositoVacio() {
        retorno = s.listarBicisEnDeposito();
        assertEquals(Retorno.Resultado.OK, retorno.getResultado());
        assertEquals("", retorno.getValorString());
    }

    @Test
    public void listarBiciEnDepositoUnaBici() {
        retorno = s.registrarBicicleta("123456", "URBANA");
        assertEquals(Retorno.Resultado.OK, retorno.getResultado());

        retorno = s.listarBicisEnDeposito();
        assertEquals(Retorno.Resultado.OK, retorno.getResultado());
        assertEquals("123456#URBANA#Disponible", retorno.getValorString());
    }

    @Test
    public void listarBiciEnDepositoOrdenado() {
        retorno = s.registrarBicicleta("123456", "URBANA");
        assertEquals(Retorno.Resultado.OK, retorno.getResultado());

        retorno = s.registrarBicicleta("123455", "MOUNTAIN");
        assertEquals(Retorno.Resultado.OK, retorno.getResultado());

        retorno = s.registrarBicicleta("123446", "ELECTRICA");
        assertEquals(Retorno.Resultado.OK, retorno.getResultado());

        retorno = s.listarBicisEnDeposito();
        assertEquals(Retorno.Resultado.OK, retorno.getResultado());
        assertEquals("123446#ELECTRICA#Disponible|123455#MOUNTAIN#Disponible|123456#URBANA#Disponible", retorno.getValorString());
    }

}
