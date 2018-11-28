package fatec.pweb.model;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Turma implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private String siglaTurma;
	private String descricao;
	private String datainicio;
	private String dataTermino;
	private String periodo;
	private int qtdeVagas;
	private String observacoes;
	@ManyToOne
	private Instrutor instrutor;
	@ManyToOne
	private Curso curso;
	@OneToMany(mappedBy = "turma")
	ArrayList<Matricula> matriculas = new ArrayList<>();

	public Turma() {
	}

	public Turma(String SiglaTurma, String Descricao) {
		this.siglaTurma = SiglaTurma;
		this.descricao = Descricao;
	}

	public String getSiglaTurma() {
		return siglaTurma;
	}

	public void setSiglaTurma(String siglaTurma) {
		this.siglaTurma = siglaTurma;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDatainicio() {
		return datainicio;
	}

	public void setDatainicio(String datainicio) {
		this.datainicio = datainicio;
	}

	public String getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(String dataTermino) {
		this.dataTermino = dataTermino;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public int getQtdeVagas() {
		return qtdeVagas;
	}

	public void setQtdeVagas(int qtdeVagas) {
		this.qtdeVagas = qtdeVagas;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public Instrutor getInstrutor() {
		return instrutor;
	}

	public void setInstrutor(Instrutor instrutor) {
		this.instrutor = instrutor;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public ArrayList<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(ArrayList<Matricula> matriculas) {
		this.matriculas = matriculas;
	}

}
