/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package extrato;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;



/**
 *
 * @author Thiago
 */


public class HelperClass{
    
    // printa separadores --------- na tela, para o output
    public static void printSeparador(){
        System.out.println("----------------------------------------");
    }
    
    // ajusta o espaco da saida
    public static String ajusteEspaco(int tamanho){
        String espaco = "";
        for( int i = 0; i<tamanho; i++){
            espaco+= " ";
        }
        return espaco;
    }
    
    // cria o arquivo de saida
    public static void geraArquivoSaida(File file)throws IOException{

      // seta a saida de sys.out.print para o arquivo
      PrintStream stream = new PrintStream(file);
      System.setOut(stream);
    }
    
    // le e chama o metodo de inserção da lista
    public static void processaArquivoEntrada(ListaEncadeada<Conta> listaConta, String arquivo_entrada) throws IOException{
        BufferedReader in = new BufferedReader(new FileReader(arquivo_entrada));

        // dados do input
        String linha, valor, contaId, operacao;

        // index de inicio do input
        int indContaId = 0;
        int indOperacao, indValor;

        int operacaoInteiro, contaIdInteiro;
        double valorDec;

        Conta c;
        Extrato e;

        // captura valores do arquivo
        while ((linha = in.readLine())!=null){
            c = new Conta();
            e = new Extrato();

            // define o inicio de cada variavel na linha
            indOperacao = linha.indexOf(",") + 1;
            indValor = linha.indexOf(",", indOperacao) + 1;
            
            // atribui as variaveis as entradas
            contaId = linha.substring(indContaId, (indOperacao - 1));
            operacao = linha.substring(indOperacao, (indValor - 1));
            valor = linha.substring(indValor);
            
            operacaoInteiro = Integer.parseInt(operacao);
            valorDec = Double.parseDouble(valor);
            contaIdInteiro = Integer.parseInt(contaId);
            
            
            // setar as variaveis da iteração atual
            c.setNumero_conta(contaIdInteiro);
            e.setOperacao(operacaoInteiro);
            e.setValor(valorDec);
            
            // verifica se o id da conta ja foi inserido
            if(!listaConta.contem(c)){
                c.getExtrato().inserir(e);
                listaConta.inserir(c);
            }else{ // se ja, insere na conta 
                for (Conta contaItera : listaConta) {
                    if(c.equals(contaItera)){
                        contaItera.getExtrato().inserir(e);
                    }        
                }
            }     
        }
        in.close();
    }
    
    public static void preencheArquivoSaida(ListaEncadeada<Conta> listaConta, String nomeSaida) throws IOException{
        File arquivo = new File(nomeSaida);

        String ajusteEspacoTipo = "";
        String ajusteEspacoValor = "";
        int saldo;
        int tipo;
        double valor;
        String strOperacao;
        HelperClass.geraArquivoSaida(arquivo);
        for (Conta c : listaConta) {
            System.out.println("Número da conta: " + c.getNumero_conta());
            HelperClass.printSeparador();
            System.out.println("Detalhes das Transações:");
            HelperClass.printSeparador();
            saldo = 0;
            

            
            System.out.println("Tipo          | Valor  | Saldo");
            HelperClass.printSeparador();
            for (Extrato e : c.getExtrato()) {
                tipo = e.getOperacao();
                valor = e.getValor();
                
                if(tipo == 1 || tipo == 4){
                    saldo -= valor;
                }else if(tipo == 2){
                    saldo += valor;
                }
                strOperacao = "";
                
                if(tipo == 1){
                    strOperacao = "Saque";
                    ajusteEspacoTipo=HelperClass.ajusteEspaco(9);
                }else if(tipo == 2){
                    strOperacao = "Depósito";
                    ajusteEspacoTipo=HelperClass.ajusteEspaco(6);
                }else if(tipo == 4){
                    strOperacao = "Pagamento";
                    ajusteEspacoTipo=HelperClass.ajusteEspaco(5);
                }
                
                ajusteEspacoValor=HelperClass.ajusteEspaco(7-((Integer.toString((int) valor)).length()));
                System.out.printf("%s%s| %d%s| %d\n", strOperacao,ajusteEspacoTipo,(int) valor,ajusteEspacoValor, saldo);   
            }
            HelperClass.printSeparador();
            System.out.println("Saldo Atual: " + saldo);
            
            System.out.println("");
        }
    }
    
}
