package servicos;

import java.util.Calendar;
import java.util.Date;

import Parcela.Contrato;
import Parcela.Parcelamento;

public class ServicoDeContrato {

	private ServicoOnlineDePagamento servicoPagamento;

	public ServicoDeContrato(ServicoOnlineDePagamento servicoPagamento) {
		this.servicoPagamento = servicoPagamento;
	}

	public void processoContrato(Contrato contrato, int meses) {
		double parcelaBasica = contrato.getValorTotal() / meses;
		if (contrato.getValorTotal() == 0 ) {
			throw new RuntimeException("erro!!! valor nulo");
		} if (contrato.getValorTotal() < 0) {
			throw new RuntimeException("erro!!! o valor é negativo!!!");
		} if (contrato.getData() == null) {
			throw new RuntimeException("erro!!! data invalida ou nula");
		}
		else {
		// parcelaBasica = vai ser o resultado da divisao entre os meses e o valor total
		for (int i = 1; i <= meses; i++) {
			double taxaAtualizada = parcelaBasica + servicoPagamento.juros(parcelaBasica, i);
			// taxa atualizada = a soma de 1% da taxa
			double taxaTotal = taxaAtualizada + servicoPagamento.Taxa(taxaAtualizada);
			// taxaTotal = a soma de 2% acumulativo do paypal
			Date data = adicionarMeses(contrato.getData(), i);
			//adiciona um I mes ao calendario
			contrato.getParcelamento().add(new Parcelamento(data, taxaTotal));
			//inicia um novo parcelamento com a data modificada e a taxa dos dois juros acumulada
		}
		}
	}

	private Date adicionarMeses(Date data, int N) {
		Calendar calendario = Calendar.getInstance(); // instancia um calendario no modelo dd/MM/yyyy
		calendario.setTime(data); //manda a data para o tempo
		calendario.add(Calendar.MONTH, N); //adiciona um N ao mes
		return calendario.getTime(); //retorna o valor com um mes adicionado
	}

}
