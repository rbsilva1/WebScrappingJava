package br.upe;

public class App {
    public static void main(String[] args) {
        String[] dezenas = null;

        while (dezenas == null) {
            dezenas = ResultadoMegaSena.obtemUltimoResultado();
        }
        System.out.println("Dezenas da Mega Sena:");
        for (String dezena : dezenas) {
            System.out.print(dezena + " ");
            System.out.println("\n");

        }
    }
}
