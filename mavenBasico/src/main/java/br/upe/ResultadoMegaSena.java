package br.upe;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * Classe que obtém os números do último sorteio da mega-sena.
 */

public class ResultadoMegaSena {
    /** URL que possui as dezenas sorteadas. */
    private final static String URL = "https://noticias.uol.com.br/loterias/mega-sena/";

    /**
     * Método que se conecta ao site da CEF para obter as dezenas do último sorteio.
     * 
     * @return array de Strings, onde cada elemento é uma dezena sorteada.
     */

    public static String[] obtemUltimoResultado() {
        try (CloseableHttpClient httpclient = HttpClients.custom().disableRedirectHandling() // Desativa o tratamento de redirecionamento
                .build()) {
            HttpGet httpget = new HttpGet(URL);
            String html = EntityUtils.toString(httpclient.execute(httpget).getEntity());
            return obterDezenas(html);
        } catch (Exception e) {
            throw new RuntimeException("Um erro inesperado ocorreu !", e);
        }
    }
    /**
     * Tratamento da resposta HTML obtida pelo método obtemUltimoResultado().
     * 
     * @param html resposta HTML obtida
     * @return array de Strings, onde cada elemento é uma dezena sorteada.
     */
    private static String[] obterDezenas(String html) {
        // Posição inicial de onde começam as dezenas
        Integer parteInicial = html.indexOf(MARCA_INICIAL_RETORNO_NAO_UTIL) + MARCA_INICIAL_RETORNO_NAO_UTIL.length();

        // Posição final de onde começam as dezenas
        Integer parteFinal = html.indexOf(MARCA_FINAL_RETORNO_NAO_UTIL);

        // Substring montada com base nas posições, com remoção de espaços.
        String extracao = html.substring(parteInicial, parteFinal).replaceAll(" ", "");

        // Criação de array, com base no método split(), separando por hifen.
        String[] numeros = extracao.split("-");

        return numeros;
    }
}