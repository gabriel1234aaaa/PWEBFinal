package fatec.pweb.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Matricula {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int codigo;
	private String data;
	private int qtdeFaltas;
	private double nota;
	@OneToOne
	private Aluno aluno;
	@OneToOne
	private APrazo aprazo;
	@OneToOne
	private AVista avista;
	@ManyToOne
	private Turma turma;

	public int getCodigo() {
		return codigo;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public int getQtdeFaltas() {
		return qtdeFaltas;
	}

	public void setQtdeFaltas(int qtdeFaltas) {
		this.qtdeFaltas = qtdeFaltas;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public APrazo getAprazo() {
		return aprazo;
	}

	public void setAprazo(APrazo aprazo) {
		this.aprazo = aprazo;
	}

	public AVista getAvista() {
		return avista;
	}

	public void setAvista(AVista avista) {
		this.avista = avista;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

}
