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
		} else {
		// parcelaBasica = 200
		for (int i = 1; i <= meses; i++) {
			double taxaAtualizada = parcelaBasica + servicoPagamento.juros(parcelaBasica, i);
			// taxa atualizada = 202
			double taxaTotal = taxaAtualizada + servicoPagamento.Taxa(taxaAtualizada);
			// taxaTotal = 206.04
			Date data = adicionarMeses(contrato.getData(), i);
			contrato.getParcelamento().add(new Parcelamento(data, taxaTotal));
		}
		}
	}

	private Date adicionarMeses(Date data, int N) {
		Calendar calendario = Calendar.getInstance();
		calendario.setTime(data);
		calendario.add(calendario.MONTH, N);
		return calendario.getTime();
	}

}
