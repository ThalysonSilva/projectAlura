//import java.awt.RenderingHints.Key;
//import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class mainClass {
    public static void main(String[] args) throws Exception {

		// Fazer uma conexão HTTP e buscar os top 250 filmes
		String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json"; // aqui vai colocar o endereço da sua chave API
		URI endereco = URI.create(url);
		var client = HttpClient.newHttpClient();
		var request = HttpRequest.newBuilder(endereco).GET().build();
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		String body = response.body();
		
		
		// Extrair só os dados que interessam(Titulo, poster, classificação
		var parser = new JsonParser();
		List<Map<String, String>> listaDeFilmes = parser.parse(body);
		
		// Exibir e manipular os dados 
        var geradora = new geradorDeFigurinhas();
		for (Map<String, String> filme : listaDeFilmes) {
            String urlFilmes = filme.get("image");
            String titulo = filme.get("title");
            
            InputStream inputStream = new URL(urlFilmes).openStream();
            String nomeArquivo = titulo + ".png";

            geradora.criar(inputStream, nomeArquivo);

			System.out.println(titulo);
			System.out.println();
		}
	}
}
