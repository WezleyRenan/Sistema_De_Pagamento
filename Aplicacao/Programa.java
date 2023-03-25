package Aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import Parcela.Contrato;
import Parcela.Parcelamento;
import servicos.PayPalServico;
import servicos.ServicoDeContrato;
import servicos.ServicoOnlineDePagamento;

public class Programa {

	public static void main(String[] args) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); //MESES TÊM QUE SER EM LETRA MAIUSCULA!!!

		Locale.setDefault(Locale.US); //faz ele ler o ponto e tem que estar antes do scanner
		Scanner input = new Scanner(System.in);

		System.out.println("coloque a data do contrato");
		System.out.println("numero: ");
		Integer numero = input.nextInt(); //inicia o numero do documento
		System.out.println("Data (dd/mm/aaaa) ");
		Date data = sdf.parse(input.next()); //coloca a data inicial e nao pode ser nula
		System.out.println("contrato valor: ");
		double valorTotal = input.nextDouble(); //valor total da parcela que a partir dos meses sera dividida e ira acrescentar os juros

		Contrato contrato = new Contrato(numero, data, valorTotal); //instancia um contrato com os valores

		System.out.println("coloque o numero de parcelas");
		int N = input.nextInt(); //parcelas que sera o numero dos meses a serem adicionados

		ServicoDeContrato sc = new ServicoDeContrato(new PayPalServico()); //instancia um serviço de contrato com o paypalservico dentro

		sc.processoContrato(contrato, N); //utiliza o metodo para fazer a operaçao de adicionar meses e juros

		System.out.println("parcelas: ");
		for (Parcelamento pc : contrato.getParcelamento()) {
			System.out.println(pc); //escreve o arraylist com os juros e meses a serem cobrados
		}

		input.close(); //fecha o scanner para ele nao ser mais lido
	}

}
