package br.upe;

import org.junit.Test;

import junit.framework.TestCase;

public class ResultadoMegaSenaTest extends TestCase {
  /** Número de dezenas esperadas no resultado da mega-sena. */
  private final static int NUMERO_DE_DEZENAS = 6;

  /**
   * Teste do método obtemUltimoResultado()
   */
  
  @Test
  public void testObtemUltimoResultado() {
    String[] ultimoResultado = ResultadoMegaSena.obtemUltimoResultado();

    assertNotNull(ultimoResultado);
    assertTrue(ultimoResultado.length == NUMERO_DE_DEZENAS);
  }
}