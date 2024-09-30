package Main;

import modelo.Financiamento;
import modelo.Terreno;
import util.FormatNumbers;
import util.InterfaceUsuario;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args)  throws IOException {
        List<Financiamento> listadeFinanciamentos = new ArrayList<Financiamento>();

        for(int i=1;i<5;i++){
            InterfaceUsuario interfaceUsuario = new InterfaceUsuario();
            System.out.print("\n*********** Digite os valores do Financiamento : "+(i)+" ***********");
            double valorImovel=0;
            while (valorImovel<=0){
                try {
                    valorImovel = interfaceUsuario.pedirValorImovel();

                }catch (Exception e){
                    System.out.print("\n Valor inválido digite novamente");

                }

            }
            double taxaJuros=0;
            while (taxaJuros<=0){
                try{
                    taxaJuros = interfaceUsuario.pedirTaxaJuros();
                }catch (Exception e){
                    System.out.print("\n Valor inválido digite novamente");
                }


            }
            int prazoFinanciamentoEmAnos=0;
            while (prazoFinanciamentoEmAnos<=0){
                try{
                    prazoFinanciamentoEmAnos = interfaceUsuario.pedirPrazoFinanciamento();
                }catch (Exception e){
                    System.out.print("\n Valor inválido digite novamente");
                }

            }
            String zona = "casa";
            
            Financiamento terreno = new Terreno(valorImovel,prazoFinanciamentoEmAnos,taxaJuros,zona);
            listadeFinanciamentos.add(terreno);

            FileWriter escritor = null;

            try{
                escritor = new FileWriter("nomedoarquivo.txt");
                escritor.write(terreno.toString());
                escritor.flush();
                escritor.close();
            } catch (Exception e) {
                //capturar os erros
            }




        }

        System.out.print("\n *********** Resultados ***********");
        int financimentoIndex = 1;
        for(Financiamento financiamento:listadeFinanciamentos){
            System.out.print("\n ************* Financiamento numero ["+financimentoIndex+"] ****************** ");
            System.out.print("\n valor do imovel: "+ FormatNumbers.twoDecimalNumbers(financiamento.getValorImovel()));
            System.out.print("\n parcela mensal: "+ FormatNumbers.twoDecimalNumbers(financiamento.calcularpagamentomensal()));
            System.out.print("\n valor total do financiamento: "+ FormatNumbers.twoDecimalNumbers(financiamento.calculartotalpagamento()));
            financimentoIndex++;

        }
        System.out.print("\n *********** Fim ***********");

    }
}