package fatec.pweb.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Aluno extends Pessoa {

	private String escolaridade;
	@OneToOne
	private Matricula matricula;

	public String getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(String escolaridade) {
		this.escolaridade = escolaridade;
	}

	public Matricula getMatricula() {
		return matricula;
	}

	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}

}
