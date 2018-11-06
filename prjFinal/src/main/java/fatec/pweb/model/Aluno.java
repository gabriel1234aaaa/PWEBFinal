package fatec.pweb.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Aluno extends Pessoa {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int codigo;
    private String Escolaridade;
    private Matricula matricula;

	public Matricula getAluno_matricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
        matricula.setAluno(this);
    }
    
    public void setEscolaridade(String Escolaridade) {
        this.Escolaridade = Escolaridade;
    }
    
}
