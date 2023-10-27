package br.upe.mavenBasico;

import br.upe.mavenBasico.ResultadoMegasena;

import junit.framework.TestCase;
import org.junit.Test;

public class ResultadoMegasenaTest extends TestCase {
    /** Número de dezenas esperadas no resultado da mega-sena. */
    private final static int NUMERO_DE_DEZENAS = 6;
    /**
     * Teste do método obtemUltimoResultado()
     */
    @Test
    public void testObtemUltimoResultado() {
        String[] ultimoResultado =
                ResultadoMegasena.obtemUltimoResultado();
        assertNotNull(ultimoResultado);
        assertTrue( ultimoResultado.length == NUMERO_DE_DEZENAS );
    }
}