package servicos;

public class PayPalServico implements ServicoOnlineDePagamento { //classe responsavel por abrigar os juros e os metodos dele

	private static final double taxaPay = 0.02;
	private static final double juroMensal = 0.01;

	@Override
	public double Taxa(double quantia) {
		return quantia * taxaPay;
	}

	@Override
	public double juros(double quantia, int meses) {
		return quantia * meses * juroMensal;
	}

}
