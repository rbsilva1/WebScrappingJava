package br.upe.mavenBasico;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Esta classe obtém o último resultado da Mega-Sena.
 */
class ResultadoMegasena {

    private static final String URL = "https://noticias.uol.com.br/loterias/mega-sena/";

    /**
     * Obtém as dezenas do último resultado da Mega-Sena.
     *
     * @return Um array contendo as dezenas do último resultado da Mega-Sena.
     */
    public static String[] obtemUltimoResultado() {
        try (CloseableHttpClient httpClient = HttpClients.custom()
                .disableRedirectHandling() // Desativa o tratamento de redirecionamento
                .build()) {
            HttpGet httpGet = new HttpGet(URL);
            String html = EntityUtils.toString(httpClient.execute(httpGet).getEntity());
            return obterDezenas(html);
        } catch (IOException e) {
            throw new RuntimeException("Um erro inesperado ocorreu!", e);
        }
    }

    /**
     * Obtém as dezenas do resultado da Mega-Sena especificado pelo HTML.
     *
     * @param html O HTML do resultado da Mega-Sena.
     * @return Um array contendo as dezenas do resultado da Mega-Sena especificado pelo HTML.
     */
    private static String[] obterDezenas(String html) {
        Document document = Jsoup.parse(html);
        Elements ulDezenas = document.getElementsByClass("lt-result");
        String[] numeros = new String[ulDezenas.size()];
        for (int i = 0; i < ulDezenas.size(); i++) {
            Element dezenaElement = ulDezenas.get(i);
            numeros[i] = dezenaElement.text();
        }
        return numeros;
    }
}
