package fatec.pweb.model;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("A")
public class Aluno extends Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;
	private String escolaridade;
	@OneToOne(mappedBy = "aluno")
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
