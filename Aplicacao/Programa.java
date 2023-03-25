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

		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");

		Locale.setDefault(Locale.ENGLISH);
		Scanner input = new Scanner(System.in);

		System.out.println("coloque a data do contrato");
		System.out.println("numero: ");
		Integer numero = input.nextInt();
		System.out.println("Data (dd/mm/aaaa) ");
		Date data = sdf.parse(input.next());
		System.out.println("contrato valor: ");
		double valorTotal = input.nextDouble();

		Contrato contrato = new Contrato(numero, data, valorTotal);

		System.out.println("coloque o numero de parcelas");
		int N = input.nextInt();

		ServicoDeContrato sc = new ServicoDeContrato(new PayPalServico());

		sc.processoContrato(contrato, N);

		System.out.println("parcelas: ");
		for (Parcelamento pc : contrato.getParcelamento()) {
			System.out.println(pc);
		}

		input.close();
	}

}
