package fatec.pweb.model;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Curso implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private String sigla;
	private String nome;
	private int cargaHoraria;
	private double valor;
	private String dataVigencia;
	private double valorHoraInstrutor;
	private String programa;
	@OneToMany(mappedBy = "curso")
	ArrayList<Turma> turmas = new ArrayList<>();

	public Curso() {
	}

	public Curso(String sigla, String nome) {
		this.sigla = sigla;
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getDataVigencia() {
		return dataVigencia;
	}

	public void setDataVigencia(String dataVigencia) {
		this.dataVigencia = dataVigencia;
	}

	public double getValorHoraInstrutor() {
		return valorHoraInstrutor;
	}

	public void setValorHoraInstrutor(double valorHoraInstrutor) {
		this.valorHoraInstrutor = valorHoraInstrutor;
	}

	public String getPrograma() {
		return programa;
	}

	public void setPrograma(String programa) {
		this.programa = programa;
	}

	public ArrayList<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(ArrayList<Turma> turmas) {
		this.turmas = turmas;
	}

}
