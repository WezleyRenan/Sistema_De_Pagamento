package servicos;

public interface ServicoOnlineDePagamento { //interface que abriga as taxas e juros e implementada em paypalservico

	double Taxa(double quantia);

	double juros(double quantia, int meses);

}
