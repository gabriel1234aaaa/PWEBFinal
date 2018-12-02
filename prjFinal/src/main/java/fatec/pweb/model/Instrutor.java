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
	private ArrayList<Turma> turmas = new ArrayList<>();

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

	public void addTurma(Turma turma) {
		turmas.add(turma);
	}

	public void remTurma(Turma turma) {
		int indice = turmas.indexOf(turma);
		if (indice >= 0)
			turmas.remove(indice);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getNome() == null) ? 0 : getNome().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Instrutor other = (Instrutor) obj;
		if (getNome() == null) {
			if (other.getNome() != null)
				return false;
		} else if (!getNome().equals(other.getNome()))
			return false;
		return true;
	}

}
