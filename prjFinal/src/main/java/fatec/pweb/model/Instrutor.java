package fatec.pweb.model;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Instrutor extends Pessoa {

	private String formacao;
	private String areaAtuacao;
	@OneToMany
	ArrayList<Turma> turmas = new ArrayList<>();

	public Instrutor() {
	}

	public Instrutor(String Nome, String CPF) {
		super(Nome, CPF);
	}

	public String getFormacao() {
		return formacao;
	}

	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}

	public String getAreaAtuacao() {
		return areaAtuacao;
	}

	public void setAreaAtuacao(String areaAtuacao) {
		this.areaAtuacao = areaAtuacao;
	}

	public ArrayList<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(ArrayList<Turma> turmas) {
		this.turmas = turmas;
	}

}
