package fatec.pweb.model;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("I")
public class Instrutor extends Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;
	private String formacao;
	private String areaAtuacao;
	@OneToMany(mappedBy = "instrutor")
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
