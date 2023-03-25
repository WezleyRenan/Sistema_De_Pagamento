package Parcela;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Parcelamento { //classe responsavel por formatar e abrigar o arraylist

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	private Date data;
	private double quantia;

	public Parcelamento() {
	}

	public Parcelamento(Date data, double quantia) {
		super();
		this.data = data;
		this.quantia = quantia;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public double getQuantia() {
		return quantia;
	}

	public void setQuantia(double quantia) {
		this.quantia = quantia;
	}

	@Override
	public String toString() {
		return sdf.format(data) + "  -  " + String.format("%.2f", quantia);
	}

}
