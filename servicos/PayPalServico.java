package servicos;

public class PayPalServico implements ServicoOnlineDePagamento {

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
