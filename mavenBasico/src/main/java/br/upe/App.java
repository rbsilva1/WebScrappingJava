package br.upe;

public class App {
  public static void main(String[] args) {
    String[] resultado = ResultadoMegaSena.obtemUltimoResultado();
    for (String dezena : resultado) {
      System.out.print(dezena + " ");
    }
  }
}