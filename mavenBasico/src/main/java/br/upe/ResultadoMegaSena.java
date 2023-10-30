package br.upe;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

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
        Document doc = Jsoup.parse(html);
        Elements ulDezenas = doc.getElementsByClass("lt-result");
        String[] numeros = new String[ulDezenas.size()];
        for (int i = 0; i < ulDezenas.size(); i++) {
            Element dezenaElement = ulDezenas.get(i);
            numeros[i] = dezenaElement.text();
        }
        return numeros;
    }
}