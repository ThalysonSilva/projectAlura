//import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
//import java.awt.image.ImageObserver;
import java.io.File;
//import java.io.InputStream;
//import java.net.URL;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class geradorDeFigurinhas {

    public void criar(InputStream inputStream, String nomeArquivo) throws Exception {

        // chamar a imagem local(tem a opção de puxar em um link tbm na internet, trocaria o opção file)
        //BufferedImage imagemOriginal = ImageIO.read(new File( "imagem/TopMovies_1.jpg"));
        BufferedImage imagemOriginal = ImageIO.read(inputStream);
        
        /*
         * Tem a opção de chamar a imagem atravês de um link web.. segue o códifo a baixo \/
        InputStream inputStream = new URL("https://i.pinimg.com/564x/bd/51/d8/bd51d841329b5261088a729325003248.jpg").openStream();
        BufferedImage imagemOriginal = ImageIO.read(inputStream); 
        */

        // cria nova imagem em memória com transparência e com tamanho novo(aumentar o tamanho)
        int largura = imagemOriginal.getWidth(); // Definir a largura da imagem 
        int altura = imagemOriginal.getHeight(); // Definir a altura da imagem
        int novaAltura = altura + 200;
        BufferedImage novaImagem = new BufferedImage( largura, novaAltura, BufferedImage.TRANSLUCENT); // aqui transforma na imagem em transparente

        // copiar a imagem original para novo imagem(em memória)
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);

        // Configuração da fonte 
        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 64);
        graphics.setColor(Color.YELLOW);
        graphics.setFont(fonte); 

        // escrever uma frase na nova imagem
        graphics.drawString("TOPZERA", 190, novaAltura-100);

        // escrever a nova imagem em um arquivo( ou seja, salvar a imagem em alguma pasta já existente)
        ImageIO.write(novaImagem, "png", new File(nomeArquivo)); // criação da figurinha, e o endereço onde ela vai ser criada

    }
}

