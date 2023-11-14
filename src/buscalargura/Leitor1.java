/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscalargura;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.JOptionPane;

/**
 * Projeto: 
 *
 * Tipo: 
 *
 * Descrição: A classe faz a leitura de um arquivo e retorna o vetorTexto num array
 * junto com a informação da quantidade de linha que o arquivo contém.
 *
 * @see Path
 * @see Charset
 * @author Michael Dydean
 *
 * @version 1.50
 */
public class Leitor1 {
    private int contadorLinhas;
    private String[] vetorTexto;
    private Path path;
    private final Charset utf8 = StandardCharsets.UTF_8;
    
    /**
     * O método faz a leitura do arquivo especificado pela informação de
     * endereço de localização passado por parâmetro.
     *
     * @param url endereço do arquivo que será lido
     */
    @SuppressWarnings("empty-statement")
     public void lerArquivoUTF8(String url) {

        this.vetorTexto = new String[50000];
        this.path = Paths.get(url);
        this.contadorLinhas = 0;

        try (BufferedReader r = Files.newBufferedReader(this.path, this.utf8)) {
            while ((this.vetorTexto[this.contadorLinhas++] = r.readLine()) != null);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e, "Aviso", 2);
        }
    }
     
    /**
     * retorna a quantidade de linha do arquivo.
     *
     * @return - valor numerico.
     */
    public int getQtdLinhas() {
        return this.contadorLinhas - 1;
    }

    /**
     * retorna o vetor, que contém todo o conteúdo coletado do arquivo.
     *
     * @return - arra de vetorTexto.
     */
    public String[] getArray() {
        return this.vetorTexto;
    }
}
