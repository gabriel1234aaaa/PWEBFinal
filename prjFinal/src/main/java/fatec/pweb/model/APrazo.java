package fatec.pweb.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class APrazo {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int codigo;
	private double valor;
	private String dtVencimento;
	private double taxaJuros;
	private int qtdeMensalidade;

	public int getCodigo() {
		return codigo;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getDtVencimento() {
		return dtVencimento;
	}

	public void setDtVencimento(String dtVencimento) {
		this.dtVencimento = dtVencimento;
	}

	public double getTaxaJuros() {
		return taxaJuros;
	}

	public void setTaxaJuros(double taxaJuros) {
		this.taxaJuros = taxaJuros;
	}

	public int getQtdeMensalidade() {
		return qtdeMensalidade;
	}

	public void setQtdeMensalidade(int qtdeMensalidade) {
		this.qtdeMensalidade = qtdeMensalidade;
	}

}
