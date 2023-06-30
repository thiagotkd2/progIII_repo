/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package extrato;


import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.*;


/**
 *
 * @author Thiago
 */
public class main {

    /**
     * @param args the command line arguments
     * @throws IOException
     */
    public static void main(String[] args) throws IOException{
        
        boolean uso_args = args.length != 0;
        
        
        String arquivo_entrada="", arquivo_saida= "";
        
        if(!uso_args){
            Scanner s = new Scanner(System.in);
            System.out.println("Nos arquivos a seguir, especifique o tipo (.txt, .csv, etc.) e o caminho, a partir da pasta do projeto.");
            System.out.println("Caminho do arquivo de entrada.");
            arquivo_entrada = s.nextLine();

            System.out.println("Caminho do arquivo de saída.");
            arquivo_saida = s.nextLine();

        }else{
            arquivo_entrada = args[0];
            arquivo_saida = args[1];
        }
        
        ListaEncadeada<Conta> listaConta = new ListaEncadeada(); 
        try{
            HelperClass.processaArquivoEntrada(listaConta, arquivo_entrada);

            HelperClass.preencheArquivoSaida(listaConta, arquivo_saida);
        }catch (FileNotFoundException ex) {
                System.out.println("Arquivo de entrada não encontrado.");
        }
    }
}
