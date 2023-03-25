package Parcela;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contrato { // classe onde tera os atributos principais que serao modificados
	private Integer Numero;
	private Date Data;
	private double valorTotal;

	List<Parcelamento> parcelamento = new ArrayList<Parcelamento>();

	public Integer getNumero() {
		return Numero;
	}

	public Contrato() {
	}

	public Contrato(Integer numero, Date data, double valorTotal) {
		Numero = numero;
		Data = data;
		this.valorTotal = valorTotal;
	}

	public void setNumero(Integer numero) {
		Numero = numero;
	}

	public Date getData() {
		return Data;
	}

	public void setData(Date data) {
		Data = data;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public List<Parcelamento> getParcelamento() {
		return parcelamento;
	}

}