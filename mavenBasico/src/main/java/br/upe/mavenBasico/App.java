package br.upe.mavenBasico;

public class App {
    public static void main(String[] args) {
        String[] dezenas = null;

        while (dezenas == null) {
            dezenas = ResultadoMegasena.obtemUltimoResultado();
            if(dezenas != null){
                System.out.println("Dezenas da Mega Sena:");
                for (String dezena : dezenas) {
                    System.out.print(dezena + " ");
                }
                System.out.println();

            }
        }
    }
}

