package servicos;

public interface ServicoOnlineDePagamento {

	double Taxa(double quantia);

	double juros(double quantia, int meses);

}
